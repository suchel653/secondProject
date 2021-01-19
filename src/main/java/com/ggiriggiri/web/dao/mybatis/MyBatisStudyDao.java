package com.ggiriggiri.web.dao.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ggiriggiri.web.dao.StudyDao;
import com.ggiriggiri.web.entity.Study;


@Repository
public class MyBatisStudyDao implements StudyDao{
	
	@Autowired
	private SqlSession session;
	
	private StudyDao mapper;
	
	@Autowired
	public MyBatisStudyDao(SqlSession session) {
		
		mapper = session.getMapper(StudyDao.class);
		
	}

	@Override
	public List<Study> getList(int offset, int size, String field, String query) {
		// TODO Auto-generated method stub
		return mapper.getList(offset, size, field, query);
	}

	@Override
	public int insert(Study study) {
		// TODO Auto-generated method stub
		return mapper.insert(study);
	}

	@Override
	public int update(Study study) {
		// TODO Auto-generated method stub
		return mapper.update(study);
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return mapper.delete(id);
	}

	@Override
	public Study get(int id) {
		// TODO Auto-generated method stub
		return mapper.get(id);
	}

	@Override
	public int getCount(String field, String query) {
		// TODO Auto-generated method stub
		return mapper.getCount(field, query);
	}

	@Override
	public Study getPrev(Integer id) {
		// TODO Auto-generated method stub
		return mapper.getPrev(id);
	}

	@Override
	public Study getNext(Integer id) {
		// TODO Auto-generated method stub
		return mapper.getNext(id);
	}

	
}
