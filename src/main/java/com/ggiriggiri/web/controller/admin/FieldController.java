package com.ggiriggiri.web.controller.admin;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ggiriggiri.web.entity.Field;
import com.ggiriggiri.web.service.FieldService;

@Controller
@RequestMapping("/admin/category/")
public class FieldController {

	@Autowired
	private FieldService service;

	@GetMapping("field")
	public String list(@RequestParam(name = "p", defaultValue = "1") int page, Model model) {

		int size = 10;
		List<Field> list = service.getList(page, size);
		model.addAttribute("list", list);

		return "admin.category.field";

	}

	@PostMapping("field")
	public String actions(String action, int[] del, String[] newNames, int[] changedIds, String[] changedNames) {

		switch (action) {
		case "삭제":
			service.deleteAll(del);
			break;
		case "저장":
			// 삽입
			if (newNames != null) {
				List<Field> list = new ArrayList<>();
				for (int i = 0; i < newNames.length; i++) {
					Field f = new Field(i, newNames[i]);
					list.add(f);
				}
				service.insertList(list);
			}
			// 변경사항 저장
			if (changedIds != null) {
				List<Field> list = new ArrayList<>();
				for (int i = 0; i < changedIds.length; i++) {
					Field f = service.get(changedIds[i]);
					f.setName(changedNames[i]);
					list.add(f);
				}
				service.updateList(list);
			}
			
			break;
			
		}

		return "redirect:field";
	}
}
