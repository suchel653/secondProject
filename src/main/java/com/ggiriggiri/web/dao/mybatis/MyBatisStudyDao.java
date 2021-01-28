package com.ggiriggiri.web.dao.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ggiriggiri.web.dao.StudyDao;
import com.ggiriggiri.web.entity.Study;
import com.ggiriggiri.web.entity.StudyView;


@Repository
public class MyBatisStudyDao implements StudyDao{
	
	
	private StudyDao mapper;
	
	@Autowired
	public MyBatisStudyDao(SqlSession session) {
		
		mapper = session.getMapper(StudyDao.class);
		
	}


	@Override
	public int insert(Study study) {
		// TODO Auto-generated method stub
		return mapper.insert(study);
	}

	@Override
	public int update(Study study) {
		// TODO Auto-generated method stub
		return mapper.update(study);
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return mapper.delete(id);
	}

	@Override
	public Study get(int id) {
		// TODO Auto-generated method stub
		return mapper.get(id);
	}



	@Override
	public StudyView getPrev(int id) {
		// TODO Auto-generated method stub
		return mapper.getPrev(id);
	}

	@Override
	public StudyView getNext(int id) {
		// TODO Auto-generated method stub
		return mapper.getNext(id);
	}

	@Override
	public List<StudyView> getViewList(int[] ids,int offset, int size, String title, String query) {
		
		return mapper.getViewList(ids,offset, size, title, query);
	}

	@Override
	public int[] getByStudyIds(String[] field) {
		if(field.length==0)
			field=null;
		return mapper.getByStudyIds(field);
	}


	@Override
	public int getCount(int[] ids, String title, String query) {
		// TODO Auto-generated method stub
		return mapper.getCount(ids, title, query);
	}

	@Override
	public StudyView getView(int id) {
		// TODO Auto-generated method stub
		return mapper.getView(id);
	}


	@Override
	public List<StudyView> getViewListByStatusId(int[] ids, int leaderId, int statusId) {
		// TODO Auto-generated method stub
		return mapper.getViewListByStatusId(ids,leaderId,statusId);
	}

	
}
