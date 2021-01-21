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
import com.ggiriggiri.web.entity.Skill;
import com.ggiriggiri.web.service.SkillService;

@Controller
@RequestMapping("/admin/category/")
public class SkillContoroller {

	@Autowired
	private SkillService service;

	@RequestMapping("skill")
	public String list(@RequestParam(name = "p", defaultValue = "1") int page, Model model) {

		int size = 10;
		List<Skill> list = service.getList(page, size);
		model.addAttribute("list", list);

		return "admin.category.skill";
	}

	@PostMapping("skill")
	public String actions(String action, int[] del, String[] newNames, int[] changedIds, String[] changedNames) {

		switch (action) {
		case "삭제":
			System.out.println(action);
			for (int i : del)
				System.out.println(i);
			service.deleteAll(del);
			break;
		case "저장":
			// 삽입
			if (newNames != null) {
				List<Skill> list = new ArrayList<>();
				for (int i = 0; i < newNames.length; i++) {
					Skill s = new Skill(i, newNames[i]);
					list.add(s);
				}
				service.insertList(list);
			}

			if (changedIds != null) {
				List<Skill> list = new ArrayList<>();
				for (int i = 0; i < changedIds.length; i++) {
					Skill s = service.get(changedIds[i]);
					s.setName(changedNames[i]);
					list.add(s);
				}
				service.updateList(list);
			}

			break;

		}

		return "redirect:skill";
	}

}
