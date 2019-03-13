package com.luobo.controller;

import com.luobo.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * . Description: Date: 2019/3/12 11:27
 *
 * @author: ws
 * @version: 1.0
 */
@Controller
public class TeacherController {

	@Autowired
	TeacherService teacherService;

	@RequestMapping("teacher/list")
	public String list(ModelMap map) {
		map.addAttribute("teacherList",teacherService.findAll());
		return "teacher/index";
	}
}
