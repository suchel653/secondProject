package com.ggiriggiri.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ggiriggiri.web.dao.ProjectDao;
import com.ggiriggiri.web.entity.Project;

@Service
public class ProjectServiceImp implements ProjectService{

	@Autowired
	private ProjectDao projectDao;

	@Override
	public int insert(Project project) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Project project) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Project get(int id) {
		return projectDao.get(id);
	}

	@Override
	public List<Project> getList(int page, int size, String field, String query) {
		int offset = (page-1)*10;
		return projectDao.getList(offset, size, field, query);
	}

//	@Override
//	public List<Project> getViewList(int page, int size, String field, String query) {
//		// TODO Auto-generated method stub
//		return null;
//	}

	@Override
	public int getCount(String field, String query) {
		// TODO Auto-generated method stub
		return 0;
	}
}
