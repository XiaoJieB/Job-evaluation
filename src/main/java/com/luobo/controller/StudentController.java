package com.luobo.controller;

import com.luobo.service.StudentService;
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
public class StudentController {

	@Autowired
	StudentService studentService;

	@RequestMapping("student/list")
	public String list(ModelMap map) {
		map.addAttribute("studentList",studentService.findAll());
		return "student/index";
	}
}
