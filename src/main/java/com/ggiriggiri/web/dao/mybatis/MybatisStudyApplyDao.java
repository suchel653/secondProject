package com.ggiriggiri.web.dao.mybatis;

import org.springframework.stereotype.Repository;

import com.ggiriggiri.web.dao.StudyApplyDao;

@Repository
public class MybatisStudyApplyDao implements StudyApplyDao{

	private StudyApplyDao mapper;
	
	@Override
	public int[] getByStudyIds(int memberId, int resultStatus) {
		return mapper.getByStudyIds(memberId, resultStatus);
	}

}
