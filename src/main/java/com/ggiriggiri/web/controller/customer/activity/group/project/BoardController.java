package com.ggiriggiri.web.controller.customer.activity.group.project;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("groupProjectBoardController")
@RequestMapping("/customer/activity/group/project/{id}/board/")
public class BoardController {

	@GetMapping("reg")
	public String reg(@PathVariable("id") int projectId, HttpSession session, Model model) {
	
		model.addAttribute("projectId",projectId);
		model.addAttribute("writerId",session.getAttribute("id"));
		return "customer.activity.group.project.board.reg";
	}
}
