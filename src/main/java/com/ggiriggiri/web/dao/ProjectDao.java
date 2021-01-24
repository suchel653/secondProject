package com.ggiriggiri.web.dao;

import java.util.List;

import com.ggiriggiri.web.entity.Project;
import com.ggiriggiri.web.entity.ProjectView;


public interface ProjectDao {
	int insert(Project project);
	int update(Project project);
	int delete(int id);
	
	Project get(int id);
	
	List<Project> getList();
	List<Project> getList(int offset, int size, String field, String query);
	//List<ProjectView> getViewList(int offset, int size, String field, String query);
	
	int getCount(String field, String query);
	List<ProjectView> getViewList(int offset, int size, String title, String query, String[] field);
}
