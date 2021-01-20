package com.ggiriggiri.web.controller.admin;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ggiriggiri.web.entity.Contest;
import com.ggiriggiri.web.service.ContestService;

@Controller
@RequestMapping("/admin/contest/")
public class ContestController {
	
	@Autowired
	private ContestService service;
	
	@RequestMapping("list")
	public String list(Model model) {
		
		List<Contest> list = service.getList(1, 10, "title", "");
		
		model.addAttribute("list",list);
		
		return "admin.contest.list";
	}
	
	@GetMapping("reg")
	public String reg() {
		
		return "admin.contest.reg";
	}
	
	@PostMapping("reg")
	public String reg(Contest contest) {
	
		service.insert(contest);
		
		return "admin.contest.list";
	}

	@RequestMapping("{id}")
	public String detail(Model model,@PathVariable("id") Integer id) {
		
		Contest c = service.get(id);
		
		model.addAttribute("c",c);
		
		return "admin.contest.detail";
	}

	@GetMapping("{id}/edit")
	public String edit(Model model,@PathVariable("id") int id) {
		
		Contest c = service.get(id);
		model.addAttribute("c",c);
		
		return "admin.contest.edit";
	}
	
	@PostMapping("{id}/edit")
	public String edit(Contest contest) {
		
		return "redirect:../"+contest.getId();
	}
	
	
}
