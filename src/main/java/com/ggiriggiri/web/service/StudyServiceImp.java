package com.ggiriggiri.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ggiriggiri.web.dao.StudyApplyDao;
import com.ggiriggiri.web.dao.StudyDao;
import com.ggiriggiri.web.dao.StudyLanguageDao;
import com.ggiriggiri.web.dao.StudySkillDao;
import com.ggiriggiri.web.entity.Study;
import com.ggiriggiri.web.entity.StudyApply;
import com.ggiriggiri.web.entity.StudyView;

@Service
public class StudyServiceImp implements StudyService {

	@Autowired
	private StudyDao studyDao;

	@Autowired
	private StudySkillDao studySkillDao;

	@Autowired
	private StudyLanguageDao studyLanguageDao;
	
	@Autowired
	private StudyApplyDao studyApplyDao;


	@Override
	public int insert(Study study) {
		return studyDao.insert(study);
	}

	@Override
	public int update(Study study) {
		return studyDao.update(study);
	}

	@Override
	public int delete(int id) {
		return studyDao.delete(id);
	}

	@Override
	public Study get(int id) {
		return studyDao.get(id);
	}


	@Override
	public List<StudyView> getViewList(int page, int size, String title, String query, String[] field, String[] skill,
			String[] language) {

		// getStudyIdsByFieldNames
		int[] fdStudyIds = studyDao.getIdsByFieldNames(field);
		if(fdStudyIds.length==0)
			return null;
		
		int[] skStudyIds = studySkillDao.getByStudyIds(fdStudyIds,skill);
		
		
		if(skStudyIds.length==0)
			return null;
		int[] ids = studyLanguageDao.getByStudyIds(skStudyIds,language);
		
		if(ids.length==0)
			return null;

		
		int offset = (page - 1) * size;

		List<StudyView> list = studyDao.getViewList(ids,offset, size, title, query);

		for (StudyView s : list) {
			s.setSkill(studySkillDao.getViewList(s.getId()));
			s.setLanguage(studyLanguageDao.getViewList(s.getId()));

		} 

		return list;
	}

	@Override
	public int getCount(String title, String query, String[] field, String[] skill, String[] language) {
		int[] fdStudyIds = studyDao.getIdsByFieldNames(field);
		if(fdStudyIds.length==0)
			return 0;
		
		int[] skStudyIds = studySkillDao.getByStudyIds(fdStudyIds,skill);
		
		
		if(skStudyIds.length==0)
			return 0;
		int[] ids = studyLanguageDao.getByStudyIds(skStudyIds,language);
		
		if(ids.length==0)
			return 0;

		

		return studyDao.getCount(ids, title, query);
	}

	@Override
	public StudyView getView(int id) {
		
		StudyView study = studyDao.getView(id);

		
			study.setSkill(studySkillDao.getViewList(study.getId()));
			study.setLanguage(studyLanguageDao.getViewList(study.getId()));

		

		
		return study;
	}

	@Override
	public StudyView getPrev(int id) {
		return studyDao.getPrev(id);
	}

	@Override
	public StudyView getNext(int id) {
		return studyDao.getNext(id);
	}

	@Override

	public int insertStudyApply(StudyApply studyApply) {
		// TODO Auto-generated method stub
		return studyApplyDao.insertStudyApply(studyApply);
	}
	
	public List<StudyView> getOngoingViewList(int memberId) {
		
		int[] studyIds = studyApplyDao.getByStudyIds(memberId,1);
		int leaderId = memberId;
		int statusId = 2;
		List<StudyView> list = studyDao.getViewListByStatusId(studyIds,leaderId,statusId);
		
		return list;
	}

	@Override
	public List<StudyView> getWaitingViewList(int memberId) {
		int[] studyIds = studyApplyDao.getByStudyIds(memberId,1);
		int leaderId = memberId;
		int statusId = 1;
		List<StudyView> list = studyDao.getViewListByStatusId(studyIds,leaderId,statusId);
		
		return list;
	}

	@Override
	public List<StudyView> getEndedViewList(int memberId) {
		int[] studyIds = studyApplyDao.getByStudyIds(memberId,1);
		
		int leaderId = memberId;
		int statusId = 3;
		List<StudyView> list = studyDao.getViewListByStatusId(studyIds,leaderId,statusId);
		
		return list;

	}

}
