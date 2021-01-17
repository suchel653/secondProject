package com.ggiriggiri.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ggiriggiri.web.dao.StudyDao;

@Service
public class StudyServiceImp implements StudyService{

	@Autowired
	private StudyDao studyDao;
}
