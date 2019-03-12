
package com.luobo.controller;

import com.luobo.entity.Student;
import com.luobo.service.StudentService;
import com.luobo.util.Constants;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController{

	@Autowired
	StudentService studentService;

	@RequestMapping("/login.action")
	@ResponseBody
	public Map<String,Object> login(HttpServletRequest request,Student student) {
		Map<String, Object> result = new HashMap<String, Object>();
		Student stu = studentService.findByNo(student.getNumber());
		if (stu == null) {
			result.put("msg", "该用户不存在或密码错误！");
			result.put("code", "201");
			return result;
		}
		if (stu.getPassword().equals(student.getPassword())) {
			setSessionStudent(request, student);
			result.put("msg", "参数不合法！");
			result.put("code", "0");
			return result;
		} else {
			result.put("msg", "该用户不存在或密码错误！");
			result.put("code", "201");
			return result;
		}
	}
	@RequestMapping("/logout.action")
	public String logout(HttpServletRequest request,HttpServletResponse response) {
		Student student=getSessionStudent(request);
		System.out.println(student.getNumber());
		System.err.println(student.getPassword());
		setSessionStudent(request, null);
		return "logout";
	}

	public void setSessionStudent(HttpServletRequest request,Student student) {
		request.getSession().setAttribute(Constants.STUDENT_CONTEXT, student);
	}
	public Student getSessionStudent(HttpServletRequest request) {
		return (Student) request.getSession().getAttribute(Constants.STUDENT_CONTEXT);
	}
}

