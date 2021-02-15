package com.ggiriggiri.web.controller.customer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ggiriggiri.web.entity.Contest;
import com.ggiriggiri.web.service.ContestService;

@Controller
@RequestMapping("/customer/contest/")
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
		
		return "customer.contest.list";
	}
	
	@GetMapping("{id}")
	public String detail( Model model,@PathVariable("id") Integer id ) {
		
		Contest c = service.get(id);
		c.setHit(c.getHit()+1);
//		service.update(c);
		Contest prev = service.getPrev(id);
		Contest next = service.getNext(id);

		model.addAttribute("c", c);
		model.addAttribute("prev", prev);
		model.addAttribute("next", next);
 
		return "customer.contest.detail";
	}
}
