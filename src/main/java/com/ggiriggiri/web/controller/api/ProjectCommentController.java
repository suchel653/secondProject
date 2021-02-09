package com.ggiriggiri.web.controller.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ggiriggiri.web.entity.ProjectComment;
import com.ggiriggiri.web.entity.ProjectCommentView;
import com.ggiriggiri.web.service.ProjectCommentService;

@RestController("apiProjectCommentController")
@RequestMapping("/api/projectCommentController/")
public class ProjectCommentController {

	@Autowired
	private ProjectCommentService service;

	@GetMapping("list")
	public List<ProjectCommentView> list(@RequestParam(name = "boardId") int boardId) {

		
		List<ProjectCommentView> list = service.getViewList(boardId);
		
		return list;
	}

	@PostMapping("reg")
	@ResponseBody
	public String reg(@RequestBody ProjectComment projectComment) {

		int result = service.insert(projectComment);

		return "ok";
	}
	
	@GetMapping("cnt")
	public String cnt(@RequestParam(name = "boardId") int boardId) {

		
		List<ProjectCommentView> list = service.getViewList(boardId);
		
		return String.valueOf(list.size());
	}
	
	@GetMapping("delete")
	@ResponseBody
	public String delete(@RequestParam(name = "id") int id) {
		
		int result = service.delete(id);
		return "ok";
	}

}
