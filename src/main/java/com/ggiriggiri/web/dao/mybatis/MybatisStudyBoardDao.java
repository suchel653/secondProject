package com.ggiriggiri.web.dao.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ggiriggiri.web.dao.StudyBoardDao;
import com.ggiriggiri.web.entity.StudyBoard;
import com.ggiriggiri.web.entity.StudyBoardView;

@Repository
public class MybatisStudyBoardDao implements StudyBoardDao{

	@Autowired
	private SqlSession session;
	
	private StudyBoardDao mapper;
	
	@Autowired
	public MybatisStudyBoardDao(SqlSession session) {
		
		mapper = session.getMapper(StudyBoardDao.class);
	}
	
	@Override
	public List<StudyBoardView> getViewListByStudyId(int studyId) {
		// TODO Auto-generated method stub
		return mapper.getViewListByStudyId(studyId);
	}

	@Override
	public int insert(StudyBoard studyBoard) {
		// TODO Auto-generated method stub
		return mapper.insert(studyBoard);
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return mapper.delete(id);
	}

	@Override
	public StudyBoard get(int id) {
		// TODO Auto-generated method stub
		return mapper.get(id);
	}

	@Override
	public int update(StudyBoard studyBoard) {
		// TODO Auto-generated method stub
		return mapper.update(studyBoard);
	}

	@Override
	public StudyBoardView getView(int id) {
		// TODO Auto-generated method stub
		return mapper.getView(id);
	}

}
