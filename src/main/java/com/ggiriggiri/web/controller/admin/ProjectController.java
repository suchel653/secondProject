package com.ggiriggiri.web.controller.admin;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

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
			@RequestParam("limitNumber") int limitNumber,
			@RequestParam("requirement") String requirement,
			@RequestParam("startDate") Date startDate,
			@RequestParam("endDate") Date endDate,
			@RequestParam("status") int statusId,
			@RequestParam("field") int fieldId,
			@RequestParam("skill") int[] skill,
			@RequestParam("language") int[] language,
			MultipartHttpServletRequest mpfReauest,
			Model model) throws IllegalStateException, IOException {
		
		//-----file upload
		MultipartFile img = mpfReauest.getFile("image");
		List<MultipartFile> fileList = mpfReauest.getFiles("files");
		
		String url = "/images/";
		String realPath = mpfReauest.getServletContext().getRealPath(url);
		
		String imgPath = realPath + "projectImg/";
		String filePath = realPath + "projecFile/";
		
		File realPathImg = new File(imgPath);
		File realPathFile = new File(filePath);
		
		if(!realPathImg.exists())
			realPathImg.mkdir();
		
		if(!realPathFile.exists())
			realPathFile.mkdir();
		
		String imgFile = imgPath+File.separator+img.getOriginalFilename();
		img.transferTo(new File(imgFile));
		
		String image = img.getOriginalFilename();
		
		
		Project p = new Project(title,limitNumber,requirement,startDate,endDate,statusId,fieldId,image);
		
		int projectId = id;
		
//		for(MultipartFile mf : fileList) {
//			String file = filePath + File.separator + mf.getOriginalFilename();
//			mf.transferTo(new File(file));
//			
//			ProjectFile projectFile = new ProjectFile(fileId,projectId,mf.getOriginalFilename());
//			service.updateFile(projectFile);
//		}
		
		//service.update(p);
		
		ProjectView project = service.getView(id);
		ProjectView prev = service.getPrev(id);
		ProjectView next = service.getNext(id);
		
		
		model.addAttribute("prev",prev);
		model.addAttribute("next",next);
		model.addAttribute("pj",project);
		
		
		
		return "rediredt:../"+id;
	}
	
	
	
	
	
}
