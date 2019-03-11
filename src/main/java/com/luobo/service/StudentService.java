package com.luobo.service;

import com.luobo.entity.Student;

public interface StudentService {
	public Student find(Long id);

	public Student findByNo(String no);
}
