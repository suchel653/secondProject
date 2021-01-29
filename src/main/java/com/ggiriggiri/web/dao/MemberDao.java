package com.ggiriggiri.web.dao;

import java.util.List;

import com.ggiriggiri.web.entity.Member;

public interface MemberDao {
	
	int insert(Member member);
	int update(Member member);
	int delete(int id);
	
	List<Member> getList();
	List<Member> getList(int offset, int size, String field, String query);
	Member get(int id);
	int check(String field, String query);

}
