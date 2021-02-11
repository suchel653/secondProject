package com.ggiriggiri.web.dao.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ggiriggiri.web.dao.StudyCommentDao;
import com.ggiriggiri.web.entity.StudyComment;
import com.ggiriggiri.web.entity.StudyCommentView;
@Repository
public class MybatisStudyCommentDao implements StudyCommentDao{

	private StudyCommentDao mapper;
	
	@Autowired
	public MybatisStudyCommentDao(SqlSession session) {
		
		mapper = session.getMapper(StudyCommentDao.class);
	}

	@Override
	public List<StudyCommentView> getViewListByBoardId(int boardId) {
		// TODO Auto-generated method stub
		return mapper.getViewListByBoardId(boardId);
	}

	@Override
	public int insert(StudyComment studyComment) {
		// TODO Auto-generated method stub
		return mapper.insert(studyComment);
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return mapper.delete(id);
	}
	
}
