package com.ggiriggiri.web.controller.api;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ggiriggiri.web.service.ProjectBoardService;

@RestController("apiProjectBoardController")
@RequestMapping("/api/projectBoardController/")
public class ProjectBoardController {

	@Autowired
	private ProjectBoardService service;
	
	@GetMapping("list")
	public Map<String,Object> list(){
		
		return null;
	}
}
