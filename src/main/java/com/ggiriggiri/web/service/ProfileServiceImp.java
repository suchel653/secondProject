package com.ggiriggiri.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ggiriggiri.web.dao.LanguageDao;
import com.ggiriggiri.web.dao.ProfileDao;
import com.ggiriggiri.web.dao.ProfileExperienceDao;
import com.ggiriggiri.web.dao.ProfileLanguageDao;
import com.ggiriggiri.web.dao.ProfileProjectDao;
import com.ggiriggiri.web.dao.ProfileSkillDao;
import com.ggiriggiri.web.dao.ProfileStudyDao;
import com.ggiriggiri.web.dao.SkillDao;
import com.ggiriggiri.web.entity.Profile;
import com.ggiriggiri.web.entity.Skill;

@Service
public class ProfileServiceImp implements ProfileService{
	
	@Autowired
	private ProfileDao profileDao;
	@Autowired
	private ProfileExperienceDao experienceDao;
	@Autowired
	private ProfileProjectDao projectDao;
	@Autowired
	private ProfileSkillDao profileSkillDao;
	@Autowired
	private ProfileLanguageDao profileLanguageDao;
	@Autowired
	private ProfileStudyDao studyDao;
	@Autowired
	private SkillDao skillDao;
	@Autowired
	private LanguageDao languageDao;
	
	@Override
	public int insert(Profile profile) {
		profileDao.insert(profile);
		for(int i=0; i<skillDao.getList().size(); i++)
			profileSkillDao.insert(profileDao.get(profile.getMemberId()).getId(),i+1);
		for(int i=0; i<languageDao.getList().size(); i++)
			profileLanguageDao.insert(profileDao.get(profile.getMemberId()).getId(),i+1);
		return 0;
	}

	@Override
	public int update(Profile profile) {
		profileDao.update(profile);
		for(int i=0; i<languageDao.getList().size(); i++)
			profileLanguageDao.update(profileDao.get(profile.getMemberId()).getId(),i+1, profile.getLanguageList().get(i).getLevel());
		return 0;
	}

	@Override
	public Profile get(int id) {
		
		Profile p = profileDao.get(id);
		p.setExperienceList(experienceDao.getListByProfileId(p.getId()));
		p.setProjectList(projectDao.getListByProfileId(p.getId()));
		p.setSkillList(profileSkillDao.getViewListByProfileId(p.getId()));
		p.setLanguageList(profileLanguageDao.getViewListByProfileId(p.getId()));
		p.setStudyList(studyDao.getListByProfileId(p.getId()));
		return p;
	}

	

}
