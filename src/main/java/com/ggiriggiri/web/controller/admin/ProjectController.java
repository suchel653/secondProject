package com.ggiriggiri.web.controller.admin;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.javassist.expr.Instanceof;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.ggiriggiri.web.entity.Field;
import com.ggiriggiri.web.entity.Language;
import com.ggiriggiri.web.entity.Project;
import com.ggiriggiri.web.entity.ProjectFile;
import com.ggiriggiri.web.entity.ProjectLanguage;
import com.ggiriggiri.web.entity.ProjectSkill;
import com.ggiriggiri.web.entity.ProjectView;
import com.ggiriggiri.web.entity.Skill;
import com.ggiriggiri.web.service.FieldService;
import com.ggiriggiri.web.service.LanguageService;
import com.ggiriggiri.web.service.ProjectService;
import com.ggiriggiri.web.service.SkillService;

@Controller("adminProjectController")
@RequestMapping("/admin/project/")
public class ProjectController {

	@Autowired
	private ProjectService service;
	@Autowired
	private FieldService fdService;
	@Autowired
	private SkillService skService;
	@Autowired
	private LanguageService lgService;
	
	@RequestMapping("list")
	public String list(@RequestParam(name="p", defaultValue = "1") int page,
			@RequestParam(name="f", defaultValue = "") String[] field,
			@RequestParam(name="s", defaultValue = "") String[] skill,
			@RequestParam(name="l", defaultValue = "") String[] language,
			@RequestParam(name="t", defaultValue="title") String title, 
			@RequestParam(name="q", defaultValue = "") String query,
			@RequestParam(name="size", defaultValue = "10") int size,
			Model model) {
		
		List<ProjectView> list = service.getViewList(page,size,title,query,field,skill,language);
		
		
		
		int count = service.getCount(title, query, field, skill, language);
		int pageCount = (int)Math.ceil(count / (float)size);
		
		model.addAttribute("page", page);
		model.addAttribute("pageCount", pageCount);
		
		List<Field> fdList = fdService.getList(1, 100);
		List<Skill> skList = skService.getList(1, 100);
		List<Language> lgList = lgService.getList(1, 100);
		
		model.addAttribute("f", fdList);
		model.addAttribute("s", skList);
		model.addAttribute("l", lgList);
		
		model.addAttribute("list", list);
		
		return "admin.project.list";
	}
	
	
	
	@GetMapping("{id}") 
	public String detail(Model model, @PathVariable("id") int id) {
		
		ProjectView project = service.getView(id);
		ProjectView prev = service.getPrev(id);
		ProjectView next = service.getNext(id);
		
		model.addAttribute("prev",prev);
		model.addAttribute("next",next);
		model.addAttribute("pj",project);
		
		return "admin.project.detail";
	}
	
	
	
	@GetMapping("{id}/del") 
	public String delete(@PathVariable("id") int id) {
		
		service.delete(id);
		
		return "redirect:../list";
	}
	
	@GetMapping("{id}/edit") 
	public String edit(Model model, @PathVariable("id") int id) throws ParseException {
		
		
		List<Field> fdList = fdService.getList(1, 100);
		List<Skill> skList = skService.getList(1, 100);
		List<Language> lgList = lgService.getList(1, 100);
		
		model.addAttribute("f", fdList);
		model.addAttribute("s", skList);
		model.addAttribute("l", lgList);
		
		
		ProjectView project = service.getView(id);
		
		model.addAttribute("pj",project);
		
		return "admin.project.edit";
	}
	
	@PostMapping("{id}/edit") 
	public String edit(@PathVariable("id") int id,
			@RequestParam("title") String title,
			@RequestParam("content") String content,
			@RequestParam("limitNumber") int limitNumber,
			@RequestParam("requirement") String requirement,
			@RequestParam("startDate") String oldStartDate,
			@RequestParam("endDate") String oldEndDate,
			@RequestParam("status") int statusId,
			@RequestParam("field") int fieldId,
			@RequestParam("skill") int[] skill,
			@RequestParam("language") int[] language,
			@RequestParam("oldSkills") int[] oldSkillIds,
			@RequestParam("oldSLanguages") int[] oldSLanguageIds,
			@RequestParam("oldFiles") String[] oldFileNames,
			MultipartHttpServletRequest mpfReauest,
			Model model) throws IllegalStateException, IOException, ParseException {
		
		int projectId = id;
		System.out.println("플젝아이디"+projectId);
		
		
		//----old skillId, new skillId
		int[] osIds = new int[oldSkillIds.length];
		for (int i=0; i<oldSkillIds.length; i++) {
			osIds[i] = oldSkillIds[i];
			System.out.println( "올드 스킬 아이디 : "+osIds[i]);
		}
		
		int[] sIds = new int[skill.length];
		for(int i=0; i<skill.length; i++) {
			sIds[i]=skill[i];
			System.out.println( "뉴 스킬 아이디 : "+sIds[i]);
		}
		
		//----old languageId, new languageId
		int[] olIds = new int[oldSLanguageIds.length];
		for (int i=0; i<oldSLanguageIds.length; i++) {
			olIds[i] = oldSLanguageIds[i];
			System.out.println( "올드 언어 아이디 : "+olIds[i]);
		}
		
		int[] lIds = new int[language.length];
		for(int i=0; i<language.length; i++) {
			lIds[i]=language[i];
			System.out.println( "뉴 언어 아이디 : "+lIds[i]);
		}
		
		
		//----skill, language update
		for(int i=0; i<skill.length; i++) {
			
			int sId = service.getSkillId(projectId, osIds[i]);
			ProjectSkill pk = new ProjectSkill(sId,projectId,sIds[i]);
			System.out.println("해당 플젝 스킬"+pk);
			
			if(pk!=null)
				service.updateSkill(pk);
		}
		
		for(int i=0; i<language.length; i++) {
			
			int lId = service.getLanguageId(projectId, olIds[i]);
			ProjectLanguage pl = new ProjectLanguage(lId,projectId,lIds[i]);
			System.out.println("해당 플젝 언어"+pl);
			
			if(pl!=null)
				service.updateLanguage(pl);
		}
		
		//-----date format
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date startDate = sdf.parse(oldStartDate);
		Date endDate = sdf.parse(oldEndDate);
		
		//-----file upload
		MultipartFile img = mpfReauest.getFile("image");
		List<MultipartFile> fileList = mpfReauest.getFiles("files");
		
		String url = "/images/";
		String realPath = mpfReauest.getServletContext().getRealPath(url);
		
		String imgPath = realPath + "projectImg/";
		String filePath = realPath + "projectFile/";
		
		File realPathImg = new File(imgPath);
		File realPathFile = new File(filePath);
		
		if(!realPathImg.exists())
			realPathImg.mkdir();
		
		if(!realPathFile.exists())
			realPathFile.mkdir();
		
		String imgFile = imgPath+File.separator+img.getOriginalFilename();
		img.transferTo(new File(imgFile));
		
		
		String[] ofNames = new String[oldFileNames.length];
		for (int i=0; i<oldFileNames.length; i++) {
			ofNames[i] = oldFileNames[i];
			System.out.println( "올드 파일 name : "+ofNames[i]);
		}
		String[] newFileNames = new String[fileList.size()];
		int k = 0;
		for(MultipartFile mf : fileList) {
			
			newFileNames[k] = mf.getOriginalFilename();
			String file = filePath + File.separator + mf.getOriginalFilename();
			mf.transferTo(new File(file));
			
			System.out.println("뉴 파일 이름"+newFileNames[k]);
			k++;
		}
		for(int j = 0; j<newFileNames.length; j++) {
			
			int fId = service.getFileId(projectId, ofNames[j]);
			System.out.println("파일아이디"+fId);
			ProjectFile projectFile = new ProjectFile(fId,projectId,newFileNames[j]);
			System.out.println(projectFile);
			
			service.updateFile(projectFile);
		}
		
		String image = img.getOriginalFilename();
		
		
		//----project update
		Project p = new Project(projectId,title,content,limitNumber,requirement,startDate,endDate,statusId,fieldId,image);
		
		service.update(p);
		
		ProjectView project = service.getView(id);
		ProjectView prev = service.getPrev(id);
		ProjectView next = service.getNext(id);
		 
		
		model.addAttribute("prev",prev);
		model.addAttribute("next",next);
		model.addAttribute("pj",project);
		
		
		
		return  "redirect:../"+id;
	}
	
	
	
	
	
}
