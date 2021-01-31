package com.ggiriggiri.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ggiriggiri.web.dao.ProjectApplyDao;
import com.ggiriggiri.web.dao.ProjectDao;
import com.ggiriggiri.web.dao.ProjectFileDao;
import com.ggiriggiri.web.dao.ProjectLanguageDao;
import com.ggiriggiri.web.dao.ProjectSkillDao;
import com.ggiriggiri.web.entity.Project;
import com.ggiriggiri.web.entity.ProjectApply;
import com.ggiriggiri.web.entity.ProjectFile;
import com.ggiriggiri.web.entity.ProjectLanguage;
import com.ggiriggiri.web.entity.ProjectSkill;
import com.ggiriggiri.web.entity.ProjectView;
import com.ggiriggiri.web.entity.StudyView;

@Service
public class ProjectServiceImp implements ProjectService {

	@Autowired
	private ProjectDao projectDao;

	@Autowired
	private ProjectLanguageDao projectLanguageDao;

	@Autowired
	private ProjectSkillDao projectSkilldao;

	@Autowired
	private ProjectFileDao projectFileDao;

	@Autowired
	private ProjectApplyDao projectApplyDao;

	@Override
	public int insert(Project project) {
		return projectDao.insert(project);
	}

	@Override
	public int update(Project project) {
		return projectDao.update(project);
	}

	@Override
	public int delete(int id) {
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
		int offset = (page - 1) * 10;

		List<Project> list = projectDao.getList(offset, size, field, query);

		for (Project p : list) {
			p.setLanguages(projectLanguageDao.getListByProjectId(p.getId()));
			p.setSkills(projectSkilldao.getListByProjectId(p.getId()));
		}

		return list;
	}

//	@Override
//	public List<Project> getViewList(int page, int size, String field, String query) {
//		return null;
//	}

	@Override
	public int getCount(String title, String query, String[] field, String[] skill, String[] language) {
		int[] projectIds = projectDao.getIdsByFieldNames(field);
		if (projectIds.length == 0)
			return 0;
		projectIds = projectSkilldao.getProjectIdsBySkillNames(projectIds, skill);
		if (projectIds.length == 0)
			return 0;
		projectIds = projectLanguageDao.getProjectIdsByLanguageNames(projectIds, language);
		if (projectIds.length == 0)
			return 0;

		int[] ids = projectIds;
		return projectDao.getCount(ids, title, query);
	}

	@Override
	public List<ProjectView> getViewList(int page, int size, String title, String query, String[] field, String[] skill,
			String[] language) {

		int[] projectIds = projectDao.getIdsByFieldNames(field);
		if (projectIds.length == 0)
			return null;

		projectIds = projectSkilldao.getProjectIdsBySkillNames(projectIds, skill);
		if (projectIds.length == 0)
			return null;

		projectIds = projectLanguageDao.getProjectIdsByLanguageNames(projectIds, language);
		if (projectIds.length == 0)
			return null;

		int offset = (page - 1) * size;
		int[] ids = projectIds;
		List<ProjectView> list = projectDao.getViewList(ids, offset, size, title, query);

		for (ProjectView p : list) {
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

	@Override
	public int insertProjectApply(ProjectApply projectApply) {

		return projectApplyDao.insertProjectApply(projectApply);
	}

	@Override
	public List<ProjectView> getOngoingViewList(int memberId) {
		int[] projectIds = projectApplyDao.getProjectIdsByMemberId(memberId, 1);
		int leaderId = memberId;
		int statusId = 2;
		if (projectIds.length == 0)
			return null;

		int[] ids = projectIds;
		List<ProjectView> list = projectDao.getViewListByStatusId(ids, leaderId, statusId);

		return list;
	}

	@Override
	public List<ProjectView> getWaitingViewList(int memberId) {
		int[] projectIds = projectApplyDao.getProjectIdsByMemberId(memberId, 1);
		int leaderId = memberId;
		int statusId = 1;
		if (projectIds.length == 0)
			return null;

		int[] ids = projectIds;
		List<ProjectView> list = projectDao.getViewListByStatusId(ids, leaderId, statusId);

		return list;
	}

	@Override
	public List<ProjectView> getEndedViewList(int memberId) {
		int[] projectIds = projectApplyDao.getProjectIdsByMemberId(memberId, 1);
		int leaderId = memberId;
		int statusId = 3;
		if (projectIds.length == 0)
			return null;

		int[] ids = projectIds;
		List<ProjectView> list = projectDao.getViewListByStatusId(ids, leaderId, statusId);

		return list;
	}
}
