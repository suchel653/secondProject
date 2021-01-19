package com.ggiriggiri.web.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ggiriggiri.web.entity.Contest;

@Service
public interface ContestService {
	
	int insert(Contest contest);
	int update(Contest contest);
	int delete(int id);
	
	Contest get(int id);
	
	List<Contest> getList(int page, int size, String field, String query);
	
	int getCount(String field,String query);
}
