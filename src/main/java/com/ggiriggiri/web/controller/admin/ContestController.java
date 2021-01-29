package com.ggiriggiri.web.controller.admin;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.ggiriggiri.web.entity.Contest;
import com.ggiriggiri.web.entity.ContestFile;
import com.ggiriggiri.web.entity.ContestImage;
import com.ggiriggiri.web.service.ContestService;

@Controller("adminContestController")
@RequestMapping("/admin/contest/")
public class ContestController {
	
	@Autowired
	private ContestService service;
	
	@RequestMapping("list")
	public String list(
			@RequestParam(name = "p", defaultValue = "1") int page,
			@RequestParam(name = "f", defaultValue = "title") String field,
			@RequestParam(name = "q", defaultValue = "") String query,
			Model model) {
		
		int size = 10;
		
		List<Contest> list = service.getList(page, size, field, query);
		
		int count = service.getCount(field, query);
		
		int pageCount = (int) Math.ceil(count / (float)size);
		
		model.addAttribute("list",list);
		model.addAttribute("pageCount",pageCount);
		
		return "admin.contest.list";
	}
	
	@GetMapping("reg")
	public String reg() {
		
		return "admin.contest.reg";
	}
	
	@PostMapping("reg")
	public String reg(
			@RequestParam("startDate") String oldStartDate,
			@RequestParam("endDate") String oldEndDate,
			@RequestParam("title") String title,
			@RequestParam("content") String content,
			MultipartHttpServletRequest mtfRequest
			) throws ParseException, IllegalStateException, IOException{
	
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		Date startDate = sdf.parse(oldStartDate);
		Date endDate = sdf.parse(oldEndDate);
		
		int newId = service.getLastId()+1;
		
		Contest contest = new Contest(newId,"aaa",title,content,startDate,endDate);
		service.insert(contest);
		
		List<MultipartFile> fileList = mtfRequest.getFiles("files");
		List<MultipartFile> imgList = mtfRequest.getFiles("imgs");
		
		String url = "/images/";
	
//		System.out.println(fileList.get(0).getOriginalFilename());
//		System.out.println("img"+imgList.get(0).getOriginalFilename());
		
		if(!fileList.get(0).getOriginalFilename().equals("")) {
			String realPath = mtfRequest.getServletContext().getRealPath(url);
			
			String filePath = realPath + "contestFile/"+newId;
			File realPathFile = new File(filePath);
			if (!realPathFile.exists())
				realPathFile.mkdir();
	
			for(MultipartFile mf : fileList) {
				String file = filePath + File.separator + mf.getOriginalFilename();
				mf.transferTo(new File(file));
	
				ContestFile contestFile = new ContestFile(newId,mf.getOriginalFilename());
				service.insertFile(contestFile);
			}
		}
		
		if(!imgList.get(0).getOriginalFilename().equals("")) {
			String realPath = mtfRequest.getServletContext().getRealPath(url);
			
			String imgPath = realPath + "contestImg/"+newId;
			File realPathImgFile = new File(imgPath);
			if (!realPathImgFile.exists())
				realPathImgFile.mkdir();
			
			for(MultipartFile mf : imgList) {
				String file = imgPath + File.separator + mf.getOriginalFilename();
				mf.transferTo(new File(file));
				
				ContestImage contestImg = new ContestImage(newId,mf.getOriginalFilename());
				service.insertImg(contestImg);
			}
		}
		
		return "redirect:list";
	}

	@GetMapping("{id}")
	public String detail(Model model,@PathVariable("id") Integer id) {
		
		Contest c = service.get(id);
		Contest prev = service.getPrev(id);
		Contest next = service.getNext(id);
		
		model.addAttribute("c",c);
		model.addAttribute("prev", prev);
		model.addAttribute("next", next);
		
		return "admin.contest.detail";
	}

	@GetMapping("{id}/edit")
	public String edit(Model model,@PathVariable("id") int id) {
		
		Contest c = service.get(id);
		model.addAttribute("c",c);
		
		return "admin.contest.edit";
	}
	
	@PostMapping("{id}/edit")
	public String edit(
			@PathVariable("id") int id,
			@RequestParam("startDate") String oldStartDate,
			@RequestParam("endDate") String oldEndDate,
			@RequestParam("title") String title,
			@RequestParam("content") String content) throws ParseException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		Date startDate = sdf.parse(oldStartDate);
		Date endDate = sdf.parse(oldEndDate);
		
		Contest contest = new Contest(id,"aaa",title,content,startDate,endDate);
		
		service.update(contest);
		
		return "redirect:../"+id;
	}
	
	@GetMapping("{id}/del")
	public String del(@PathVariable("id") int id) {
		
		service.delete(id);
		
		return "redirect:../list";
	}
	
	
}
