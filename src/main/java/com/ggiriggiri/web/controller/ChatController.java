package com.ggiriggiri.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ggiriggiri.web.entity.ChatRoom;
import com.ggiriggiri.web.service.ChatService;

@Controller
@RequestMapping("/chat")
public class ChatController {

	@Autowired
	private ChatService service;
	
	@RequestMapping("list")
	public String list(Model model) {
		List<ChatRoom> list = service.getList();
		
		model.addAttribute("list",list);
		return "home.chat.list";
	}
	
	@RequestMapping("{id}")
	public String room(Model model,@PathVariable("id") int id) {
		ChatRoom room = service.get(id);
		
		model.addAttribute("room",room);
		return "home.chat.room";
	}
}
