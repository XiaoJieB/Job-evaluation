package com.luobo.controller;

import com.luobo.entity.BigWork;
import com.luobo.entity.Student;
import com.luobo.entity.Teacher;
import com.luobo.service.BigWorkService;
import com.luobo.service.StudentService;
import com.luobo.util.Constants;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
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
	StudentService studentService;

	@RequestMapping("/save")
	@ResponseBody
	public Map<String,Object> addJobLink(BigWork bigWork) {
		Map<String, Object> result = new HashMap<String, Object>();
		bigWorkService.save(bigWork);
		Student student = studentService.find(bigWork.getStudentId());
		student.setBigWork(bigWork);
		result.put("msg", "大作业上传成功！");
		result.put("code", "0");
		return result;
	}

	@RequestMapping("/findAllByTeacher")
	public String findAllByTeacher(ModelMap map, Long teacherId) {
		map.addAttribute("workList",bigWorkService.findAllByTeacher(teacherId));
		return "teacher/BigWorkList";
	}

	@RequestMapping("/addBigWork")
	public String addBigWork(ModelMap map,BigWork bigWork, HttpServletRequest request) {
		Teacher teacher = (Teacher) request.getSession().getAttribute(Constants.TEACHER_CONTEXT);
		bigWork.setTeacher(teacher);
		bigWorkService.save(bigWork);
		map.addAttribute("workList",bigWorkService.findAllByTeacher(teacher.getId()));
		return "teacher/BigWorkList";
	}
}
