package com.luobo.service;

import com.luobo.entity.Student;
import java.util.List;

public interface StudentService {
	public Student find(Long id);
	public List<Student> findAll();
	public Student findByNo(String no);

	void update(Student student);
}
