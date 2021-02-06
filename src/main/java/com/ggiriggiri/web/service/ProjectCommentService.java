package com.ggiriggiri.web.service;

import java.util.List;

import com.ggiriggiri.web.entity.ProjectComment;
import com.ggiriggiri.web.entity.ProjectCommentView;

public interface ProjectCommentService {

	List<ProjectCommentView> getViewList(int boardId);

	int insert(ProjectComment projectComment);
}
