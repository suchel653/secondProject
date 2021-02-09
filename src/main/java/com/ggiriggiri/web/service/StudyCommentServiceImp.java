package com.ggiriggiri.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ggiriggiri.web.dao.StudyCommentDao;
import com.ggiriggiri.web.entity.StudyComment;
import com.ggiriggiri.web.entity.StudyCommentView;

@Service
public class StudyCommentServiceImp implements StudyCommentService{
	
	@Autowired
	private StudyCommentDao studyCommentDao;

	@Override
	public List<StudyCommentView> getViewList(int boardId) {
		// TODO Auto-generated method stub
		return studyCommentDao.getViewListByBoardId(boardId);
	}

	@Override
	public int insert(StudyComment studyComment) {
		// TODO Auto-generated method stub
		return studyCommentDao.insert(studyComment);
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return studyCommentDao.delete(id);
	}

}
