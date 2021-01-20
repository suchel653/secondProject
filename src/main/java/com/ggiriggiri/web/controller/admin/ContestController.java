package com.ggiriggiri.web.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ggiriggiri.web.entity.Contest;

@Controller
@RequestMapping("/admin/contest/")
public class ContestController {
	
	@RequestMapping("list")
	public String list() {
		
		return "admin.contest.list";
	}
	
	@GetMapping("reg")
	public String reg() {
		
		return "admin.contest.reg";
	}
	
	@PostMapping("reg")
	public String reg(Contest contest) {
		
		return "admin.contest.list";
	}

	@RequestMapping("{id}")
	public String detail(Model model,@PathVariable("id") Integer id) {
		
		
		
		return "admin.contest.detail";
	}

	@GetMapping("edit")
	public String getEdit(Contest contest) {
		
		return "admin.contest.edit";
	}
	
	@PostMapping("edit")
	public String postEdit(Contest contest) {
		
		return "admin.contest.detail";
	}
	
	
}
