package com.ggiriggiri.web.dao;

import java.util.List;

import com.ggiriggiri.web.entity.ProjectLanguage;
import com.ggiriggiri.web.entity.ProjectLanguageView;
import com.ggiriggiri.web.entity.ProjectSkill;

public interface ProjectLanguageDao {

	int getId(int projectId,int languageId);
	
	int insert(ProjectLanguage projectLanguage);
	int update(ProjectLanguage projectLanguage);
	
	List<ProjectLanguageView> getListByProjectId(int id);

	int[] getProjectIdsByLanguageNames(int[] projectIds, String[] language);

}
