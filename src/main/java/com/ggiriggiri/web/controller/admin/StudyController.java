package com.ggiriggiri.web.controller.admin;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ggiriggiri.web.entity.Field;
import com.ggiriggiri.web.entity.Language;
import com.ggiriggiri.web.entity.Skill;
import com.ggiriggiri.web.entity.StudyView;
import com.ggiriggiri.web.service.FieldService;
import com.ggiriggiri.web.service.LanguageService;
import com.ggiriggiri.web.service.SkillService;
import com.ggiriggiri.web.service.StudyService;


@Controller
@RequestMapping("/admin/study/")
public class StudyController {
	@Autowired
	private StudyService service;
	
	@Autowired
	private FieldService fdService;
	
	@Autowired
	private SkillService skService;
	
	@Autowired
	private LanguageService lgService;
	
	@RequestMapping("list")
	public String list(@RequestParam(name="p", defaultValue = "1") int page,
			@RequestParam(name="f", defaultValue = "") String[] field,
			@RequestParam(name="s", defaultValue = "") String[] skill,
			@RequestParam(name="l", defaultValue = "") String[] language,
			@RequestParam(name="t", defaultValue="title") String title, 
			@RequestParam(name="q", defaultValue = "") String query,
			@RequestParam(name="size", defaultValue="10") int size,
			Model model) {
	
		List<StudyView> list =service.getViewList(page,size,title,query,field,skill,language);
	
		int count = service.getCount(title,query,field,skill,language);
		int pageCount = (int) Math.ceil(count/(float)size);
		if(pageCount == 0)
			pageCount=1;
		List<Field> fdList = fdService.getList();
		List<Skill> skList = skService.getList(1, 100);
		List<Language> lgList = lgService.getList(1, 100);
		
		model.addAttribute("f", fdList);
		model.addAttribute("s", skList);
		model.addAttribute("l", lgList);
		model.addAttribute("pageCount", pageCount);
		
		model.addAttribute("list",list);
		return "admin.study.list";
				
	}
	


	

}
