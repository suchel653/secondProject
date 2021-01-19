package com.ggiriggiri.web.dao.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ggiriggiri.web.dao.ContestFileDao;
import com.ggiriggiri.web.entity.ContestFile;

@Repository
public class MybatisContestFileDao implements ContestFileDao{

	private SqlSession session;
	private ContestFileDao mapper;
	
	@Autowired
	public MybatisContestFileDao(SqlSession session) {
		this.session = session;
		
		mapper = session.getMapper(ContestFileDao.class);

	}
	
	@Override
	public int insert(ContestFile contestFile) {

		return mapper.insert(contestFile);
	}

	@Override
	public int update(ContestFile contestFile) {
		// TODO Auto-generated method stub
		return mapper.update(contestFile);
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return mapper.delete(id);
	}

	@Override
	public List<ContestFile> getList(int contestId) {
		// TODO Auto-generated method stub
		return mapper.getList(contestId);
	}

	@Override
	public ContestFile get(int id) {
		// TODO Auto-generated method stub
		return mapper.get(id);
	}

	@Override
	public int getCount(String field, String query) {
		// TODO Auto-generated method stub
		return mapper.getCount(field, query);
	}

}
