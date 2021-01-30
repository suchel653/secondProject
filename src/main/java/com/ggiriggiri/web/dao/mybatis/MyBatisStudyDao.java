package com.ggiriggiri.web.dao.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ggiriggiri.web.dao.StudyDao;
import com.ggiriggiri.web.entity.Study;
import com.ggiriggiri.web.entity.StudyView;

@Repository
public class MyBatisStudyDao implements StudyDao {

	private StudyDao mapper;

	@Autowired
	public MyBatisStudyDao(SqlSession session) {

		mapper = session.getMapper(StudyDao.class);

	}

	@Override
	public int insert(Study study) {
		return mapper.insert(study);
	}

	@Override
	public int update(Study study) {
		return mapper.update(study);
	}

	@Override
	public int delete(int id) {
		return mapper.delete(id);
	}

	@Override
	public Study get(int id) {
		return mapper.get(id);
	}

	@Override
	public StudyView getPrev(int id) {
		return mapper.getPrev(id);
	}

	@Override
	public StudyView getNext(int id) {
		return mapper.getNext(id);
	}

	@Override
	public List<StudyView> getViewList(int[] ids, int offset, int size, String title, String query) {
		return mapper.getViewList(ids, offset, size, title, query);
	}

	@Override
	public int[] getIdsByFieldNames(String[] field) {
		if (field.length == 0)
			field = null;
		return mapper.getIdsByFieldNames(field);
	}

	@Override
	public int getCount(int[] ids, String title, String query) {
		return mapper.getCount(ids, title, query);
	}

	@Override
	public StudyView getView(int id) {
		return mapper.getView(id);
	}

	@Override
	public int[] getIdsByLeaderId(int leaderId, int statusId) {
		return mapper.getIdsByLeaderId(leaderId, statusId);
	}

	@Override
	public List<StudyView> getViewListByStatusId(int[] ids, int leaderId, int statusId) {
		return mapper.getViewListByStatusId(ids, leaderId, statusId);
	}

}
