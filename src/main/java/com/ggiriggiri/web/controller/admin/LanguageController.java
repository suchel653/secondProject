package com.ggiriggiri.web.controller.admin;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

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
	public String list(@RequestParam(name = "p", defaultValue = "1") int page, Model model) {

		int size = 10;
		List<Language> list = service.getList(page, size);
		model.addAttribute("list", list);

		int count = service.getCount();
		int pageCount = (int) Math.ceil(count / (float) size);

		model.addAttribute("page", page);
		model.addAttribute("pageCount", pageCount);

		return "admin.category.language";

	}

	@PostMapping("language")
	public String actions(String action, int[] del, String[] newNames, int[] changedIds, String[] changedNames,
			MultipartFile[] file, int[] changedFileIds, MultipartFile[] changedFile, HttpServletRequest request)
			throws IllegalStateException, IOException {

		switch (action) {
		case "삭제":
			service.deleteAll(del);
			break;
		case "저장":
			// 새로운 레코드 저장시
			if (newNames != null) {

				List<Language> list = new ArrayList<>();

				for (int i = 0; i < newNames.length; i++) {

					String url = "/images/language";
					String realPath = request.getServletContext().getRealPath(url);

					File realPathFile = new File(realPath);
					if (!realPathFile.exists())
						realPathFile.mkdir();

					String uploadedFilePath = realPath + File.separator + file[i].getOriginalFilename();
					File uploadedFile = new File(uploadedFilePath);

					file[i].transferTo(uploadedFile);

					Language l = new Language(i, newNames[i], file[i].getOriginalFilename());

					list.add(l);

				}

				service.insertList(list);

			}

			// 이름 변경시
			if (changedNames != null) {
				List<Language> list = new ArrayList<>();

				for (int i = 0; i < changedNames.length; i++) {
					Language l = service.get(changedIds[i]);
					l.setName(changedNames[i]);
					list.add(l);
				}

				service.updateList(list);

			}

			// 이미지 변경시
			if (changedFile != null) {
				System.out.println("이미지 변경");
				List<Language> list = new ArrayList<>();

				for (int i = 0; i < changedFile.length; i++) {

					String url = "/images/language";
					String realPath = request.getServletContext().getRealPath(url);

					File realPathFile = new File(realPath);
					if (!realPathFile.exists())
						realPathFile.mkdir();

					String uploadedFilePath = realPath + File.separator + changedFile[i].getOriginalFilename();
					File uploadedFile = new File(uploadedFilePath);

					changedFile[i].transferTo(uploadedFile);

					Language l = service.get(changedFileIds[i]);
					System.out.println(l);
					l.setImage(changedFile[i].getOriginalFilename());
					System.out.println(l);

					list.add(l);

				}

				service.updateList(list);

			}

			break;

		}

		return "redirect:language";

	}

}
