package com.ggiriggiri.web.dao.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ggiriggiri.web.dao.ProjectFileDao;
import com.ggiriggiri.web.entity.ProjectFile;

@Repository
public class MybatisProjectFileDao implements ProjectFileDao {

	private SqlSession session;
	private ProjectFileDao mapper;
	
	@Autowired
	public MybatisProjectFileDao(SqlSession session) {
		this.session = session;
		mapper = session.getMapper(ProjectFileDao.class);

	}
	@Override
	public int insert(ProjectFile projectFile) {
		return mapper.insert(projectFile);
	}

	@Override
	public ProjectFile get(int id) {
		return mapper.get(id);
	}
	
	@Override
	public List<ProjectFile> getList(int projectId) {
		return mapper.getList(projectId);
	}
	@Override
	public int update(ProjectFile projectFile) {
		return mapper.update(projectFile);
	}
	@Override
	public int getId(int projectId, String name) {
		return mapper.getId(projectId, name);
	}
	
	

}
