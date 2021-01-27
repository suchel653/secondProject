package com.ggiriggiri.web.controller.customer;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customer/activity/")
public class ActivityController {
	
	@RequestMapping("index")
	public String index() {
		return "customer.activity.index";
	}

}
