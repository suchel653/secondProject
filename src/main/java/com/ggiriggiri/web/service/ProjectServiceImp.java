package com.ggiriggiri.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ggiriggiri.web.dao.ProjectDao;
import com.ggiriggiri.web.dao.ProjectFileDao;
import com.ggiriggiri.web.dao.ProjectLanguageDao;
import com.ggiriggiri.web.dao.ProjectSkillDao;
import com.ggiriggiri.web.entity.Project;
import com.ggiriggiri.web.entity.ProjectFile;
import com.ggiriggiri.web.entity.ProjectLanguage;
import com.ggiriggiri.web.entity.ProjectSkill;
import com.ggiriggiri.web.entity.ProjectView;

@Service
public class ProjectServiceImp implements ProjectService{

	@Autowired
	private ProjectDao projectDao;
	
	@Autowired
	private ProjectLanguageDao projectLanguageDao;
	
	@Autowired
	private ProjectSkillDao projectSkilldao;
	
	@Autowired
	private ProjectFileDao projectFileDao;
	
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
		Project p = projectDao.get(id);
		p.setLanguages(projectLanguageDao.getListByProjectId(p.getId()));
		p.setSkills(projectSkilldao.getListByProjectId(p.getId()));
		
		return p;
	}

	@Override
	public List<Project> getList(int page, int size, String field, String query) {
		int offset = (page-1)*10;
		
		List<Project> list = projectDao.getList(offset, size, field, query);
		
		for(Project p : list) {
			p.setLanguages(projectLanguageDao.getListByProjectId(p.getId()));
			p.setSkills(projectSkilldao.getListByProjectId(p.getId()));
		}
			
		return list;
	}

//	@Override
//	public List<Project> getViewList(int page, int size, String field, String query) {
//		// TODO Auto-generated method stub
//		return null;
//	}

	@Override
	public int getCount(String title, String query, String[] field, String[] skill, String[] language) {
		int[] projectIds = projectDao.getIdsByFieldNames(field);
		if(projectIds.length==0)
			return 0;
		projectIds = projectSkilldao.getProjectIdsBySkillNames(projectIds,skill);
		if(projectIds.length==0)
			return 0;
		projectIds = projectLanguageDao.getProjectIdsByLanguageNames(projectIds, language);
		if(projectIds.length==0)
			return 0;
		
		int[] ids = projectIds;
		return projectDao.getCount(ids,title,query);
	}

	@Override
	public List<ProjectView> getViewList(int page, int size, String title, String query, String[] field, String[] skill,
			String[] language) {
		
		int[] projectIds = projectDao.getIdsByFieldNames(field);
		if(projectIds.length==0)
			return null;
		
		projectIds = projectSkilldao.getProjectIdsBySkillNames(projectIds, skill);
		if(projectIds.length==0)
			return null;
		
		projectIds = projectLanguageDao.getProjectIdsByLanguageNames(projectIds,language);
		if(projectIds.length==0)
			return null;
		
		
		int offset = (page-1) * size;
		int[] ids = projectIds;
		List<ProjectView> list = projectDao.getViewList(ids, offset, size, title, query);
		
		for(ProjectView p : list) {
			p.setSkills(projectSkilldao.getListByProjectId(p.getId()));
			p.setLanguages(projectLanguageDao.getListByProjectId(p.getId()));
		}
			
		return list;
	}

	@Override
	public ProjectView getView(int id) {
		
		ProjectView pv = projectDao.getView(id);
		
		
		pv.setLanguages(projectLanguageDao.getListByProjectId(pv.getId()));
		pv.setSkills(projectSkilldao.getListByProjectId(pv.getId()));
		pv.setFiles(projectFileDao.getList(pv.getId()));
		
		
		return pv;
	}

	@Override
	public ProjectView getPrev(int id) {
		
		return projectDao.getPrev(id);
	}

	@Override
	public ProjectView getNext(int id) {
		return projectDao.getNext(id);
	}

	@Override
	public int getLastId() {
		Project project = projectDao.getLast();
		return project.getId();
	}

	@Override
	public int insertSkill(ProjectSkill projectSkill) {
		// TODO Auto-generated method stub
		return projectSkilldao.insert(projectSkill);
	}

	@Override
	public int insertLanguage(ProjectLanguage projectLanguage) {
		return projectLanguageDao.insert(projectLanguage);
	}

	@Override
	public int insertFile(ProjectFile projectFile) {
		
		return projectFileDao.insert(projectFile);
	} 
}
