package com.ggiriggiri.web.controller.customer.activity.group.project;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ggiriggiri.web.entity.ProjectBoard;
import com.ggiriggiri.web.service.ProjectBoardService;

@Controller("groupProjectBoardController")
@RequestMapping("/customer/activity/group/project/{id}/board/")
public class BoardController {

	@Autowired
	private ProjectBoardService service;
	
	@GetMapping("reg")
	public String reg(@PathVariable("id") int projectId, HttpSession session, Model model) {
	
		model.addAttribute("projectId",projectId);
		model.addAttribute("writerId",session.getAttribute("id"));
		return "customer.activity.group.project.board.reg";
	}
	
	@GetMapping("edit")
	public String edit(int id,Model model) {
	
		ProjectBoard projectBoard = service.get(id);
		
		model.addAttribute("pb",projectBoard);
		return "customer.activity.group.project.board.edit";
	}
}
