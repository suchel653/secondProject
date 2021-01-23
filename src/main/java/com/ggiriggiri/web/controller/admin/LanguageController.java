package com.ggiriggiri.web.controller.admin;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.ggiriggiri.web.entity.Language;
import com.ggiriggiri.web.service.LanguageService;
	
@Controller
@RequestMapping("/admin/category/")
public class LanguageController {
	
	@Autowired
	private LanguageService service;
	
	@GetMapping("language")
	public String list(@RequestParam(name="p", defaultValue = "1") int page, Model model) {
		
		int size = 10;
		List<Language> list = service.getList(page, size);
		model.addAttribute("list", list);
		
		return "admin.category.language";
	}
	
	@PostMapping("language")
	public String actions(String action, int[] del, String[] newNames, int[] changedIds
			, String[] changedNames, MultipartFile file, HttpServletRequest request) throws IllegalStateException, IOException {
		
		switch (action) {
		case "삭제":
			service.deleteAll(del);
			break;
		case "저장":
			// 삽입
			if (newNames != null) {
				
				List<Language> list = new ArrayList<>();
				
				for (int i = 0; i < newNames.length; i++) {
					
					//파일 저장시
					String realPath = "C:/Work/Workspace2/secondProject/src/main/resources/static/images/language";
					
					File realPathFile = new File(realPath);
					if(!realPathFile.exists())
						realPathFile.mkdir();
					
					String uploadedFilePath = realPath + File.separator + file.getOriginalFilename();
					File uploadedFile = new File(uploadedFilePath);
					
					file.transferTo(uploadedFile);					
					
					Language l = new Language(i, newNames[i], file.getOriginalFilename());
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
