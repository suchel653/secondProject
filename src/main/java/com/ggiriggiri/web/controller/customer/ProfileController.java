package com.ggiriggiri.web.controller.customer;

import java.util.ArrayList;
import java.util.HashMap;
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

import com.ggiriggiri.web.entity.Member;
import com.ggiriggiri.web.entity.Profile;
import com.ggiriggiri.web.entity.ProfileLanguage;
import com.ggiriggiri.web.entity.ProfileLanguageView;
import com.ggiriggiri.web.entity.ProfileSkillView;
import com.ggiriggiri.web.service.MemberService;
import com.ggiriggiri.web.service.ProfileService;




@Controller
@RequestMapping("/customer/profile/")
public class ProfileController {
	
	@Autowired
	private ProfileService profileService;
	@Autowired
	private MemberService memberService;
	
	
	@RequestMapping("{id}")
	public String profilePage (@PathVariable("id") int id, HttpSession session, Model model) {
		int memberId = (int) session.getAttribute("id");
		int mypage = 0;
		if(memberId == id) {
			mypage = 1;
		}
		Profile profile = profileService.get(id);
		Member member = memberService.get(id);
		model.addAttribute("p", profile);
		model.addAttribute("m", member);
		model.addAttribute("mypage", mypage);
		return "customer.profile.page";
	}
	
	@PostMapping("update")
	public void update(HttpSession session, @RequestBody Map<String,Object> payload) {
		int memberId = (int) session.getAttribute("id");
		Member member = memberService.get(memberId);
		Profile profile = profileService.get(memberId);
		String nickname = (String) payload.get("nicknameValue");
		String introduction = (String) payload.get("introduce");
		
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
		
		List<String> skill = (List<String>) payload.get("skillLevel");
		List<ProfileSkillView> skillLevelList = new ArrayList<>();
		int skillId = 0;
		for(String level:skill) {
			skillId++;
			ProfileSkillView skillLevel = new ProfileSkillView();
			skillLevel.setLevel(Integer.parseInt(level));
			skillLevel.setSkillId(skillId);
			skillLevelList.add(skillLevel);
		}
		
		member.setNickname(nickname);
		profile.setIntroduction(introduction);
		profile.setLanguageList(languageLevelList);
		profile.setSkillList(skillLevelList);
		memberService.update(member);
		profileService.update(profile);
		
	}
	
	@PostMapping("getId")
	@ResponseBody
	public Map<String,Object> getId(HttpSession session){
		int memberId = (int) session.getAttribute("id");
		Map<String,Object> payload = new HashMap<String, Object>();
		payload.put("memberId", memberId);
		return payload;
	}
	
	@PostMapping("reg")
	public void reg(HttpSession session) {
		int memberId = (int) session.getAttribute("id");
		System.out.println("멤버 아이디"+memberId);
		Profile profile = new Profile();
		profile.setMemberId(memberId);
		profileService.insert(profile);		
	}
}
