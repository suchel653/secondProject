package com.ggiriggiri.web.dao;

import java.util.List;

import com.ggiriggiri.web.entity.ProjectLanguage;
import com.ggiriggiri.web.entity.ProjectLanguageView;

public interface ProjectLanguageDao {

	int insert(ProjectLanguage projectLanguage);
	
	List<ProjectLanguageView> getListByProjectId(int id);

	int[] getProjectIdsByLanguageNames(int[] projectIds, String[] language);

}
