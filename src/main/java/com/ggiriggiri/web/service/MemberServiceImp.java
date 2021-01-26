package com.ggiriggiri.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ggiriggiri.web.dao.MemberDao;
import com.ggiriggiri.web.entity.Member;

@Service
public class MemberServiceImp implements MemberService{

	@Autowired
	private MemberDao memberDao;
	
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

}
