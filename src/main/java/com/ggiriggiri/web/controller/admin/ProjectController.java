package com.ggiriggiri.web.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ggiriggiri.web.entity.Project;
import com.ggiriggiri.web.service.ProjectService;

@Controller
@RequestMapping("/admin/project/")
public class ProjectController {

	@Autowired
	private ProjectService service;
	
	@RequestMapping("list")
	public String list(@RequestParam(name="p", defaultValue = "1") int page,
			@RequestParam(name="f", defaultValue = "title") String field,
			@RequestParam(name="q", defaultValue = "") String query,
			Model model) {
		
		int size = 10;
		List<Project> list = service.getList(page, size, field, query);
		
		int count = service.getCount(field,query);
		int pageCount = (int)Math.ceil(count / (float)size);
		
		model.addAttribute("page", page);
		model.addAttribute("pageCount", pageCount);
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
