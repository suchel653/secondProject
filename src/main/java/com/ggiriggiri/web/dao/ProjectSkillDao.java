package com.ggiriggiri.web.dao;

import java.util.List;

import com.ggiriggiri.web.entity.ProjectSkillView;


public interface ProjectSkillDao {
	
	
	List<ProjectSkillView> getListByProjectId(int id);
	
	int[] getByProjectIds(int[] fdProjectIds, String[] skill);
	
}
