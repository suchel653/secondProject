package com.ggiriggiri.web.controller.customer;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customer/study/")
public class StudyController {
	
	@RequestMapping("list")
	public String list() {
		return "customer.study.list";
		
	}

	@RequestMapping("reg")
	public String reg() {
		return "customer.study.reg";
		
	}
	
}
