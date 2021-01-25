package com.ggiriggiri.web.dao;

import java.util.List;

import com.ggiriggiri.web.entity.Skill;

public interface SkillDao {

	int insert(Skill skill);

	int update(Skill skill);

	int delete(int id);

	Skill get(int id);

	List<Skill> getList();

	List<Skill> getList(int offset, int size);

	int deleteAll(int[] ids);

	int getCount();

}
