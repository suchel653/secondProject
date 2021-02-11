package com.ggiriggiri.web.service;

import java.util.List;

import com.ggiriggiri.web.entity.StudyComment;
import com.ggiriggiri.web.entity.StudyCommentView;

public interface StudyCommentService {

	List<StudyCommentView> getViewList(int boardId);

	int insert(StudyComment studyComment);

	int delete(int id);
}
