package com.ggiriggiri.web.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ggiriggiri.web.entity.Field;
import com.ggiriggiri.web.entity.Language;
import com.ggiriggiri.web.entity.Project;
import com.ggiriggiri.web.entity.ProjectView;
import com.ggiriggiri.web.entity.Skill;
import com.ggiriggiri.web.entity.StudyView;
import com.ggiriggiri.web.service.FieldService;
import com.ggiriggiri.web.service.LanguageService;
import com.ggiriggiri.web.service.ProjectService;
import com.ggiriggiri.web.service.SkillService;

@Controller
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
			Model model) {
		
		int size = 10;
		List<ProjectView> list =service.getViewList(page,size,title,query,field,skill,language);
		
		int count = service.getCount(title,query);
		int pageCount = (int)Math.ceil(count / (float)size);
		
		model.addAttribute("page", page);
		model.addAttribute("pageCount", pageCount);
		
		List<Field> fdList = fdService.getList(1, 10);
		List<Skill> skList = skService.getList(1, 10);
		List<Language> lgList = lgService.getList(1, 10);
		
		model.addAttribute("f", fdList);
		model.addAttribute("s", skList);
		model.addAttribute("l", lgList);
		model.addAttribute("list", list);
		
		return "admin.project.list";
	}
	
	@RequestMapping("{id}") 
	public String detail(Model model, @PathVariable("id") int id) {
		
		Project project = service.get(id);
		
		model.addAttribute("pj",project);
		
		return "admin.project.detail";
	}
	
}
