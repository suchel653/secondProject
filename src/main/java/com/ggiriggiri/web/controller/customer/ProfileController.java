package com.ggiriggiri.web.controller.customer;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customer/profile/")
public class ProfileController {

	@RequestMapping("page")
	public String page() {
		
		return "customer.profile.page";
	}
	
}
