package com.ggiriggiri.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ggiriggiri.web.dao.SkillDao;
import com.ggiriggiri.web.entity.Skill;

@Service
public class SkillServiceImp implements SkillService{
	
	@Autowired
	private SkillDao skillDao;

	@Override
	public int insert(Skill skill) {
		return skillDao.insert(skill);
	}

	@Override
	public int update(Skill skill) {
		return skillDao.update(skill);
	}

	@Override
	public int delete(int id) {
		return skillDao.delete(id);
	}

	@Override
	public Skill get(int id) {
		return skillDao.get(id);
	}

	@Override
	public List<Skill> getList(int page, int size) {
		
		int offset = (page - 1) * 10;
		
		return skillDao.getList(offset, size);
	}

}
