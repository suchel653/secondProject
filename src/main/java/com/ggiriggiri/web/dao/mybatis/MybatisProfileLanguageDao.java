package com.ggiriggiri.web.dao.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ggiriggiri.web.dao.ProfileLanguageDao;
import com.ggiriggiri.web.entity.ProfileLanguage;
import com.ggiriggiri.web.entity.ProfileLanguageView;

@Repository
public class MybatisProfileLanguageDao implements ProfileLanguageDao{
	
	private SqlSession session;
	private ProfileLanguageDao mapper;
	
	@Autowired
	public MybatisProfileLanguageDao(SqlSession session) {
		this.session = session;
		
		mapper = session.getMapper(ProfileLanguageDao.class);
	}
	
	@Override
	public int insert(int profileId, int languageId) {
		return mapper.insert(profileId,languageId);
	}

	@Override
	public List<ProfileLanguage> getByProfileId(int profileId) {
		return mapper.getByProfileId(profileId);
	}
	
	@Override
	public List<ProfileLanguageView> getViewListByProfileId(int profileId) {

		return mapper.getViewListByProfileId(profileId);
	}

	

}
