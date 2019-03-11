package com.luobo.service.impl;

import com.luobo.entity.Student;
import com.luobo.repository.StudentRepository;
import com.luobo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * . Description: Date: 2019/3/11 16:01
 *
 * @author: ws
 * @version: 1.0
 */
@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepository;

	@Transactional(readOnly = true)
	public Student find(Long id) {
		return studentRepository.get(id);
	}

	public Student findByNo(String no){
		return studentRepository.findByNo(no);
	}
}
