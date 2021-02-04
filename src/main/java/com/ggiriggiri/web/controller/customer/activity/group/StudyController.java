package com.ggiriggiri.web.controller.customer.activity.group;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ggiriggiri.web.entity.StudyApplyView;
import com.ggiriggiri.web.entity.StudyView;
import com.ggiriggiri.web.service.StudyApplyService;
import com.ggiriggiri.web.service.StudyService;

@Controller("groupStudyController")
@RequestMapping("/customer/activity/group/study/")
public class StudyController {

	@Autowired
	StudyService studyService;

	@Autowired
	StudyApplyService studyApplyService;

	@GetMapping("{id}/index")
	public String index(@PathVariable("id") int id, HttpSession session, Model model
			,@RequestParam(name="pageStatus", defaultValue="0") int pageStatus) {

		StudyView studyView = studyService.getView(id);
		List<StudyApplyView> studyApplyViewList = studyApplyService.getViewByStudyId(id);
		List<StudyApplyView> studyWaitingViewLIst = studyApplyService.getWaitingViewByStudyId(id);

		model.addAttribute("sv", studyView);
		model.addAttribute("sav", studyApplyViewList);
		model.addAttribute("swv", studyWaitingViewLIst);
		model.addAttribute("pageStatus", pageStatus);

		return "customer.activity.group.study.index";

	}

	@GetMapping("{id}/info")
	public String info(@PathVariable("id") int id, HttpSession session, Model model) {

		StudyView studyView = studyService.getView(id);

		model.addAttribute("s", studyView);

		return "customer.activity.group.study.info";
	}

	@PostMapping("{id}/approve")
	public String approve(String action, Integer memberId, @PathVariable("id") int studyId) {

		if (action.equals("승인")) {
			studyApplyService.updateStatusToApprove(memberId, studyId);
		} else if (action.equals("거절")) {
			studyApplyService.updateStatusToReject(memberId, studyId);
		}

		return "redirect:index";
	}

}
