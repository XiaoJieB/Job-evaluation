package com.luobo.controller;

import com.luobo.entity.BigWork;
import com.luobo.entity.Student;
import com.luobo.repository.StudentRepository;
import com.luobo.service.BigWorkService;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
	@ResponseBody
	public Map<String,Object> addJobLink(BigWork bigWork) {
		Map<String, Object> result = new HashMap<String, Object>();
		bigWorkService.save(bigWork);
		Student student = studentRepository.get(bigWork.getStudentId());
		student.setBigWork(bigWork);
		result.put("msg", "大作业上传成功！");
		result.put("code", "0");
		return result;
	}
}
