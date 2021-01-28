package com.ggiriggiri.web.controller.customer.activity.group;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("groupProjectController")
@RequestMapping("/customer/activity/group/project/{id}/")
public class ProjectController {
	
	@RequestMapping("index")
	public String index() {
		
//		service.get(id);
//		model
		return "customer.activity.group.project.index";
		
	}

}
