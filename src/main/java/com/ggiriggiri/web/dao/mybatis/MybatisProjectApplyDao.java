package com.ggiriggiri.web.dao.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ggiriggiri.web.dao.ProjectApplyDao;
import com.ggiriggiri.web.entity.ProjectApply;
import com.ggiriggiri.web.entity.ProjectApplyView;

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
	public int[] getProjectIdsByMemberId(int memberId, int resultStatus) {
		return mapper.getProjectIdsByMemberId(memberId, resultStatus);
	}

	@Override
	public List<ProjectApplyView> getViewListByStudyIds(int[] projectIds, int resultStatus) {
		return mapper.getViewListByStudyIds(projectIds, resultStatus);
	}

	@Override
	public List<ProjectApplyView> getResultViewListByMemberId(int memberId, int resultStatus, int resultChecked) {
		return mapper.getResultViewListByMemberId(memberId, resultStatus, resultChecked);
	}

	@Override
	public List<ProjectApplyView> getViewByProjectId(int projectId, int resultStatus) {
		return mapper.getViewByProjectId(projectId, resultStatus);
	}

	@Override
	public int check(int memberId, int projectId) {
		return mapper.check(memberId, projectId);
	}

	@Override
	public List<ProjectApply> get(int memberId) {
		return mapper.get(memberId);
	}

}
