package com.ggiriggiri.web.dao.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ggiriggiri.web.dao.StudyLanguageDao;
import com.ggiriggiri.web.entity.StudyLanguage;
import com.ggiriggiri.web.entity.StudyLanguageView;

@Repository
public class MybatisStudyLanguageDao implements StudyLanguageDao{
	
	@Autowired
	private SqlSession session;
	
	private StudyLanguageDao mapper;
	
	@Autowired
	public MybatisStudyLanguageDao(SqlSession session) {
		
		mapper = session.getMapper(StudyLanguageDao.class);
	}

	
	
	@Override
	public List<StudyLanguageView> getViewList(int id) {
		// TODO Auto-generated method stub
		return mapper.getViewList(id);
	}




	@Override
	public int[] getStudyIdsByLanguageNames(int[] studyIds, String[] language) {
		if(language.length==0)
			language=null;
		return mapper.getStudyIdsByLanguageNames(studyIds, language);
	}



	@Override
	public int insert(StudyLanguage sl) {
		// TODO Auto-generated method stub
		return 0;
	}


}
