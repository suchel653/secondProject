package com.ggiriggiri.web.controller.customer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ggiriggiri.web.entity.ProjectApplyView;
import com.ggiriggiri.web.entity.ProjectView;
import com.ggiriggiri.web.entity.StudyApplyView;
import com.ggiriggiri.web.entity.StudyView;
import com.ggiriggiri.web.service.ProjectApplyService;
import com.ggiriggiri.web.service.ProjectService;
import com.ggiriggiri.web.service.StudyApplyService;
import com.ggiriggiri.web.service.StudyService;

@Controller
@RequestMapping("/customer/activity/")
public class ActivityController {
	
	@Autowired
	private StudyService studyService;
	
	@Autowired
	private StudyApplyService studyApplyService;
	
	@Autowired
	private ProjectService projectService;
	
	@Autowired
	private ProjectApplyService projectApplyService;
	
	@RequestMapping("index")
	public String index(Model model) {
		
		int memberId = 2;
		List<StudyApplyView> studyApplyViewList = studyApplyService.getViewList(memberId);
		List<StudyApplyView> studyApplyResultViewList = studyApplyService.getResultViewList(memberId);
		
		List<ProjectApplyView> projectApplyViewList = projectApplyService.getViewList(memberId);
		List<ProjectApplyView> projectApplyResultViewList = projectApplyService.getResultViewList(memberId);
		
		List<StudyView> ongoingStudyViewList = studyService.getOngoingViewList(memberId);
		List<StudyView> waitingStudyViewList = studyService.getWaitingViewList(memberId);
		List<StudyView> endedStudyViewList = studyService.getEndedViewList(memberId);
		
		List<ProjectView> ongoingProjectViewList = projectService.getOngoingViewList(memberId);
//		List<ProjectView> waitingProjectViewList = projectService.getWaitingViewList(memberId);
//		List<ProjectView> endedProjectViewList = projectService.getEndedViewList(memberId);
		
		model.addAttribute("sav", studyApplyViewList);
		model.addAttribute("sarv", studyApplyResultViewList);
		model.addAttribute("pav", projectApplyViewList);
		model.addAttribute("parv", projectApplyResultViewList);
		
		
		model.addAttribute("osv", ongoingStudyViewList);
		model.addAttribute("wsv", waitingStudyViewList);
		model.addAttribute("esv", endedStudyViewList);
		
		return "customer.activity.index";
	}

}
