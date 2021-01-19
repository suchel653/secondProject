package com.ggiriggiri.web.dao.mybatis;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ggiriggiri.web.dao.StudyLanguageDao;
import com.ggiriggiri.web.entity.Language;

@Repository
public class MybatisStudyLanguageDao implements StudyLanguageDao{

	@Override
	public List<Language> getList(int id) {
		
		return null;
	}

}
