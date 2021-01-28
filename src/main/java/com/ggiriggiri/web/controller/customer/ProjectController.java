package com.ggiriggiri.web.controller.customer;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.ggiriggiri.web.entity.Field;
import com.ggiriggiri.web.entity.Language;
import com.ggiriggiri.web.entity.Project;
import com.ggiriggiri.web.entity.ProjectView;
import com.ggiriggiri.web.entity.Skill;
import com.ggiriggiri.web.service.FieldService;
import com.ggiriggiri.web.service.LanguageService;
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
		
		model.addAttribute("page", page);
		model.addAttribute("pageCount", pageCount);
		
		List<Field> fdList = fdService.getList(1, 100);
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
	public String reg() {
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
			@RequestParam("image") String image,
			MultipartHttpServletRequest mtfRequest) throws ParseException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		Date startDate = sdf.parse(oldStartDate);
		Date endDate = sdf.parse(oldEndDate);
		
		int newId = service.getLastId()+1;
		
		Project project = new Project(newId,title,content,startDate,endDate,limitNumber,image,requirement,fieldId);
		service.insert(project);
		
		
		return "redirect:list";
	}
	
}
