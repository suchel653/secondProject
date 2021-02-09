package com.ggiriggiri.web.dao;

import java.util.List;

import com.ggiriggiri.web.entity.ProjectSkill;
import com.ggiriggiri.web.entity.ProjectSkillView;


public interface ProjectSkillDao {
	
	int getId(int projectId,int skillId);
	
	int insert(ProjectSkill projectSkill);
	int update(ProjectSkill projectSkill);
	
	List<ProjectSkillView> getListByProjectId(int id);

	int[] getProjectIdsBySkillNames(int[] projectIds, String[] skill);

	
}
