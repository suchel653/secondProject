package com.ggiriggiri.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ggiriggiri.web.dao.StudyBoardDao;
import com.ggiriggiri.web.entity.StudyBoard;
import com.ggiriggiri.web.entity.StudyBoardView;

@Service
public class StudyBoardServiceImp implements StudyBoardService{
	
	@Autowired
	private StudyBoardDao studyBoardDao;
	
	@Override
	public List<StudyBoardView> getViewList(int studyId) {

		return studyBoardDao.getViewListByStudyId(studyId);
	}

	@Override
	public int insert(StudyBoard studyBoard) {
		// TODO Auto-generated method stub
		return studyBoardDao.insert(studyBoard);
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return studyBoardDao.delete(id);
	}

	@Override
	public StudyBoard get(int id) {
		// TODO Auto-generated method stub
		return studyBoardDao.get(id);
	}

	@Override
	public int update(StudyBoard studyBoard) {
		// TODO Auto-generated method stub
		return studyBoardDao.update(studyBoard);
	}

	@Override
	public StudyBoardView getView(int id) {
		// TODO Auto-generated method stub
		return studyBoardDao.getView(id);
	}

}
