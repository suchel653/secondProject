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
	
	@Autowired
	private ProjectCommentDao projectCommentDao;

	@Override
	public List<ProjectBoardView> getViewList(int projectId) {
		List<ProjectBoardView> list = projectBoardDao.getViewListByProjectId(projectId);

		for (ProjectBoardView pb : list) {
			pb.setComment(projectCommentDao.getViewListByBoardId(pb.getId()));
		}

		return list;
	}

	@Override
	public int insert(ProjectBoard projectBoard) {
		// TODO Auto-generated method stub
		return projectBoardDao.insert(projectBoard);
	}

}
