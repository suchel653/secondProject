package com.ggiriggiri.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ggiriggiri.web.dao.StudyApplyDao;
import com.ggiriggiri.web.dao.StudyDao;
import com.ggiriggiri.web.entity.StudyApplyView;

@Service
public class StudyApplyServiceImp implements StudyApplyService {

	@Autowired
	private StudyApplyDao studyApplyDao;

	@Autowired
	private StudyDao studyDao;

	@Override
	public List<StudyApplyView> getViewList(int leaderId) {
		int statusId = 1; // 1 - > 모집중인것
		int[] studyIds = studyDao.getIdsByLeaderId(leaderId, statusId);

		if (studyIds.length == 0)
			return null;

		int resultStatus = 0; // - > 0, 결과 대기중
		List<StudyApplyView> list = studyApplyDao.getViewListByStudyIds(studyIds, resultStatus);
		return list;
	}

	@Override
	public List<StudyApplyView> getResultViewList(int memberId) {
		int resultStatus = 0; // 0이 아닌 것들
		int resultChecked = 0; // 확인 안한 상태
		return studyApplyDao.getResultViewListByMemberId(memberId, resultStatus, resultChecked);
	}

	@Override
	public List<StudyApplyView> getViewByStudyId(int studyId) {
		int resultStatus = 1; // 승인된 사람만
		return studyApplyDao.getViewByStudyId(studyId, resultStatus);
	}

	@Override
	public List<StudyApplyView> getWaitingViewByStudyId(int studyId) {
		int resultStatus = 0; // 대기중인 사람만
		return studyApplyDao.getViewByStudyId(studyId, resultStatus);
	}

	@Override
	public int updateStatusToApprove(int memberId, int studyId) {
		int resultStatus = 1;
		return studyApplyDao.updateStatus(memberId, studyId, resultStatus);
	}

	@Override
	public int updateStatusToReject(int memberId, int studyId) {
		int resultStatus = 2;
		return studyApplyDao.updateStatus(memberId, studyId, resultStatus);
	}

}
