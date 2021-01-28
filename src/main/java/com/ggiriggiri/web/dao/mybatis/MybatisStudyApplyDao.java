package com.ggiriggiri.web.dao.mybatis;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ggiriggiri.web.dao.StudyApplyDao;
import com.ggiriggiri.web.dao.StudyDao;

@Repository
public class MybatisStudyApplyDao implements StudyApplyDao {

	private StudyApplyDao mapper;

	@Autowired
	public MybatisStudyApplyDao(SqlSession session) {

		mapper = session.getMapper(StudyApplyDao.class);

	}

	@Override
	public int[] getByStudyIds(int memberId, int resultStatus) {
		// TODO Auto-generated method stub
		return mapper.getByStudyIds(memberId, resultStatus);
	}

}
