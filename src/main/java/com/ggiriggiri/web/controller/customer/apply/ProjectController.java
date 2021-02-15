package com.ggiriggiri.web.controller.customer.apply;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ggiriggiri.web.entity.Member;
import com.ggiriggiri.web.entity.ProjectApply;
import com.ggiriggiri.web.entity.ProjectView;
import com.ggiriggiri.web.service.MemberService;
import com.ggiriggiri.web.service.ProjectApplyService;
import com.ggiriggiri.web.service.ProjectService;

@Controller("ProjectApplyController")
@RequestMapping("/customer/project/apply/")
public class ProjectController {

	@Autowired
	private ProjectService service;
	@Autowired
	private ProjectApplyService paService;
	@Autowired
	private MemberService mService;
	
	
	@GetMapping("{id}")
	public String detail(@PathVariable("id") int id, Model model) {
		model.addAttribute("id",id);
		return "customer.project.popup.apply";
	}
	
	
	@PostMapping("{id}")
	public String detail(
			@PathVariable("id") int id,
			@RequestParam("comment") String comment,
			Authentication authentication) {
		
		int projectId = id;
		ProjectView pv = service.getView(projectId);
		
		
		//---login 유저
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		String username = userDetails.getUsername();
		
		Member m = mService.get(username);
		int memberId = m.getId();

		List<ProjectApply> pas = paService.get(memberId);
		
		
		//------ 중복 확인, insert
		int paId = 0;
		for(ProjectApply pa : pas) {
			if(pa.getProjectId() == projectId) 
				 paId = pa.getProjectId();
		}
		
		if(pv.getMemberCount() < pv.getLimitNumber() && paId!=projectId) {
			
		ProjectApply projectApply = new ProjectApply(memberId,projectId,comment);
		service.insertProjectApply(projectApply);
			
		}		
		
		return "customer.project.popup.apply";
		
	}
	
	@PostMapping("check/{id}")
	@ResponseBody
	public Map<String, Object> check(@PathVariable("id") int id,
			Authentication authentication) {
		
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		String username = userDetails.getUsername();
		
		Member m = mService.get(username);
		int memberId = m.getId();
		
	      Map<String, Object> map = new HashMap<>();
	      int checkResult = service.check(memberId, id);
	      map.put("checkResult", checkResult);
	      
	      return map;
	}

}


