package com.ggiriggiri.web.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/study/")
public class StudyController {

	@RequestMapping("list")
	public String list() {
		return "admin.study.list";
	}
}
