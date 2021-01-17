package com.ggiriggiri.web.dao.mybatis;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ggiriggiri.web.dao.ProjectDao;

@Repository
public class MybatisProjectDao implements ProjectDao {

	@Autowired
	private SqlSession session;
	private ProjectDao mapper;
	
	@Autowired
	public MybatisProjectDao(SqlSession session) {
		mapper = session.getMapper(ProjectDao.class);
	}
	
}
