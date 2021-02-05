package com.ggiriggiri.web.dao;


import java.util.List;

import com.ggiriggiri.web.entity.StudyApply;
import com.ggiriggiri.web.entity.StudyApplyView;

public interface StudyApplyDao {

	int insertStudyApply(StudyApply studyApply);
	int[] getStudyIdsByMemberId(int memberId, int resultStatus);
	List<StudyApplyView> getViewListByStudyIds(int[] studyIds, int resultStatus);
	List<StudyApplyView> getResultViewListByMemberId(int memberId, int resultStatus, int resultChecked);
	
	int check(int memberId, int studyId);
	List<StudyApplyView> getViewByStudyId(int studyId, int resultStatus);
	int updateStatus(int memberId, int studyId, int resultStatus);

}
