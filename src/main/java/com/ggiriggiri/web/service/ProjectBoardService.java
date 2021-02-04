package com.ggiriggiri.web.service;

import java.util.List;

import com.ggiriggiri.web.entity.ProjectBoardView;

public interface ProjectBoardService {
	
	List<ProjectBoardView> getViewList(int projectId);

}
