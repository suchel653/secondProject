package com.ggiriggiri.web.controller.customer;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.ggiriggiri.web.entity.Field;
import com.ggiriggiri.web.entity.Language;
import com.ggiriggiri.web.entity.Skill;
import com.ggiriggiri.web.entity.Study;
import com.ggiriggiri.web.entity.StudyApply;
import com.ggiriggiri.web.entity.StudyFile;
import com.ggiriggiri.web.entity.StudyLanguage;
import com.ggiriggiri.web.entity.StudySkill;
import com.ggiriggiri.web.entity.StudyView;
import com.ggiriggiri.web.service.FieldService;
import com.ggiriggiri.web.service.LanguageService;
import com.ggiriggiri.web.service.SkillService;
import com.ggiriggiri.web.service.StudyService;

@Controller
@RequestMapping("/customer/study/")
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
		
		List<StudyView> list=service.getViewList(page, size, title, query, field, skill, language);
		
		int count = service.getCount(title, query, field, skill, language);
		int pageCount=(int)Math.ceil(count/(float)size);
		if(pageCount == 0)
			pageCount=1;
		List<Field> fdList = fdService.getList();
		List<Skill> skList = skService.getList(1, 100);
		List<Language> lgList = lgService.getList(1, 100);
		
		model.addAttribute("f",fdList);
		model.addAttribute("s", skList);
		model.addAttribute("l", lgList);
		model.addAttribute("pageCount", pageCount);
		
		model.addAttribute("list",list);
		return "customer.study.list";
		
	}

	@RequestMapping("{id}")
	public String detail(Model model,@PathVariable("id")Integer id) {
	    StudyView study = service.getView(id);
	    StudyView prev = service.getPrev(id);
	    StudyView next = service.getNext(id);
		
		model.addAttribute("prev",prev);
		model.addAttribute("next",next);
		model.addAttribute("s",study);
		
		return "customer.study.detail";
		
	}
	
	@GetMapping("apply/{id}")
	public String apply(Model model,@PathVariable("id")Integer id) {
		model.addAttribute("id",id);
		return "customer.study.popup.apply";
		
	}
	
	@PostMapping("apply/{id}")
	public String apply(

			@PathVariable("id") int id,
			@RequestParam("comment") String comment
			) {
		StudyApply studyApply = new StudyApply(2,id,comment);
		service.insertStudyApply(studyApply);


		return "customer.study.popup.apply";
		
	}
	
	@PostMapping("apply/check")
	@ResponseBody
	public Map<String, Object> check(int id) {
		
			System.out.println(id);
	      Map<String, Object> map = new HashMap<>();
	      int checkResult = service.check(2, id);
	      map.put("checkResult", checkResult);
	      System.out.println("check 결과"+checkResult);
	      return map;
	}

	@GetMapping("reg")
	public String reg(Model model,
			@RequestParam(name="field", defaultValue = "") String[] field,
			@RequestParam(name="skill", defaultValue = "") String[] skill,
			@RequestParam(name="language", defaultValue = "") String[] language) {
		
		List<Field> fdList = fdService.getList(1, 100);
		List<Skill> skList = skService.getList(1, 100);
		List<Language> lgList = lgService.getList(1, 100);
		
		model.addAttribute("f", fdList);
		model.addAttribute("s", skList);
		model.addAttribute("l", lgList);
		
		return "customer.study.reg";
		
	}
	
	@PostMapping("reg")
	public String reg(@RequestParam("limitNumber") int limitNumber,
			@RequestParam("startDate") String oldStartDate,
			@RequestParam("endDate") String oldEndDate,
			@RequestParam("title") String title,
			@RequestParam("content") String content,
			@RequestParam("requirement") String requirement,
			@RequestParam("field") int fieldId,
			@RequestParam("skill") int[] skill,
			@RequestParam("language") int[] language,
			MultipartHttpServletRequest mtfRequest) throws ParseException, IllegalStateException, IOException {

		
		System.out.println(fieldId);
		for(int s : skill)
		System.out.println(s);
		for(int l : language)
			System.out.println(l);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		Date startDate = sdf.parse(oldStartDate);
		Date endDate = sdf.parse(oldEndDate);
		
		int newId = service.getLastId()+1;
		
		MultipartFile img = mtfRequest.getFile("image");
		List<MultipartFile> fileList = mtfRequest.getFiles("files");

		String url = "/images/";
		String realPath = mtfRequest.getServletContext().getRealPath(url);
		
		String filePath = realPath + "studyFile/";
		String imgPath = realPath + "studyImg/";
		
		File realPathFile = new File(filePath);
		File realPathImgFile = new File(imgPath);
		
		if (!realPathFile.exists())
			realPathFile.mkdir();
		
		if (!realPathImgFile.exists())
			realPathImgFile.mkdir();
		
		String imgFile = imgPath + File.separator + img.getOriginalFilename();
		img.transferTo(new File(imgFile));
		String image = img.getOriginalFilename();
		
		System.out.println(image);
		
		int leaderId = 16;
		
		Study study = new Study(newId,title,content,startDate,endDate,limitNumber,image,requirement,fieldId,leaderId);
		
		service.insert(study);
		
		
		
		for(MultipartFile mf : fileList) {
			String file = filePath + File.separator + mf.getOriginalFilename();
			mf.transferTo(new File(file));

			
			StudyFile studyFile = new StudyFile(newId,mf.getOriginalFilename());
			service.insertFile(studyFile);
		}
		
		for(int skillId : skill) {
			StudySkill sk = new StudySkill(newId,skillId);
			service.insertSkill(sk);
		}
		
		for(int languageId : language) {
			StudyLanguage sl = new StudyLanguage(newId,languageId);
			service.insertLanguage(sl);
		}
			
		
		return "redirect:list";
	}
	
	@PostMapping("check")
	@ResponseBody
	public Map<String, Object> checkDublicate(@RequestParam("comment") String comment,
				@RequestParam("id") int id) {
		Map<String, Object> map = new HashMap<>();
		int checkResult = service.check(5, id);
		map.put("checkResult", checkResult);
		StudyApply studyApply = new StudyApply(5,id,comment);
		service.insertStudyApply(studyApply);
		
		
		return map;
	}

	
}
