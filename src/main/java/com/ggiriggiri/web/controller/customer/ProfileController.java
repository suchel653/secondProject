package com.ggiriggiri.web.controller.customer;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ggiriggiri.web.entity.Profile;
import com.ggiriggiri.web.entity.ProfileLanguage;
import com.ggiriggiri.web.entity.ProfileLanguageView;
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
	
	@PostMapping("update")
	public void update(HttpSession session, @RequestBody Map<String,Object> payload) {
		int memberId = (int) session.getAttribute("id");
		Profile profile = service.get(memberId);
		List<String> language = (List<String>) payload.get("languageLevel");
		List<ProfileLanguageView> languageLevelList = new ArrayList<>();
		int languageId = 0;
		for(String level:language) {
			languageId++;
			ProfileLanguageView languageLevel = new ProfileLanguageView();
			languageLevel.setLevel(Integer.parseInt(level));
			languageLevel.setLanguagerId(languageId);
			languageLevelList.add(languageLevel);
		}
		
		profile.setLanguageList(languageLevelList);
		service.update(profile);
	}
	
	@PostMapping("reg")
	public void reg(HttpSession session) {
		int memberId = (int) session.getAttribute("id");
		System.out.println("멤버 아이디"+memberId);
		Profile profile = new Profile();
		profile.setMemberId(memberId);
		service.insert(profile);		
	}
}
