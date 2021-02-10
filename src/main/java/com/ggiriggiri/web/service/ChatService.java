package com.ggiriggiri.web.service;

import java.util.List;

import com.ggiriggiri.web.entity.ChatRoom;

public interface ChatService {
	List<ChatRoom> getList();
	ChatRoom get(int id);
	
}
