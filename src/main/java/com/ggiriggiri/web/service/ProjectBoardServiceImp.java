package com.ggiriggiri.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ggiriggiri.web.dao.ProjectBoardDao;
import com.ggiriggiri.web.dao.ProjectCommentDao;
import com.ggiriggiri.web.entity.ProjectBoard;
import com.ggiriggiri.web.entity.ProjectBoardView;
import com.ggiriggiri.web.entity.StudyView;

@Service
public class ProjectBoardServiceImp implements ProjectBoardService{
	
	@Autowired
	private ProjectBoardDao projectBoardDao;
	
	@Override
	public List<ProjectBoardView> getViewList(int projectId) {

		return projectBoardDao.getViewListByProjectId(projectId);
	}

	@Override
	public int insert(ProjectBoard projectBoard) {
		// TODO Auto-generated method stub
		return projectBoardDao.insert(projectBoard);
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return projectBoardDao.delete(id);
	}

	@Override
	public ProjectBoard get(int id) {
		// TODO Auto-generated method stub
		return projectBoardDao.get(id);
	}

	@Override
	public int update(ProjectBoard projectBoard) {
		// TODO Auto-generated method stub
		return projectBoardDao.update(projectBoard);
	}

	@Override
	public ProjectBoardView getView(int id) {
		// TODO Auto-generated method stub
		return projectBoardDao.getView(id);
	}

}
