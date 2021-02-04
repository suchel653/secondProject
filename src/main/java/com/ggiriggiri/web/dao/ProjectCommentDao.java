package com.ggiriggiri.web.dao;

import java.util.List;

import com.ggiriggiri.web.entity.ProjectCommentView;

public interface ProjectCommentDao {

	List<ProjectCommentView> getViewListByBoardId(int boardId);
}
