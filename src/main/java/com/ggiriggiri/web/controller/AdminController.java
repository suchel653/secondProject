package com.ggiriggiri.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/")
public class AdminController {
	
	@RequestMapping("index")
	public String index() {
		return "home.admin.index";
		
	}

	@RequestMapping("login")
	public String login() {
		return "home.admin.login";
		
	}
}
