package com.ggiriggiri.web.controller.api;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ggiriggiri.web.entity.ProjectBoard;
import com.ggiriggiri.web.entity.ProjectBoardView;
import com.ggiriggiri.web.service.ProjectBoardService;

@RestController("apiProjectBoardController")
@RequestMapping("/api/projectBoardController/")
public class ProjectBoardController {

	@Autowired
	private ProjectBoardService service;
	
	@GetMapping("list")
	public Map<String,Object> list(@RequestParam(name = "projectId") int projectId) {
		
		List<ProjectBoardView> list = service.getViewList(projectId);
		int count = list.size();
		Map<String,Object> dto = new HashMap<>();
		dto.put("list", list);
		//System.out.println(dto.get("list"));
		dto.put("count",count);
		
		return dto;
	}
	
	@PostMapping("reg")
	@ResponseBody
	public String reg(@RequestBody ProjectBoard projectBoard) {
		int result = service.insert(projectBoard);
		return "ok";
	}
	
	@GetMapping("delete")
	@ResponseBody
	public String delete(@RequestParam(name = "id") int id) {
		
		int result = service.delete(id);
		return "ok";
	}
	
	@PostMapping("edit")
	@ResponseBody
	public int edit(@RequestBody ProjectBoard projectBoard) {
		
		
		int id = projectBoard.getId();
		String title = projectBoard.getTitle();
		String content = projectBoard.getContent();
		
		int cmtCnt = service.getView(id).getCmtCnt();
		ProjectBoard origin = service.get(id);
		origin.setTitle(title);
		origin.setContent(content);
		
		int result = service.update(origin);
		
		return cmtCnt;
	}
	
	
}
