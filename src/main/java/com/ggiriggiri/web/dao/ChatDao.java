package com.ggiriggiri.web.dao;

import java.util.List;

import com.ggiriggiri.web.entity.ChatRoom;

public interface ChatDao {
	List<ChatRoom> getList();
	ChatRoom get(int id);
}
