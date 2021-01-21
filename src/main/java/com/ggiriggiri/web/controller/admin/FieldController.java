package com.ggiriggiri.web.controller.admin;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ggiriggiri.web.entity.Field;
import com.ggiriggiri.web.service.FieldService;

@Controller
@RequestMapping("/admin/category/field")
public class FieldController {

	@Autowired
	private FieldService service;
	
	@GetMapping("")
	public String list(@RequestParam(name="p", defaultValue="1") int page, Model model) {
		
		int size = 10;
		List<Field> list = service.getList(page, size);
		model.addAttribute("list", list);
		
		return "admin.category.field";
		
	}
	
	@PostMapping("")
	public String list(@RequestParam(name="new-name") String[] a, Principal principal) {
		for(String aa : a)
			System.out.println(aa);
		return "redirect:field";
	}
}
