package com.ggiriggiri.web.dao;

import java.util.List;

import com.ggiriggiri.web.entity.StudyBoard;
import com.ggiriggiri.web.entity.StudyBoardView;

public interface StudyBoardDao {

	List<StudyBoardView> getViewListByStudyId(int studyId);

	int insert(StudyBoard studyBoard);

	int delete(int id);

	StudyBoard get(int id);

	int update(StudyBoard studyBoard);

	StudyBoardView getView(int id);
}
