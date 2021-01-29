package com.ggiriggiri.web.controller.admin;

import java.util.List;
import java.util.Random;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ggiriggiri.web.entity.Member;
import com.ggiriggiri.web.entity.Profile;
import com.ggiriggiri.web.service.MemberService;

@Controller("adminMemberController")
@RequestMapping("/admin/member/")
public class MemberController {
	
	@Autowired
	private MemberService service;
	
	@RequestMapping("list")
	public String list(Model model) {
		
		List<Member> list = service.getList();
		model.addAttribute("list", list);
		
		return "admin.member.list";
	}
	
	@GetMapping("{id}")
	public String detail(@PathVariable("id") Integer id,Model model) {
		
		Member m = service.get(id);
		Profile p = m.getProfile();
		
		model.addAttribute("m",m);
		model.addAttribute("p",p);
		
		return "admin.member.popup.detail";
	}
	
	@GetMapping("{id}/project")
	public String detailProject(@PathVariable("id") Integer id,Model model) {
		
		Member m = service.get(id);
		Profile p = m.getProfile();
		
		model.addAttribute("m",m);
		model.addAttribute("p",p);
		
		return "admin.member.popup.project";
	}
	
	@GetMapping("{id}/study")
	public String detailStudy(@PathVariable("id") Integer id,Model model) {
		
		Member m = service.get(id);
		Profile p = m.getProfile();
		
		model.addAttribute("m",m);
		model.addAttribute("p",p);
		
		return "admin.member.popup.study";
	}
	
	@GetMapping("{id}/exper")
	public String detailExper(@PathVariable("id") Integer id,Model model) {
		
		Member m = service.get(id);
		Profile p = m.getProfile();
		
		model.addAttribute("m",m);
		model.addAttribute("p",p);
		
		return "admin.member.popup.exper";
	}

}
