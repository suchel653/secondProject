package com.ggiriggiri.web.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ggiriggiri.web.entity.Project;

@Service
public interface ProjectService {

	int insert(Project project);
	int update(Project project);
	int delete(int id);
	
	Project get(int id);
	
	List<Project> getList(int page, int size, String field, String query);
//	List<ProjectView> getViewList(int page, int size, String field, String query);
	
	int getCount(String field, String query);
}
