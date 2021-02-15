package com.ggiriggiri.web.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ggiriggiri.web.service.ProjectService;

@RestController("apiProjectController")
@RequestMapping("/api/projectController/")
public class ProjectController {
	@Autowired
	private ProjectService service;


	@GetMapping("updateStatus")
	@ResponseBody
	public String updateStatus(@RequestParam(name="id") int id,
			@RequestParam(name="statusId") int statusId) {
		
		int result = service.updateStatus(id,statusId);
		return "ok";
	}

}
