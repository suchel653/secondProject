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

import com.ggiriggiri.web.entity.StudyBoard;
import com.ggiriggiri.web.entity.StudyBoardView;
import com.ggiriggiri.web.service.StudyBoardService;

@RestController("apiStudyBoardController")
@RequestMapping("/api/studyBoardController/")
public class StudyBoardController {

	@Autowired
	private StudyBoardService service;
	
	@GetMapping("list")
	public Map<String,Object> list(@RequestParam(name = "studyId") int studyId) {
		
		List<StudyBoardView> list = service.getViewList(studyId);
		int count = list.size();
		Map<String,Object> dto = new HashMap<>();
		dto.put("list", list);
		//System.out.println(dto.get("list"));
		dto.put("count",count);
		
		return dto;
	}
	
	@PostMapping("reg")
	@ResponseBody
	public String reg(@RequestBody StudyBoard studyBoard) {
		int result = service.insert(studyBoard);
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
	public int edit(@RequestBody StudyBoard studyBoard) {
		
		
		int id = studyBoard.getId();
		String title = studyBoard.getTitle();
		String content = studyBoard.getContent();
		
		int cmtCnt = service.getView(id).getCmtCnt();
		StudyBoard origin = service.get(id);
		origin.setTitle(title);
		origin.setContent(content);
		
		int result = service.update(origin);
		
		return cmtCnt;
	}
	
	
}
