package com.ggiriggiri.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ggiriggiri.web.dao.ProjectApplyDao;
import com.ggiriggiri.web.dao.ProjectDao;
import com.ggiriggiri.web.entity.ProjectApply;
import com.ggiriggiri.web.entity.ProjectApplyView;

@Service
public class ProjectApplyServiceImp implements ProjectApplyService {

	@Autowired
	private ProjectApplyDao projectApplyDao;

	@Autowired
	private ProjectDao projectDao;

	@Override
	public List<ProjectApplyView> getViewList(int leaderId) {
		int statusId = 1; // 1 - > 모집중인것
		int[] projectIds = projectDao.getIdsByLeaderId(leaderId, statusId);

		if (projectIds.length == 0)
			return null;

		int resultStatus = 0; // - > 0, 결과 대기중
		List<ProjectApplyView> list = projectApplyDao.getViewListByStudyIds(projectIds, resultStatus);
		return list;
	}

	@Override
	public List<ProjectApplyView> getResultViewList(int memberId) {
		int resultStatus = 0; // 0이 아닌 것들
		int resultChecked = 0; // 확인 안한 상태
		return projectApplyDao.getResultViewListByMemberId(memberId, resultStatus, resultChecked);
	}

	@Override
	public List<ProjectApply> get(int memberId) {
		return projectApplyDao.get(memberId);
	}
	@Override
	public List<ProjectApplyView> getViewByProjectId(int projectId) {
		int resultStatus = 1;
		return projectApplyDao.getViewByProjectId(projectId, resultStatus);
	}


	@Override
	public List<ProjectApplyView> getWaitingViewByProjectId(int projectId) {
		int resultStatus = 0;
		return projectApplyDao.getViewByProjectId(projectId, resultStatus);
	}

	@Override
	public int updateStatusToApprove(int memberId) {
		int resultStatus = 1;
		return projectApplyDao.updateStatus(memberId, resultStatus);
	}

	@Override
	public int updateStatusToReject(int memberId) {
		int resultStatus = 2;
		return projectApplyDao.updateStatus(memberId, resultStatus);
	}

}
