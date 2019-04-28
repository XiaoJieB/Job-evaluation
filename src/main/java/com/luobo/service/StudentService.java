package com.luobo.service;

import com.luobo.entity.Student;
import com.luobo.util.Page;
import java.util.List;

public interface StudentService extends BaseService<Student,Long> {
	public Student findByNo(String no);

	List<Student> findAllByTeacher(Long teacherId);

	Page<Student> findByPage(Integer index, Integer pageSize);
}
