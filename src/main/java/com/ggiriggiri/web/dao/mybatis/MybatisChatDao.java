package com.ggiriggiri.web.dao.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ggiriggiri.web.dao.ChatDao;
import com.ggiriggiri.web.entity.ChatRoom;

@Repository
public class MybatisChatDao implements ChatDao{

	private SqlSession session;
	private ChatDao mapper;
	
	@Autowired
	public MybatisChatDao(SqlSession session) {
		this.session = session;
		
		mapper = session.getMapper(ChatDao.class);
	}
	
	@Override
	public List<ChatRoom> getList() {
		return mapper.getList();
	}

	@Override
	public ChatRoom get(int id) {
		ChatRoom room = mapper.get(id);
		
		return room;
	}

}
