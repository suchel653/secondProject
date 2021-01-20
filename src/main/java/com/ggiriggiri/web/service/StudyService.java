package com.ggiriggiri.web.service;

import java.util.List;

import com.ggiriggiri.web.entity.Study;




public interface StudyService {
	int insert(Study study);
	int update(Study study);
	int delete(int id);
	Study get(int id);
	List<Study> getList(int page,int size, String field,String query);
	int getCount(String field, String query);
	Study getPrev(Integer id);
	Study getNext(Integer id);

}
