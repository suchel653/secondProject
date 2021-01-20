/*
 * package com.ggiriggiri.web.controller.api;
 * 
 * import java.util.List;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.web.bind.annotation.RequestMapping; import
 * org.springframework.web.bind.annotation.RequestParam; import
 * org.springframework.web.bind.annotation.RestController;
 * 
 * import com.ggiriggiri.web.entity.Project; import
 * com.ggiriggiri.web.service.ProjectService;
 * 
 * 
 * @RestController
 * 
 * @RequestMapping("/api/project/") public class ProjectController {
 * 
 * @Autowired private ProjectService service;
 * 
 * @RequestMapping("list") public List<Project> list(@RequestParam(name="p",
 * defaultValue = "1") int page,
 * 
 * @RequestParam(name="f", defaultValue = "title") String field,
 * 
 * @RequestParam(name="q", defaultValue = "") String query) {
 * 
 * int size = 10; List<Project> list = service.getList(page, size, field,
 * query);
 * 
 * return list; } }
 */