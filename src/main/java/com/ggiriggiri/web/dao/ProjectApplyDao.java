package com.ggiriggiri.web.dao;


import java.util.List;

import com.ggiriggiri.web.entity.ProjectApply;
import com.ggiriggiri.web.entity.ProjectApplyView;

public interface ProjectApplyDao {

	int insertProjectApply(ProjectApply projectApply);
	int[] getProjectIdsByMemberId(int memberId, int resultStatus);
	List<ProjectApplyView> getViewListByStudyIds(int[] projectIds, int resultStatus);
	List<ProjectApplyView> getResultViewListByMemberId(int memberId, int resultStatus, int resultChecked);
	List<ProjectApplyView> getViewByProjectId(int projectId, int resultStatus);

	List<ProjectApply> get(int memberId);
	int check(int memberId , int projectId);
}
