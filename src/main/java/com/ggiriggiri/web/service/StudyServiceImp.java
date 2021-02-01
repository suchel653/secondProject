package com.ggiriggiri.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ggiriggiri.web.dao.StudyApplyDao;
import com.ggiriggiri.web.dao.StudyDao;
import com.ggiriggiri.web.dao.StudyFileDao;
import com.ggiriggiri.web.dao.StudyLanguageDao;
import com.ggiriggiri.web.dao.StudySkillDao;
import com.ggiriggiri.web.entity.Study;
import com.ggiriggiri.web.entity.StudyApply;
import com.ggiriggiri.web.entity.StudyFile;
import com.ggiriggiri.web.entity.StudyLanguage;
import com.ggiriggiri.web.entity.StudySkill;
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
	
	@Autowired
	private StudyFileDao studyFileDao;

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
		int[] studyIds = studyDao.getIdsByFieldNames(field);
		if (studyIds.length == 0)
			return null;

		studyIds = studySkillDao.getStudyIdsBySkillNames(studyIds, skill);
		if (studyIds.length == 0)
			return null;

		studyIds = studyLanguageDao.getStudyIdsByLanguageNames(studyIds, language);

		if (studyIds.length == 0)
			return null;

		int offset = (page - 1) * size;
		int[] ids = studyIds;
		List<StudyView> list = studyDao.getViewList(ids, offset, size, title, query);

		for (StudyView s : list) {
			s.setSkill(studySkillDao.getViewList(s.getId()));
			s.setLanguage(studyLanguageDao.getViewList(s.getId()));

		}

		return list;
	}

	@Override
	public int getCount(String title, String query, String[] field, String[] skill, String[] language) {
		int[] studyIds = studyDao.getIdsByFieldNames(field);
		if (studyIds.length == 0)
			return 0;

		studyIds = studySkillDao.getStudyIdsBySkillNames(studyIds, skill);
		if (studyIds.length == 0)
			return 0;

		studyIds = studyLanguageDao.getStudyIdsByLanguageNames(studyIds, language);

		if (studyIds.length == 0)
			return 0;

		int[] ids = studyIds;

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
		return studyApplyDao.insertStudyApply(studyApply);
	}

	public List<StudyView> getOngoingViewList(int memberId) {

		int[] studyIds = studyApplyDao.getStudyIdsByMemberId(memberId, 1);
		int leaderId = memberId;
		int statusId = 2;
		if (studyIds.length == 0)
			return null;

		int[] ids = studyIds;
		List<StudyView> list = studyDao.getViewListByStatusId(ids, leaderId, statusId);

		return list;
	}

	@Override
	public List<StudyView> getWaitingViewList(int memberId) {
		int[] studyIds = studyApplyDao.getStudyIdsByMemberId(memberId, 1);
		int leaderId = memberId;
		int statusId = 1;
		if (studyIds.length == 0)
			return null;

		int[] ids = studyIds;
		List<StudyView> list = studyDao.getViewListByStatusId(ids, leaderId, statusId);

		return list;
	}

	@Override
	public List<StudyView> getEndedViewList(int memberId) {
		int[] studyIds = studyApplyDao.getStudyIdsByMemberId(memberId, 1);

		int leaderId = memberId;
		int statusId = 3;
		if (studyIds.length == 0)
			return null;

		int[] ids = studyIds;
		List<StudyView> list = studyDao.getViewListByStatusId(ids, leaderId, statusId);

		return list;

	}

	@Override
	public int getLastId() {
		Study study = studyDao.getLast();
		return study.getId();
	}

	@Override
	public int insertFile(StudyFile studyFile) {
		// TODO Auto-generated method stub
		return studyFileDao.insert(studyFile);
	}

	@Override
	public int insertSkill(StudySkill sk) {
		// TODO Auto-generated method stub
		return studySkillDao.insert(sk);
	}

	@Override
	public int insertLanguage(StudyLanguage sl) {
		// TODO Auto-generated method stub
		return studyLanguageDao.insert(sl);
	}



	@Override
	public int check(int i, int id) {
		// TODO Auto-generated method stub
		return studyApplyDao.check(i,id);	}

}
