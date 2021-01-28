package com.ggiriggiri.web.dao;

public interface StudyApplyDao {

	int[] getByStudyIds(int memberId, int resultStatus);

}
