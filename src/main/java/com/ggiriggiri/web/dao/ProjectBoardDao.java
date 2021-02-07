package com.ggiriggiri.web.dao;

import java.util.List;

import com.ggiriggiri.web.entity.ProjectBoard;
import com.ggiriggiri.web.entity.ProjectBoardView;

public interface ProjectBoardDao {

	List<ProjectBoardView> getViewListByProjectId(int projectId);

	int insert(ProjectBoard projectBoard);

	int delete(int id);

	ProjectBoard get(int id);

	int update(ProjectBoard projectBoard);

	ProjectBoardView getView(int id);
}
