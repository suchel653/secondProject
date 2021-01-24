package com.ggiriggiri.web.dao.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ggiriggiri.web.dao.ProjectSkillDao;
import com.ggiriggiri.web.entity.ProjectSkillView;


@Repository 
public class MyBatisProjectSkillDao implements ProjectSkillDao{
	
	@Autowired
	private SqlSession session;
	
	private ProjectSkillDao mapper;
	
	@Autowired
	public MyBatisProjectSkillDao(SqlSession session) {
		
		this.session=session;
		mapper = session.getMapper(ProjectSkillDao.class);
	}

	
	@Override
	public List<ProjectSkillView> getListByProjectId(int id) {
		return mapper.getListByProjectId(id);
	}

	
	
	@Override
	public int[] getByProjectIds(int[] fdProjectIds, String[] skill) {
		
		if(skill.length==0)
			skill = null;
		
		return mapper.getByProjectIds(fdProjectIds, skill);
	}


	

}
