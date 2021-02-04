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

import com.ggiriggiri.web.entity.ProjectApplyView;
import com.ggiriggiri.web.entity.ProjectBoardView;
import com.ggiriggiri.web.entity.ProjectView;
import com.ggiriggiri.web.service.ProjectApplyService;
import com.ggiriggiri.web.service.ProjectBoardService;
import com.ggiriggiri.web.service.ProjectService;

@Controller("groupProjectController")
@RequestMapping("/customer/activity/group/project/")
public class ProjectController {

	@Autowired
	private ProjectService projectService;

	@Autowired
	private ProjectApplyService projectApplyService;
	
	@Autowired
	private ProjectBoardService projectBoardService;

	@RequestMapping("{id}/index")
	public String index(@PathVariable("id") int id, HttpSession session, Model model) {

		ProjectView projectView = projectService.getView(id);
		List<ProjectApplyView> projectApplyViewList = projectApplyService.getViewByProjectId(id);
		List<ProjectApplyView> projectWaitingViewList = projectApplyService.getWaitingViewByProjectId(id);
		
		List<ProjectBoardView> projectBoardViewList = projectBoardService.getViewList(id);
		
		for(ProjectBoardView p : projectBoardViewList )
			System.out.println(p.getComment());
		model.addAttribute("pv", projectView);
		model.addAttribute("pav", projectApplyViewList);
		model.addAttribute("pwv",projectWaitingViewList);

		return "customer.activity.group.project.index";

	}

	@GetMapping("{id}/info")
	public String info(@PathVariable("id") int id, HttpSession session, Model model) {
		
		ProjectView projectView = projectService.getView(id);
		System.out.println(projectView.toString());
		
		model.addAttribute("p", projectView);

		return "customer.activity.group.project.info";
	}
	
	@PostMapping("{id}/approve")
	public String approve(String action, int id) {
		
		if(action.equals("승인")) {
			projectApplyService.updateStatusToApprove(id);
		} else if(action.equals("거절")) {
			projectApplyService.updateStatusToReject(id);
		}
		
		return "redirect:index";
	}

}
