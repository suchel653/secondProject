package com.ggiriggiri.web.service;

import java.util.List;

import com.ggiriggiri.web.entity.Skill;

public interface SkillService {

	int insert(Skill skill);

	int update(Skill skill);

	int delete(int id);

	Skill get(int id);

	List<Skill> getList(int page, int size);

}
