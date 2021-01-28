package com.ggiriggiri.web.controller.customer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ggiriggiri.web.entity.StudyView;
import com.ggiriggiri.web.service.StudyService;

@Controller
@RequestMapping("/customer/activity/")
public class ActivityController {
	
	@Autowired
	private StudyService studyService;
	
	@RequestMapping("index")
	public String index(Model model) {
		
		int memberId = 1;
		List<StudyView> ongoingStudyView = studyService.getOngoingViewList(memberId);
		List<StudyView> waitingStudyView = studyService.getWaitingViewList(memberId);
		List<StudyView> endedStudyView = studyService.getEndedViewList(memberId);
		model.addAttribute("osv",ongoingStudyView);
		model.addAttribute("wsv",waitingStudyView);
		model.addAttribute("esv",endedStudyView);
		for(StudyView sv : ongoingStudyView)
			System.out.println(sv);
		return "customer.activity.index";
	}

}
