package com.ggiriggiri.web.dao.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ggiriggiri.web.dao.ProfileProjectDao;
import com.ggiriggiri.web.entity.ProfileProjectView;

@Repository
public class MybatisProfileProjectDao implements ProfileProjectDao{

	private SqlSession session;
	private ProfileProjectDao mapper;
	
	@Autowired
	public MybatisProfileProjectDao(SqlSession session) {
		this.session = session;
		
		mapper = session.getMapper(ProfileProjectDao.class);
	}
	
	@Override
	public List<ProfileProjectView> getListByProfileId(int profileId) {

		return mapper.getListByProfileId(profileId);
	}

}
