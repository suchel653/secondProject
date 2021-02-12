package com.ggiriggiri.web.dao.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ggiriggiri.web.dao.ProfileExperienceDao;
import com.ggiriggiri.web.entity.ProfileExperience;

@Repository
public class MybatisProfileExperienceDao implements ProfileExperienceDao{

	private SqlSession session;
	private ProfileExperienceDao mapper;
	
	@Autowired
	public MybatisProfileExperienceDao(SqlSession session) {
		this.session = session;
		
		mapper = session.getMapper(ProfileExperienceDao.class);
	}
	
	@Override
	public List<ProfileExperience> getListByProfileId(int profileId) {

		return mapper.getListByProfileId(profileId);
	}

	@Override
	public void insert(int id) {
		// TODO Auto-generated method stub
		
	}

}
