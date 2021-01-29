package com.ggiriggiri.web.dao;


import com.ggiriggiri.web.entity.ProjectApply;

public interface ProjectApplyDao {

	int insertProjectApply(ProjectApply projectApply);
	int[] getProjectIdsByMemberId(int memberId, int resultStatus);

}
