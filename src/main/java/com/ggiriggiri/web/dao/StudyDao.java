package com.ggiriggiri.web.dao;

import java.util.List;

import com.ggiriggiri.web.entity.Study;

public interface StudyDao {

	List<Study> getList(int offset, int size, String field, String query);

	int insert(Study study);
	int update(Study study);
	int delete(int id);
	Study get(int id);
	int getCount(String field, String query);
	Study getPrev(Integer id);
	Study getNext(Integer id);



	

	

	
}
