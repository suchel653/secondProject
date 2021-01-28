package com.ggiriggiri.web.dao;

import java.util.List;

import com.ggiriggiri.web.entity.ProjectFile;

public interface ProjectFileDao {
	
 int insert(ProjectFile projectFile);
 ProjectFile get(int id);
 
 List<ProjectFile> getList(int projectId);
}
