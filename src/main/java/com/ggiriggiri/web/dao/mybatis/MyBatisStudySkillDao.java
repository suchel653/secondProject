package com.ggiriggiri.web.dao.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ggiriggiri.web.dao.StudySkillDao;

import com.ggiriggiri.web.entity.Skill;
import com.ggiriggiri.web.entity.Study;
import com.ggiriggiri.web.entity.StudySkill;


@Repository 
public class MyBatisStudySkillDao implements StudySkillDao{
	
	@Autowired
	private SqlSession session;

	@Override
	public List<StudySkill> getList() {
		// TODO Auto-generated method stub
		return null;
	}

	

}
