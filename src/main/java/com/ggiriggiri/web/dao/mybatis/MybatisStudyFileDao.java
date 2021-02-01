package com.ggiriggiri.web.dao.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.ggiriggiri.web.dao.StudyFileDao;
import com.ggiriggiri.web.entity.StudyFile;

@Repository
public class MybatisStudyFileDao implements StudyFileDao{
	
	private SqlSession session;
	private StudyFileDao mapper;

	@Autowired
	public MybatisStudyFileDao(SqlSession session) {
		this.session = session;
		mapper = session.getMapper(StudyFileDao.class);

	}
	
	@Override
	public int insert(StudyFile studyFile) {
		// TODO Auto-generated method stub
		return mapper.insert(studyFile);
		
	}

	@Override
	public StudyFile get(int id) {
		// TODO Auto-generated method stub
		return mapper.get(id);
	}

	@Override
	public List<StudyFile> getList(int studyId) {
		// TODO Auto-generated method stub
		return mapper.getList(studyId);
	}

}
