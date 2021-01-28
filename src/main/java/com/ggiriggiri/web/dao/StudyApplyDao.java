package com.ggiriggiri.web.dao;


import com.ggiriggiri.web.entity.StudyApply;

public interface StudyApplyDao {

	int insertStudyApply(StudyApply studyApply);
	int[] getByStudyIds(int memberId, int resultStatus);

}
