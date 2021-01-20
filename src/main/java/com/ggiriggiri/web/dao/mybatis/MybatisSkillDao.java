package com.ggiriggiri.web.dao.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ggiriggiri.web.dao.SkillDao;
import com.ggiriggiri.web.entity.Skill;

@Repository
public class MybatisSkillDao implements SkillDao{
	
	private SkillDao mapper;
	
	@Autowired
	public MybatisSkillDao(SqlSession session) {
		mapper = session.getMapper(SkillDao.class);
	}

	@Override
	public int insert(Skill skill) {
		return mapper.insert(skill);
	}

	@Override
	public int update(Skill skill) {
		return mapper.update(skill);
	}

	@Override
	public int delete(int id) {
		return mapper.delete(id);
	}

	@Override
	public Skill get(int id) {
		return mapper.get(id);
	}

	@Override
	public List<Skill> getList(int offset, int size) {
		return mapper.getList(offset, size);
	}

}
