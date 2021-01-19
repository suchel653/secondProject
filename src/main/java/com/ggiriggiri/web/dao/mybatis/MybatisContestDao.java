package com.ggiriggiri.web.dao.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ggiriggiri.web.dao.ContestDao;
import com.ggiriggiri.web.entity.Contest;

@Repository
public class MybatisContestDao implements ContestDao{

	private SqlSession session;
	private ContestDao mapper;
	
	@Autowired
	public MybatisContestDao(SqlSession session) {
		this.session = session;
		
		mapper = session.getMapper(ContestDao.class);

	}
	
	@Override
	public int insert(Contest contest) {

		return mapper.insert(contest);
	}

	@Override
	public int update(Contest contest) {

		return mapper.update(contest);
	}

	@Override
	public int delete(int id) {

		return mapper.delete(id);
	}

	@Override
	public List<Contest> getList() {

		return mapper.getList();
	}

	@Override
	public List<Contest> getList(int offset, int size) {

		return mapper.getList(offset, size);
	}

	@Override
	public List<Contest> getList(int offset, int size, String field, String query) {

		return mapper.getList(offset, size, field, query);
	}

	@Override
	public Contest get(int id) {

		return mapper.get(id);
	}

	@Override
	public int getCount(String field, String query) {

		return mapper.getCount(field, query);
	}

	@Override
	public Contest getPrev(Integer id) {

		return mapper.getPrev(id);
	}

	@Override
	public Contest getNext(Integer id) {

		return mapper.getNext(id);
	}

}
