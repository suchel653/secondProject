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
		
		int memberId = 4;
		List<StudyView> ongoingStudyView = studyService.getOngoingViewList(4);
//		List<StudyView> waitingStudyView = studyService.getWaitingViewList(4);
//		List<StudyView> endedStudyView = studyService.getEndedViewList(4);
		model.addAttribute("osv",ongoingStudyView);
//		model.addAttribute("wsv",ongoingStudyView);
//		model.addAttribute("esv",ongoingStudyView);
		
		return "customer.activity.index";
	}

}
