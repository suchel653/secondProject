package com.ggiriggiri.web.dao.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ggiriggiri.web.dao.ProjectDao;
import com.ggiriggiri.web.entity.Project;
import com.ggiriggiri.web.entity.ProjectView;

@Repository
public class MybatisProjectDao implements ProjectDao {
	
	private ProjectDao mapper;
	
	/* 생성자 */
	@Autowired 
	public MybatisProjectDao(SqlSession session) {
		mapper = session.getMapper(ProjectDao.class);
	}

	@Override
	public int insert(Project project) {
		return mapper.insert(project);
	}

	@Override
	public int update(Project project) {
		return mapper.update(project);
	}

	@Override
	public int delete(int id) {
		return mapper.delete(id);
	}

	@Override
	public Project get(int id) {
		return mapper.get(id);
	}

	@Override
	public List<Project> getList(int startIndex, int endIndex, String field, String query) {
		return mapper.getList(startIndex, endIndex, field, query);
	}

//	@Override
//	public List<ProjectView> getViewList(int startIndex, int endIndex, String field, String query) {
//		return null;
//	}

	@Override
	public int getCount(String field, String query) {
		return mapper.getCount(field, query);
	}

	@Override
	public List<Project> getList() {
		return mapper.getList();
	}

	@Override
	public List<ProjectView> getViewList(int offset, int size, String title, String query, String[] field) {
		if(field.length == 0)
			field=null;
		return mapper.getViewList(offset, size, title, query, field);
	}
	
}
