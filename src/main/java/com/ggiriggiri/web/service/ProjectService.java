package com.ggiriggiri.web.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ggiriggiri.web.entity.ContestFile;
import com.ggiriggiri.web.entity.Project;
import com.ggiriggiri.web.entity.ProjectFile;
import com.ggiriggiri.web.entity.ProjectLanguage;
import com.ggiriggiri.web.entity.ProjectSkill;
import com.ggiriggiri.web.entity.ProjectView;
import com.ggiriggiri.web.entity.StudyView;

@Service
public interface ProjectService {

	int insert(Project project);
	int update(Project project);
	int delete(int id);
	
	Project get(int id);
	ProjectView getView(int id);
	
	List<Project> getList(int page, int size, String field, String query);
	List<ProjectView> getViewList(int page, int size, String title, String query, String[] field, String[] skill,
			String[] language);
	
	int getCount(String title, String query, String[] field, String[] skill, String[] language);
	ProjectView getPrev(int id);
	ProjectView getNext(int id);
	
	int getLastId();
	int insertFile(ProjectFile projectFile);
	
	int insertSkill(ProjectSkill projectSkill);
	int insertLanguage(ProjectLanguage projectLanguage);
}
