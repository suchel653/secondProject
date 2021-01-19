package com.ggiriggiri.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ggiriggiri.web.dao.StudyDao;
import com.ggiriggiri.web.entity.Study;

@Service
public class StudyServiceImp implements StudyService{

	@Autowired
	private StudyDao studyDao;


}
