package com.ggiriggiri.web.dao;

import java.util.List;

import com.ggiriggiri.web.entity.Project;
import com.ggiriggiri.web.entity.ProjectView;


public interface ProjectDao {
	int insert(Project project);
	int update(Project project);
	int delete(int id);
	
	Project get(int id);
	ProjectView getView(int id);
	
	List<Project> getList();
	List<Project> getList(int offset, int size, String field, String query);
	//List<ProjectView> getViewList(int offset, int size, String field, String query);
	
	int getCount(String field, String query);
	
	int[] getByProjectIds(String[] field);
	List<ProjectView> getViewList(int[] ids ,int offset, int size, String title, String query);
	
	ProjectView getPrev(int id);
	ProjectView getNext(int id);
}
