package com.ggiriggiri.web.controller.customer.activity.group;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("groupStudyController")
@RequestMapping("/customer/activity/group/study/{id}/")
public class StudyController {

	@GetMapping("index")
	public String index() {
		return "asdas";
	}

}