package com.ggiriggiri.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ggiriggiri.web.dao.ProjectCommentDao;
import com.ggiriggiri.web.entity.ProjectComment;
import com.ggiriggiri.web.entity.ProjectCommentView;

@Service
public class ProjectCommentServiceImp implements ProjectCommentService{
	
	@Autowired
	private ProjectCommentDao projectCommentDao;

	@Override
	public List<ProjectCommentView> getViewList(int boardId) {
		// TODO Auto-generated method stub
		return projectCommentDao.getViewListByBoardId(boardId);
	}

	@Override
	public int insert(ProjectComment projectComment) {
		// TODO Auto-generated method stub
		return projectCommentDao.insert(projectComment);
	}

}
