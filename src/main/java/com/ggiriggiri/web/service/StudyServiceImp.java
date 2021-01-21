package com.ggiriggiri.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ggiriggiri.web.dao.StudyDao;
import com.ggiriggiri.web.dao.StudyLanguageDao;
import com.ggiriggiri.web.dao.StudySkillDao;
import com.ggiriggiri.web.entity.Study;
import com.ggiriggiri.web.entity.StudyView;

@Service
public class StudyServiceImp implements StudyService {

	@Autowired
	private StudyDao studyDao;

	@Autowired
	private StudySkillDao studySkillDao;

	@Autowired
	private StudyLanguageDao studyLanguageDao;

	@Override
	public int insert(Study study) {
		// TODO Auto-generated method stub
		return studyDao.insert(study);
	}

	@Override
	public int update(Study study) {
		// TODO Auto-generated method stub
		return studyDao.update(study);
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return studyDao.delete(id);
	}

	@Override
	public Study get(int id) {
		// TODO Auto-generated method stub
		return studyDao.get(id);
	}

	@Override
	public List<Study> getList(int page, int size, String field, String query) {
		int offset = (page - 1) * 10;

		List<Study> list = studyDao.getList(offset, size, field, query);
		for (Study s : list) {
//			list=studyLanguageDao.getList(s.getId());

			s.setSkill(studySkillDao.getViewList(s.getId()));
			s.setLanguage(studyLanguageDao.getViewList(s.getId()));

		}

		return list;
	}

	@Override
	public int getCount(String field, String query) {
		// TODO Auto-generated method stub
		return studyDao.getCount(field, query);
	}

	@Override
	public List<StudyView> getViewList(int page, int size, String title, String query, String[] field, String[] skill,
			String[] language) {
		int offset = (page - 1) * 10;

		List<StudyView> list = studyDao.getViewList(offset, size, title, query,field);

		for (StudyView s : list) {
//			list=studyLanguageDao.getList(s.getId());

			s.setSkill(studySkillDao.getViewList(s.getId()));
			s.setLanguage(studyLanguageDao.getViewList(s.getId()));

		}

		return list;
	}

}
