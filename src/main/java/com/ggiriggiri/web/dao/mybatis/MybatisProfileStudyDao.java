package com.ggiriggiri.web.dao.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ggiriggiri.web.dao.ProfileStudyDao;
import com.ggiriggiri.web.entity.ProfileStudyView;

@Repository
public class MybatisProfileStudyDao implements ProfileStudyDao{

	private ProfileStudyDao mapper;
	
	@Autowired
	public MybatisProfileStudyDao(SqlSession session) {

		mapper = session.getMapper(ProfileStudyDao.class);
	}
	
	@Override
	public List<ProfileStudyView> getListByProfileId(int profileId) {

		return mapper.getListByProfileId(profileId);
	}

}
