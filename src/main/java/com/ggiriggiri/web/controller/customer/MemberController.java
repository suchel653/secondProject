package com.ggiriggiri.web.controller.customer;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ggiriggiri.web.entity.Member;
import com.ggiriggiri.web.service.MemberService;

@Controller
@RequestMapping("/customer/")
public class MemberController {
	
	@Autowired
	private MemberService service;
	
	@Autowired
	private JavaMailSender mailSender;
	
	@GetMapping("join")
	public String join() {
		
		return "customer.join";
	}
	
	@PostMapping("join")
	public String join(String email, String nickname, String password ) {
		Member member = new Member();
		BCryptPasswordEncoder pwdEncoder = new BCryptPasswordEncoder();
		String encodePwd = pwdEncoder.encode(password);
		member.setEmail(email);
		member.setNickname(nickname);
		member.setPassword(encodePwd);
		service.insert(member);		
		return "customer.join";
	}
	
	@RequestMapping("login")
	public String login() {
		return "customer.login";
	}
	
	@PostMapping("checkMail")
	@ResponseBody
	public Map<String, Object> sendMail(String email) {
		System.out.println(email);
		Map<String, Object> map = new HashMap<>();
		Random ran = new Random();
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(email);
		int key = ran.nextInt(89999)+10000;
		message.setSubject("끼리끼리 인증번호");
		message.setText("회원님의 인증번호는" + key + "입니다.");
		mailSender.send(message);
		map.put("key", key);
		return map;
		
	}
	
	@PostMapping("checkDuplicate")
	@ResponseBody
	public Map<String, Object> checkDublicate(String checkKey) {
		Map<String, Object> map = new HashMap<>();
		int checkResult = service.check("nickname", checkKey);
		map.put("checkResult", checkResult);
		
		return map;
	}

}
