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
	public List<Member> getList(int offset, int size, String field, String query) {
		return memberDao.getList(offset, size, field, query);
	}

	@Override
	public Member get(int id) {
		
		Member m = memberDao.get(id);
		
		Profile p = profileDao.get(id);
		p.setExperienceList(experienceDao.getListByProfileId(id));
		p.setProjectList(projectDao.getListByProfileId(id));
		p.setSkillList(skillDao.getViewListByProfileId(id));
		p.setLanguageList(languageDao.getViewListByProfileId(id));
		
		m.setProfile(p);
		
		return m;
	}

}
