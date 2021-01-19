package com.ggiriggiri.web.dao;

import java.util.List;

import com.ggiriggiri.web.entity.ContestImage;

public interface ContestImageDao {
	
	int insert(ContestImage contestImage);
	int update(ContestImage contestImage);
	int delete(int id);
	
	List<ContestImage> getList(int contestId);
	
	ContestImage get(int id);
	
	int getCount(String field, String query);
}
