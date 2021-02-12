package com.ggiriggiri.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ggiriggiri.web.dao.ChatDao;
import com.ggiriggiri.web.entity.ChatRoom;

@Service
public class ChatServiceImp implements ChatService{

	@Autowired
	private ChatDao chatDao;
	
	@Override
	public List<ChatRoom> getList() {
		
		return chatDao.getList();
	}

	@Override
	public ChatRoom get(int id) {
		
		return chatDao.get(id);
	}

}
