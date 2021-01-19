package com.ggiriggiri.web.dao.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ggiriggiri.web.dao.ContestImageDao;
import com.ggiriggiri.web.entity.ContestImage;

@Repository
public class MybatisContestImageDao implements ContestImageDao{

	private SqlSession session;
	private ContestImageDao mapper;
	
	@Autowired
	public MybatisContestImageDao(SqlSession session) {
		this.session = session;
		
		mapper = session.getMapper(ContestImageDao.class);
	}
	
	@Override
	public int insert(ContestImage contestImage) {
		
		return mapper.insert(contestImage);
	}

	@Override
	public int update(ContestImage contestImage) {
		
		return mapper.update(contestImage);
	}

	@Override
	public int delete(int id) {
		
		return mapper.delete(id);
	}

	@Override
	public List<ContestImage> getList(int contestId) {

		return mapper.getList(contestId);
	}

	@Override
	public ContestImage get(int id) {

		return mapper.get(id);
	}

	@Override
	public int getCount(String field, String query) {

		return mapper.getCount(field, query);
	}

}
