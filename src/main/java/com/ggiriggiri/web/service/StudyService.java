package com.ggiriggiri.web.service;

import java.util.List;

import com.ggiriggiri.web.entity.Study;
import com.ggiriggiri.web.entity.StudyView;




public interface StudyService {
	int insert(Study study);
	int update(Study study);
	int delete(int id);
	Study get(int id);
	//List<Study> getList(int page,int size, String field,String query);
	//int getCount(String field, String query);

	
	List<StudyView> getViewList(int page, int size, String title, String query, String[] field, String[] skill,
			String[] language);
	int getCount(String title, String query, String[] field, String[] skill, String[] language);
	
	StudyView getView(int id);
	StudyView getPrev(int id);
	StudyView getNext(int id);
	List<StudyView> getOngoingViewList(int memberId);

}
