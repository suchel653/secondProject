package com.ggiriggiri.web.dao;

import java.util.List;

import com.ggiriggiri.web.entity.Study;
import com.ggiriggiri.web.entity.StudyView;

public interface StudyDao {

	//List<Study> getList(int offset, int size, String field, String query);

	int insert(Study study);
	int update(Study study);
	int delete(int id);
	StudyView getView(int id);
	Study get(int id);
	
	StudyView getPrev(int id);
	StudyView getNext(int id);



	int[] getByStudyIds(String[] field);


	List<StudyView> getViewList(int[] ids, int offset, int size, String title, String query);
	int getCount(int[] ids, String title, String query);

	List<StudyView> getViewListByStatusId(int[] ids, int leaderId, int statusId);


	
	
	



	

	

	
}
