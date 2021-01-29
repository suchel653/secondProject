package com.ggiriggiri.web.dao.mybatis;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ggiriggiri.web.dao.ProjectApplyDao;
import com.ggiriggiri.web.dao.StudyApplyDao;
import com.ggiriggiri.web.entity.ProjectApply;
import com.ggiriggiri.web.entity.StudyApply;



@Repository
public class MybatisProjectApplyDao implements ProjectApplyDao {

	private ProjectApplyDao mapper;
	
	@Autowired
	public MybatisProjectApplyDao(SqlSession session) {
		mapper = session.getMapper(ProjectApplyDao.class);
	}
	
	@Override
	public int insertProjectApply(ProjectApply projectApply) {
		
		return mapper.insertProjectApply(projectApply);
	}

	@Override
	public int[] getProjectIdsByMemberId(int memberId, int resultStatus)
	{
		return mapper.getProjectIdsByMemberId(memberId, resultStatus);
	}



}
