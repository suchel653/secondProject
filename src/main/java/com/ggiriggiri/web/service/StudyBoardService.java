package com.ggiriggiri.web.service;

import java.util.List;

import com.ggiriggiri.web.entity.StudyBoard;
import com.ggiriggiri.web.entity.StudyBoardView;

public interface StudyBoardService {
	
	List<StudyBoardView> getViewList(int studyId);

	int insert(StudyBoard studyBoard);

	int delete(int id);

	StudyBoard get(int id);

	int update(StudyBoard studyBoard);

	StudyBoardView getView(int id);

}
