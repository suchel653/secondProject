package com.ggiriggiri.web.dao;

import java.util.List;

import com.ggiriggiri.web.entity.StudyFile;

public interface StudyFileDao {

	int insert(StudyFile studyFile);
	StudyFile get(int id);
	List<StudyFile> getList(int studyId);



}
