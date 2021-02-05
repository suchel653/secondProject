package com.ggiriggiri.web.dao.mybatis;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ggiriggiri.web.dao.ProfileDao;
import com.ggiriggiri.web.entity.Profile;

@Repository
public class MybatisProfileDao implements ProfileDao{

	private SqlSession session;
	private ProfileDao mapper;
	
	@Autowired
	public MybatisProfileDao(SqlSession session) {
		this.session = session;
		
		mapper = session.getMapper(ProfileDao.class);
	}

	@Override
	public int insert(Profile profile) {
		return mapper.insert(profile);
	}

	@Override
	public int update(Profile profile) {
		return mapper.update(profile);
	}

	@Override
	public int delete(int id) {
		return mapper.delete(id);
	}
	

	@Override
	public Profile get(int id) {
		return mapper.get(id);
	}

}
