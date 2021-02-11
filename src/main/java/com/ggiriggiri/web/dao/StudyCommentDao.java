package com.ggiriggiri.web.dao;

import java.util.List;

import com.ggiriggiri.web.entity.StudyComment;
import com.ggiriggiri.web.entity.StudyCommentView;

public interface StudyCommentDao {

	List<StudyCommentView> getViewListByBoardId(int boardId);

	int insert(StudyComment studyComment);

	int delete(int id);
}
