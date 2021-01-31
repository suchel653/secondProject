package com.ggiriggiri.web.service;

import java.util.List;

import com.ggiriggiri.web.entity.StudyApplyView;

public interface StudyApplyService {

	List<StudyApplyView> getViewList(int leaderId);

	List<StudyApplyView> getResultViewList(int memberId);

}
