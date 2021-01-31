package com.ggiriggiri.web.dao.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ggiriggiri.web.dao.StudyApplyDao;

import com.ggiriggiri.web.entity.StudyApply;
import com.ggiriggiri.web.entity.StudyApplyView;



@Repository
public class MybatisStudyApplyDao implements StudyApplyDao {


	private StudyApplyDao mapper;
	
	@Autowired
	public MybatisStudyApplyDao(SqlSession session) {
		mapper = session.getMapper(StudyApplyDao.class);
	}
	
	@Override
	public int insertStudyApply(StudyApply studyApply) {
		return mapper.insertStudyApply(studyApply);
	}


	@Override
	public int[] getStudyIdsByMemberId(int memberId, int resultStatus) {
		return mapper.getStudyIdsByMemberId(memberId, resultStatus);
	}

	@Override
	public List<StudyApplyView> getViewListByStudyIds(int[] studyIds, int resultStatus) {
		return mapper.getViewListByStudyIds(studyIds, resultStatus);
	}

	@Override
	public List<StudyApplyView> getResultViewListByMemberId(int memberId, int resultStatus, int resultChecked) {
		return mapper.getResultViewListByMemberId(memberId,resultStatus,resultChecked);
	}

}
