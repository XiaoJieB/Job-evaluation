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

	@RequestMapping("/findAllByTeacher")
	public String findAllByTeacher(ModelMap map, HttpServletRequest request) {
		Teacher teacher = (Teacher) request.getSession().getAttribute(Constants.TEACHER_CONTEXT);
		map.addAttribute("workList",bigWorkService.findAllByTeacher(teacher.getId()));
		return "teacher/BigWorkList";
	}

	@RequestMapping("/save")
	@ResponseBody
	public Map<String,Object> addBigWork(BigWork bigWork, HttpServletRequest request) {
		Map<String, Object> result = new HashMap<String, Object>();
		Teacher teacher = (Teacher) request.getSession().getAttribute(Constants.TEACHER_CONTEXT);
		bigWork.setTeacher(teacher);
		bigWorkService.save(bigWork);
		result.put("msg", "大作业新增成功！");
		result.put("code", "0");
		return result;
	}

	@RequestMapping("/delete")
	@ResponseBody
	public Map<String,Object> deleteBigWork(Long workId) {
		Map<String, Object> result = new HashMap<String, Object>();
		bigWorkService.delete(workId);
		result.put("msg", "大作业删除成功！");
		result.put("code", "0");
		return result;
	}

	@RequestMapping("/view")
	@ResponseBody
	public Map<String,Object> view(Long workId) {
		Map<String, Object> result = new HashMap<String, Object>();
		BigWork bigWork = bigWorkService.get(workId);
		if (bigWork != null) {
			result.put("id", bigWork.getId());
			result.put("name", bigWork.getName());
			result.put("remark", bigWork.getRemark());
			result.put("code", "0");
		} else {
			result.put("msg", "作业不存在");
			result.put("code", "201");
		}
		return result;
	}

	@RequestMapping("/update")
	@ResponseBody
	public Map<String,Object> update(BigWork bigWork) {
		Map<String, Object> result = new HashMap<String, Object>();
		bigWorkService.update(bigWork);
		result.put("msg", "大作业更新成功！");
		result.put("code", "0");
		return result;
	}
}
