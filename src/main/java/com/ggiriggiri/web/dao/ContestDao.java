package com.ggiriggiri.web.dao;

import java.util.List;

import com.ggiriggiri.web.entity.Contest;

public interface ContestDao {
	
	int insert(Contest contest);
	int update(Contest contest);
	int delete(int id);
	
	List<Contest> getList();
	List<Contest> getList(int offset, int size);
	List<Contest> getList(int offset, int size, String field, String query);
	
//	List<ContestView> getViewList();
//	List<ContestView> getViewList(int offset, int size);
//	List<ContestView> getViewList(int offset, int size, String field, String query);
	
	Contest get(int id);
	
	int getCount(String field, String query);
	
	Contest getPrev(Integer id);
	Contest getNext(Integer id);
}
