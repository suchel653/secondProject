package com.ggiriggiri.web.controller.admin;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ggiriggiri.web.entity.Study;
import com.ggiriggiri.web.service.StudyService;


@Controller
@RequestMapping("/admin/study/")
public class StudyController {
	@Autowired
	private StudyService service;
	
	@RequestMapping("list")
	public String list(@RequestParam(name="p", defaultValue = "1") int page,
			@RequestParam(name="f", defaultValue = "title") String field,
			@RequestParam(name="q", defaultValue = "") String query,
			Model model) {
		int size = 10;
		List<Study> list =service.getList(page, size, field, query);
		model.addAttribute("list",list);
		return "admin.study.list";
				
	}
	


	
	@RequestMapping("field")
	public String field() {
		return "admin.study.field";
	}
	
	@RequestMapping("skill")
	public String skill() {
		return "admin.study.skill";
	}
	
	@RequestMapping("language")
	public String language() {
		return "admin.study.language";
	}
}
