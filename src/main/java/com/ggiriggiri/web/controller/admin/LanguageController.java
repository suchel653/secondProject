package com.ggiriggiri.web.controller.admin;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ggiriggiri.web.entity.Field;
import com.ggiriggiri.web.entity.Language;
import com.ggiriggiri.web.service.LanguageService;

@Controller
@RequestMapping("/admin/category/")
public class LanguageController {
	
	@Autowired
	private LanguageService service;
	
	@RequestMapping("language")
	public String list(@RequestParam(name="p", defaultValue = "1") int page, Model model) {
		
		int size = 10;
		List<Language> list = service.getList(page, size);
		model.addAttribute("list", list);
		
		return "admin.category.language";
	}
	
	@PostMapping("language")
	public String actions(String action, int[] del, String[] newNames, int[] changedIds, String[] changedNames) {

		switch (action) {
		case "삭제":
			service.deleteAll(del);
			break;
		case "저장":
			// 삽입
			if (newNames != null) {
				List<Language> list = new ArrayList<>();
				for (int i = 0; i < newNames.length; i++) {
					//밑의 생성자 수정할 것!(이미지)
					Language l = new Language(i, newNames[i]);
					list.add(l);
				}
				service.insertList(list);
			}
			// 변경사항 저장
			if (changedIds != null) {
				List<Language> list = new ArrayList<>();
				for (int i = 0; i < changedIds.length; i++) {
					Language l = service.get(changedIds[i]);
					l.setName(changedNames[i]);
					list.add(l);
				}
				service.updateList(list);
			}
			
			break;
			
		}

		return "redirect:language";
	}

}
