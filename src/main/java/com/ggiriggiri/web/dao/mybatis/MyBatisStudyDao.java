package com.ggiriggiri.web.dao.mybatis;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ggiriggiri.web.dao.StudyDao;

@Repository
public class MyBatisStudyDao implements StudyDao{
	
	private StudyDao mapper;
	
	@Autowired
	public MyBatisStudyDao(SqlSession session) {
		
		mapper = session.getMapper(StudyDao.class);
		
	}

}
