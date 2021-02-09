package com.ggiriggiri.web.service;

import java.util.List;

import com.ggiriggiri.web.entity.ProjectApply;
import com.ggiriggiri.web.entity.ProjectApplyView;

public interface ProjectApplyService {

	List<ProjectApplyView> getViewList(int leaderId);

	List<ProjectApplyView> getResultViewList(int memberId);

	List<ProjectApply> get(int memberId);

	List<ProjectApplyView> getViewByProjectId(int projectId);

	List<ProjectApplyView> getWaitingViewByProjectId(int projectId);

	int updateStatusToApprove(int memberId, int projectId);

	int updateStatusToReject(int memberId, int projectId);

}
