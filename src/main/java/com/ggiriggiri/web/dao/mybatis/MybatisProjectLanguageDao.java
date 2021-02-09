package com.ggiriggiri.web.dao.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ggiriggiri.web.dao.ProjectLanguageDao;
import com.ggiriggiri.web.dao.StudyLanguageDao;
import com.ggiriggiri.web.entity.ProjectLanguage;
import com.ggiriggiri.web.entity.ProjectLanguageView;
import com.ggiriggiri.web.entity.StudyLanguageView;

@Repository
public class MybatisProjectLanguageDao implements ProjectLanguageDao{
	
	@Autowired
	private SqlSession session;
	
	private ProjectLanguageDao mapper;
	
	@Autowired
	public MybatisProjectLanguageDao(SqlSession session) {
		
		mapper = session.getMapper(ProjectLanguageDao.class);
	}

	
	@Override
	public List<ProjectLanguageView> getListByProjectId(int id) {
		
		return mapper.getListByProjectId(id);
	}


	@Override
	public int insert(ProjectLanguage projectLanguage) {
		// TODO Auto-generated method stub
		return mapper.insert(projectLanguage);
	}


	@Override
	public int[] getProjectIdsByLanguageNames(int[] projectIds, String[] language) {
		if(language.length==0)
			language = null;
		
		return mapper.getProjectIdsByLanguageNames(projectIds, language);
	}


	@Override
	public int update(ProjectLanguage projectLanguage) {
		return mapper.update(projectLanguage);
	}


	@Override
	public int getId(int projectId, int languageId) {
		return mapper.getId(projectId, languageId);
	}
	
}
