package com.ggiriggiri.web.controller.customer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ggiriggiri.web.entity.Field;
import com.ggiriggiri.web.entity.Language;
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
	
}
