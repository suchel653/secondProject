package com.ggiriggiri.web.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ggiriggiri.web.entity.Skill;
import com.ggiriggiri.web.service.SkillService;

@Controller
@RequestMapping("/admin/category/skill")
public class SkillContoroller {
	
	@Autowired
	private SkillService service;
	
	@RequestMapping("")
	public String list(@RequestParam(name="p", defaultValue = "1") int page, Model model) {
		
		int size = 10;
		List<Skill> list = service.getList(page, size);
		model.addAttribute("list",list);
		
		return "admin.category.skill";
	}

}
