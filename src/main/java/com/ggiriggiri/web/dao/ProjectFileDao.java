package com.ggiriggiri.web.dao;

import java.util.List;

import com.ggiriggiri.web.entity.ProjectFile;

public interface ProjectFileDao {
	
 int insert(ProjectFile projectFile);
 int update(ProjectFile projectFile);
 
 int getId(int projectId, String name);
 ProjectFile get(int id);
 
 
 List<ProjectFile> getList(int projectId);
}
