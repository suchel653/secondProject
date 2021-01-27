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
import com.ggiriggiri.web.service.MemberService;

@Controller
@RequestMapping("/admin/member/")
public class MemberController {
	
	@Autowired
	private MemberService service;
	
	@Autowired
	private JavaMailSender mailSender;
	
	@RequestMapping("list")
	public String list(Model model) {
		
		List<Member> list = service.getList();
		model.addAttribute("list", list);
		
		return "admin.member.list";
	}
	
	@GetMapping("reg")
	public String reg() {
		
		return "admin.member.reg";
	}
	
	@PostMapping("reg")
	public String reg(String email, String password, String nickname) {
		Member member = new Member();
		member.setEmail(email);
		member.setPassword(password);
		member.setNickname(nickname);
		System.out.println(member);
		service.insert(member);
		return "admin.member.reg";
	}
	
	@PostMapping("checkMail")
	@ResponseBody
	public void mail(String email) {
		Random ran = new Random();
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(email);
		int key = ran.nextInt(89999)+10000;
		message.setSubject("끼리끼리 인증번호");
		message.setText("회원님의 인증번호는" + key + "입니다.");
		mailSender.send(message);
		
	}
	
	@GetMapping("{id}")
	public String detail(@PathVariable("id") Integer id,Model model) {
		
		Member m = service.get(id);
		
		model.addAttribute("m",m);
		return "admin.member.detail";
	}

}
