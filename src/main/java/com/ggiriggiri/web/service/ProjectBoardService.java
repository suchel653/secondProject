package com.ggiriggiri.web.service;

import java.util.List;

import com.ggiriggiri.web.entity.ProjectBoard;
import com.ggiriggiri.web.entity.ProjectBoardView;

public interface ProjectBoardService {
	
	List<ProjectBoardView> getViewList(int projectId);

	int insert(ProjectBoard projectBoard);

	int delete(int id);

	ProjectBoard get(int id);

	int update(ProjectBoard projectBoard);

	ProjectBoardView getView(int id);

}
