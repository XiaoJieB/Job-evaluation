
package com.luobo.controller;

import com.luobo.entity.Student;
import com.luobo.service.StudentService;
import com.luobo.util.Constants;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController{

	@Autowired
	StudentService studentService;

	@RequestMapping("/login.action")
	public String login(HttpServletRequest request,Student student,Model model) {
		Student stu = studentService.findByNo(student.getNumber());
		if (stu != null && stu.getPassword().equals(student.getPassword())) {
			setSessionStudent(request, student);
			return "success";
		} else {
			return "login/login";
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

