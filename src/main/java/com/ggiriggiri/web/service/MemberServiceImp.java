package com.ggiriggiri.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ggiriggiri.web.dao.MemberDao;
import com.ggiriggiri.web.dao.ProfileDao;
import com.ggiriggiri.web.dao.ProfileExperienceDao;
import com.ggiriggiri.web.dao.ProfileLanguageDao;
import com.ggiriggiri.web.dao.ProfileProjectDao;
import com.ggiriggiri.web.dao.ProfileSkillDao;
import com.ggiriggiri.web.dao.ProfileStudyDao;
import com.ggiriggiri.web.entity.Member;
import com.ggiriggiri.web.entity.Profile;

@Service
public class MemberServiceImp implements MemberService{

	@Autowired
	private MemberDao memberDao;
	@Autowired
	private ProfileDao profileDao;
	@Autowired
	private ProfileExperienceDao experienceDao;
	@Autowired
	private ProfileProjectDao projectDao;
	@Autowired
	private ProfileSkillDao skillDao;
	@Autowired
	private ProfileLanguageDao languageDao;
	@Autowired
	private ProfileStudyDao studyDao;
	
	@Override
	public int insert(Member member) {
		return memberDao.insert(member);
	}

	@Override
	public int update(Member member) {
		return memberDao.update(member);
	}

	@Override
	public int delete(int id) {
		return memberDao.delete(id);
	}

	@Override
	public List<Member> getList() {
		return memberDao.getList();
	}

	@Override
	public List<Member> getList(int page, int size, String field, String query) {
		
		int offset = size*(page-1);
		
		return memberDao.getList(offset, size, field, query);
	}

	@Override
	public Member get(int id) {
		
		Member m = memberDao.get(id);

		Profile p = new Profile();
		if(profileDao.get(id) != null)
			p = profileDao.get(id);

		p.setExperienceList(experienceDao.getListByProfileId(p.getId()));
		p.setProjectList(projectDao.getListByProfileId(p.getId()));
		p.setSkillList(skillDao.getViewListByProfileId(p.getId()));
		p.setLanguageList(languageDao.getViewListByProfileId(p.getId()));
		p.setStudyList(studyDao.getListByProfileId(p.getId()));
		
		m.setProfile(p);
		
		return m;
	}

	@Override
	public int check(String field, String query) {
		return memberDao.check(field, query);
	}

	@Override
	public Member get(String email) {
		
		Member m = memberDao.getByEmail(email);
		
		
		Profile p = profileDao.get(m.getId());
		if(p != null) 
			m.setProfile(p);
		return m;
	}

	@Override
	public int getLast() {
		return memberDao.getLast();
	}

	@Override
	public int getCount(String field,String query) {

		return memberDao.getCount(field,query);
	}

}
