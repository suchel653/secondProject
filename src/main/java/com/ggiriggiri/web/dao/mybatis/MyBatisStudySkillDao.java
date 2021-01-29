package com.ggiriggiri.web.dao.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.ggiriggiri.web.dao.StudySkillDao;
import com.ggiriggiri.web.entity.StudySkill;
import com.ggiriggiri.web.entity.StudySkillView;


@Repository 
public class MyBatisStudySkillDao implements StudySkillDao{
	
	@Autowired
	private SqlSession session;
	
	private StudySkillDao mapper;
	
	@Autowired
	public MyBatisStudySkillDao(SqlSession session) {
		
		this.session=session;
		mapper = session.getMapper(StudySkillDao.class);
	}



	@Override
	public List<StudySkillView> getViewList(int id) {
		// TODO Auto-generated method stub
		return mapper.getViewList(id);
	}



	@Override
	public int[] getStudyIdsBySkillNames(int[] studyIds, String[] skill) {
		if(skill.length==0)
			skill=null;
		return mapper.getStudyIdsBySkillNames(studyIds,skill);
	}



	@Override
	public int insert(StudySkill sk) {
		// TODO Auto-generated method stub
		return 0;
	}






	

}
