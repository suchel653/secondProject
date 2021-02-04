package com.ggiriggiri.web.dao.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ggiriggiri.web.dao.ProjectBoardDao;
import com.ggiriggiri.web.entity.ProjectBoardView;

@Repository
public class MybatisProjectBoardDao implements ProjectBoardDao{

	@Autowired
	private SqlSession session;
	
	private ProjectBoardDao mapper;
	
	@Autowired
	public MybatisProjectBoardDao(SqlSession session) {
		
		mapper = session.getMapper(ProjectBoardDao.class);
	}
	
	@Override
	public List<ProjectBoardView> getViewListByProjectId(int projectId) {
		// TODO Auto-generated method stub
		return mapper.getViewListByProjectId(projectId);
	}

}
