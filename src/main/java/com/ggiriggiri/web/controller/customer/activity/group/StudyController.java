package com.ggiriggiri.web.controller.customer.activity.group;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ggiriggiri.web.entity.StudyApplyView;
import com.ggiriggiri.web.entity.StudyView;
import com.ggiriggiri.web.service.StudyApplyService;
import com.ggiriggiri.web.service.StudyService;

@Controller("groupStudyController")
@RequestMapping("/customer/activity/group/study/{id}/")
public class StudyController {

	@Autowired
	StudyService studyService;

	@Autowired
	StudyApplyService studyApplyService;

	@GetMapping("index")
	public String index(@PathVariable("id") int id, HttpSession session, Model model) {

		StudyView studyView = studyService.getView(id);
		List<StudyApplyView> studyApplyViewList = studyApplyService.getViewByStudyId(id);

		model.addAttribute("sv", studyView);
		model.addAttribute("sav", studyApplyViewList);

		return "customer.activity.group.study." + id + ".index";

	}

	@GetMapping("info")
	public String info(@PathVariable("id") int id, HttpSession session, Model model) {
		
		StudyView studyView = studyService.getView(id);
		
		model.addAttribute("s", studyView);
		
		return "customer.activity.group.study." + id + ".info";
	}

}
