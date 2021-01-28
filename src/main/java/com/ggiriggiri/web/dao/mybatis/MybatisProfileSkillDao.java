package com.ggiriggiri.web.dao.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ggiriggiri.web.dao.ContestDao;
import com.ggiriggiri.web.dao.ProfileSkillDao;
import com.ggiriggiri.web.entity.ProfileSkillView;
import com.ggiriggiri.web.entity.ProjectSkill;

@Repository
public class MybatisProfileSkillDao implements ProfileSkillDao{

	private SqlSession session;
	private ProfileSkillDao mapper;
	
	@Autowired
	public MybatisProfileSkillDao(SqlSession session) {
		this.session = session;
		
		mapper = session.getMapper(ProfileSkillDao.class);
	}
	
	@Override
	public List<ProfileSkillView> getViewListByProfileId(int profileId) {

		return mapper.getViewListByProfileId(profileId);
	}

	

}
