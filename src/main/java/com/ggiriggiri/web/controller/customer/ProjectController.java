package com.ggiriggiri.web.controller.customer;

import java.io.File;
import java.io.IOException;
import java.security.Principal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.ggiriggiri.web.entity.Field;
import com.ggiriggiri.web.entity.Language;
import com.ggiriggiri.web.entity.Member;
import com.ggiriggiri.web.entity.Project;
import com.ggiriggiri.web.entity.ProjectApply;
import com.ggiriggiri.web.entity.ProjectFile;
import com.ggiriggiri.web.entity.ProjectLanguage;
import com.ggiriggiri.web.entity.ProjectSkill;
import com.ggiriggiri.web.entity.ProjectView;
import com.ggiriggiri.web.entity.Skill;
import com.ggiriggiri.web.service.FieldService;
import com.ggiriggiri.web.service.LanguageService;
import com.ggiriggiri.web.service.MemberService;
import com.ggiriggiri.web.service.ProjectApplyService;
import com.ggiriggiri.web.service.ProjectService;
import com.ggiriggiri.web.service.SkillService;

@Controller
@RequestMapping("/customer/project/")
public class ProjectController {

	@Autowired
	private ProjectService service;
	@Autowired
	private FieldService fdService;
	@Autowired
	private SkillService skService;
	@Autowired
	private LanguageService lgService;
	@Autowired
	private ProjectApplyService paService;
	@Autowired
	private MemberService mService;
	
	@GetMapping("list")
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
		if(pageCount==0)
			pageCount=1;
		
		model.addAttribute("page", page);
		model.addAttribute("size", size);
		model.addAttribute("pageCount", pageCount);
		
		List<Field> fdList = fdService.getList();
		List<Skill> skList = skService.getList(1, 100);
		List<Language> lgList = lgService.getList(1, 100);
		
		model.addAttribute("f", fdList);
		model.addAttribute("s", skList);
		model.addAttribute("l", lgList);
		
		model.addAttribute("list", list);
		return "customer.project.list";
	}


	@GetMapping("{id}")
	public String detail(@PathVariable("id") int id, Model model) {
		
		ProjectView pv = service.getView(id);
		ProjectView prev = service.getPrev(id);
		ProjectView next = service.getNext(id);
		
		model.addAttribute("prev",prev);
		model.addAttribute("next",next);
		model.addAttribute("pv",pv);
		
		return "customer.project.detail";
		
	}

	
	@GetMapping("reg")
	public String reg(Model model,
			@RequestParam(name="field", defaultValue = "") String[] field,
			@RequestParam(name="skill", defaultValue = "") String[] skill,
			@RequestParam(name="language", defaultValue = "") String[] language) {
		
		List<Field> fdList = fdService.getList(1, 100);
		List<Skill> skList = skService.getList(1, 100);
		List<Language> lgList = lgService.getList(1, 100);
		
		model.addAttribute("f", fdList);
		model.addAttribute("s", skList);
		model.addAttribute("l", lgList);
		
		return "customer.project.reg";
		
	}
	
	@PostMapping("reg")
	public String reg(@RequestParam("limitNumber") int limitNumber,
			@RequestParam("startDate") String oldStartDate,
			@RequestParam("endDate") String oldEndDate,
			@RequestParam("title") String title,
			@RequestParam("content") String content,
			@RequestParam("requirement") String requirement,
			@RequestParam("field") int fieldId,
			@RequestParam("skill") int[] skill,
			@RequestParam("language") int[] language,
			Authentication authentication,
			MultipartHttpServletRequest mtfRequest) throws ParseException, IllegalStateException, IOException {

		
		//---- date format
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		Date startDate = sdf.parse(oldStartDate);
		Date endDate = sdf.parse(oldEndDate);
		
		
		
		//----- file, image 경로
		int newId = service.getLastId()+1;
		
		MultipartFile img = mtfRequest.getFile("image");
		List<MultipartFile> fileList = mtfRequest.getFiles("files");

		String url = "/images/";
		String realPath = mtfRequest.getServletContext().getRealPath(url);
		
		
		String image="img1.jpg";
		if(!img.getOriginalFilename().equals("")) {
		
			String imgPath = realPath + "projectImg/";
			File realPathImgFile = new File(imgPath);
			
			if (!realPathImgFile.exists())
				realPathImgFile.mkdir();
			
			String imgFile = imgPath + File.separator + img.getOriginalFilename();
			img.transferTo(new File(imgFile));
			
			image = img.getOriginalFilename();
		}
		
		
		if(!fileList.get(0).getOriginalFilename().equals("")) {
			String filePath = realPath + "projectFile/";
			File realPathFile = new File(filePath);
			
			if (!realPathFile.exists())
				realPathFile.mkdir();
			
			for(MultipartFile mf : fileList) {
				String file = filePath + File.separator + mf.getOriginalFilename();
				mf.transferTo(new File(file));

				ProjectFile projectFile = new ProjectFile(newId,mf.getOriginalFilename());
				service.insertFile(projectFile);
			}
			
		}
		
		//----- login 유저
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		String username = userDetails.getUsername(); 
		
		Member m = mService.get(username);
		int leaderId = m.getId();
		
		
		
		

		//----- project, skill, language insert
		Project project = new Project(newId,title,content,startDate,endDate,limitNumber,image,requirement,fieldId,leaderId);
		service.insert(project);
		
		
		for(int skillId : skill) {
			ProjectSkill pk = new ProjectSkill(newId,skillId);
			service.insertSkill(pk);
		}
		
		for(int languageId : language) {
			ProjectLanguage pl = new ProjectLanguage(newId,languageId);
			service.insertLanguage(pl);
		}
			
		
		return "redirect:list";
	}
	
	
}
