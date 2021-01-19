package com.ggiriggiri.web.dao;

import java.util.List;

import com.ggiriggiri.web.entity.ContestFile;

public interface ContestFileDao {
	
	int insert(ContestFile contestFile);
	int update(ContestFile contestFile);
	int delete(int id);
	
	List<ContestFile> getList(int contestId);
	
	ContestFile get(int id);
	
	int getCount(String field, String query);
}
