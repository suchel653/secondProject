package com.ggiriggiri.web.dao;

import java.util.List;

import com.ggiriggiri.web.entity.ProjectLanguageView;

public interface ProjectLanguageDao {

	List<ProjectLanguageView> getListByProjectId(int id);
	int[] getByProjectIds(int[] skProjectIds, String[] language);

}
