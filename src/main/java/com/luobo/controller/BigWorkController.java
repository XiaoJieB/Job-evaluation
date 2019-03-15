package com.luobo.controller;

import com.luobo.entity.BigWork;
import com.luobo.entity.Student;
import com.luobo.repository.StudentRepository;
import com.luobo.service.BigWorkService;
import com.luobo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * . Description: Date: 2019/3/15 11:24
 *
 * @author: ws
 * @version: 1.0
 */
@RequestMapping("bigWork")
@Controller
public class BigWorkController {

	@Autowired
	BigWorkService bigWorkService;

	@Autowired
	StudentRepository studentRepository;

	@RequestMapping("/save")
	public String addJobLink(BigWork bigWork) {
		bigWorkService.save(bigWork);
		Student student = studentRepository.get(bigWork.getStudentId());
		student.setBigWork(bigWork);
		return "student/index";
	}
}
