package com.ggiriggiri.web.controller.customer.activity.group.study;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ggiriggiri.web.entity.StudyBoard;
import com.ggiriggiri.web.service.StudyBoardService;

@Controller("groupStudyBoardController")
@RequestMapping("/customer/activity/group/study/{id}/board/")
public class BoardController {

	@Autowired
	private StudyBoardService service;
	
	@GetMapping("reg")
	public String reg(@PathVariable("id") int studyId, HttpSession session, Model model) {
	
		model.addAttribute("studyId",studyId);
		model.addAttribute("writerId",session.getAttribute("id"));
		return "customer.activity.group.study.board.reg";
	}
	
	@GetMapping("edit")
	public String edit(int id,Model model) {
	
		StudyBoard studyBoard = service.get(id);
		
		model.addAttribute("sb",studyBoard);
		return "customer.activity.group.study.board.edit";
	}
}
