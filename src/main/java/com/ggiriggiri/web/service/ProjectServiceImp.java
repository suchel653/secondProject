package com.ggiriggiri.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ggiriggiri.web.dao.LanguageDao;
import com.ggiriggiri.web.dao.ProjectDao;
import com.ggiriggiri.web.entity.Language;
import com.ggiriggiri.web.entity.Project;

@Service
public class ProjectServiceImp implements ProjectService{

	@Autowired
	private ProjectDao projectDao;
	
	@Autowired
	private LanguageDao languageDao;
	
	@Override
	public int insert(Project project) {
		// TODO Auto-generated method stub
		return projectDao.insert(project);
	}

	@Override
	public int update(Project project) {
		// TODO Auto-generated method stub
		return projectDao.update(project);
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return projectDao.delete(id);
	}

	@Override
	public Project get(int id) {
		return projectDao.get(id);
	}

	@Override
	public List<Project> getList(int page, int size, String field, String query) {
		int offset = (page-1)*10;
		
		List<Project> list = projectDao.getList(offset, size, field, query);
		
		for(Project p : list) {
			p.setLanguages(languageDao.getListByProjectId(p.getId()));
		}
			
		return list;
	}

//	@Override
//	public List<Project> getViewList(int page, int size, String field, String query) {
//		// TODO Auto-generated method stub
//		return null;
//	}

	@Override
	public int getCount(String field, String query) {
		
		return projectDao.getCount(field, query);
	}
}
