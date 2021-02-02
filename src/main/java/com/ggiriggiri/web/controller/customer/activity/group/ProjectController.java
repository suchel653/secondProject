package com.ggiriggiri.web.controller.customer.activity.group;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ggiriggiri.web.entity.ProjectApplyView;
import com.ggiriggiri.web.entity.ProjectView;
import com.ggiriggiri.web.service.ProjectApplyService;
import com.ggiriggiri.web.service.ProjectService;

@Controller("groupProjectController")
@RequestMapping("/customer/activity/group/project/{id}/")
public class ProjectController {

	@Autowired
	ProjectService projectService;

	@Autowired
	ProjectApplyService projectApplyService;

	@RequestMapping("index")
	public String index(@PathVariable("id") int id, HttpSession session, Model model) {

		ProjectView projectView = projectService.getView(id);
		List<ProjectApplyView> projectApplyViewList = projectApplyService.getViewByProjectId(id);
		
		model.addAttribute("pv", projectView);
		model.addAttribute("pav", projectApplyViewList);

		return "customer.activity.group.project." + id + ".index";

	}

	@GetMapping("info")
	public String info(@PathVariable("id") int id, HttpSession session, Model model) {
		
		ProjectView projectView = projectService.getView(id);
		
		model.addAttribute("p", projectView);

		return "customer.activity.group.project." + id + ".info";
	}

}
