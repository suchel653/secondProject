package com.ggiriggiri.web.controller.customer;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ggiriggiri.web.entity.Profile;
import com.ggiriggiri.web.service.ProfileService;




@Controller
@RequestMapping("/customer/profile/")
public class ProfileController {
	
	@Autowired
	private ProfileService service;
	
	@RequestMapping("{id}")
	public String profilePage (@PathVariable("id") int id, HttpSession session, Model model) {
		int memberId = (int) session.getAttribute("id");
		Profile profile = service.get(memberId);
		model.addAttribute("p", profile);
		return "customer.profile.page";
	}
	
	@PostMapping("reg")
	public void reg(HttpSession session) {
		int memberId = (int) session.getAttribute("id");
		System.out.println(memberId);

		Profile profile = new Profile();
		profile.setMemberId(memberId);
		service.insert(profile);		
	}
}
