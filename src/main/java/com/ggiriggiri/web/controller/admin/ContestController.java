package com.ggiriggiri.web.controller.admin;

import java.security.Principal;
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

import com.ggiriggiri.web.entity.Contest;
import com.ggiriggiri.web.service.ContestService;

@Controller
@RequestMapping("/admin/contest/")
public class ContestController {
	
	@Autowired
	private ContestService service;
	
	@RequestMapping("list")
	public String list(
			@RequestParam(name = "p", defaultValue = "1") int page,
			@RequestParam(name = "f", defaultValue = "title") String field,
			@RequestParam(name = "q", defaultValue = "") String query,
			Model model) {
		
		int size = 10;
		
		List<Contest> list = service.getList(page, size, field, query);
		
		int count = service.getCount(field, query);
		
		int pageCount = (int) Math.ceil(count / (float)size);
		
		model.addAttribute("list",list);
		model.addAttribute("pageCount",pageCount);
		
		return "admin.contest.list";
	}
	
	@GetMapping("reg")
	public String reg() {
		
		return "admin.contest.reg";
	}
	
	@PostMapping("reg")
	public String reg(
			@RequestParam("startDate") String oldStartDate,
			@RequestParam("endDate") String oldEndDate,
			@RequestParam("title") String title,
			@RequestParam("content") String content
			) throws ParseException {
	
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		Date startDate = sdf.parse(oldStartDate);
		Date endDate = sdf.parse(oldEndDate);
		
		Contest contest = new Contest("aaa",title,content,startDate,endDate);
		
		service.insert(contest);
		
		return "redirect:list";
	}

	@GetMapping("{id}")
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
	public String edit(
			@PathVariable("id") int id,
			@RequestParam("startDate") String oldStartDate,
			@RequestParam("endDate") String oldEndDate,
			@RequestParam("title") String title,
			@RequestParam("content") String content) throws ParseException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		Date startDate = sdf.parse(oldStartDate);
		Date endDate = sdf.parse(oldEndDate);
		
		Contest contest = new Contest("aaa",title,content,startDate,endDate);
		contest.setId(id);
		
		service.update(contest);
		
		return "redirect:../"+id;
	}
	
	@GetMapping("{id}/del")
	public String del(@PathVariable("id") int id) {
		
		service.delete(id);
		
		return "redirect../list";
	}
	
	
}
