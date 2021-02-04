package com.ggiriggiri.web.controller.customer.activity.group.project;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("groupProjectBoardController")
@RequestMapping("/customer/activity/group/project/{id}/board/")
public class BoardController {

	@GetMapping("reg")
	public String reg() {
		return "customer.activity.group.project.board.reg";
	}
}
