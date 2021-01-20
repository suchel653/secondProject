package com.ggiriggiri.web.dao.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ggiriggiri.web.dao.StudyLanguageDao;
import com.ggiriggiri.web.entity.Language;

@Repository
public class MybatisStudyLanguageDao implements StudyLanguageDao{
	
	@Autowired
	private SqlSession session;

	@Override
	public List<Language> getViewList(int id) {
		// TODO Auto-generated method stub
		return null;
	}


}
