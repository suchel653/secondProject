package com.ggiriggiri.web.dao;

import java.util.List;

import com.ggiriggiri.web.entity.Study;
import com.ggiriggiri.web.entity.StudyView;

public interface StudyDao {

	//List<Study> getList(int offset, int size, String field, String query);

	int insert(Study study);
	int update(Study study);
	int delete(int id);
	
	Study get(int id);
	StudyView getView(int id);
	
	StudyView getPrev(int id);
	StudyView getNext(int id);

	int getCount(int[] ids, String title, String query);

	List<StudyView> getViewList(int[] ids, int offset, int size, String title, String query);

	int[] getIdsByFieldNames(String[] field);
	
	int[] getIdsByLeaderId(int leaderId, int statusId);
	List<StudyView> getViewListByStatusId(int[] ids, int leaderId, int statusId);

	Study getLast();
	int updateStatusById(int id, int statusId);


	
	
	



	

	


}
