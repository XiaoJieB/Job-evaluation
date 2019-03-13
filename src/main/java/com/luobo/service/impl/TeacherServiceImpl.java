package com.luobo.service.impl;

import com.luobo.entity.Teacher;
import com.luobo.repository.TeacherRepository;
import com.luobo.service.TeacherService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * . Description: Date: 2019/3/11 17:29
 *
 * @author: ws
 * @version: 1.0
 */
@Service
public class TeacherServiceImpl implements TeacherService {

	@Autowired
	private TeacherRepository teacherRepository;

	@Transactional(readOnly = true)
	@Override
	public Teacher find(Long id) {
		return teacherRepository.get(id);
	}

	@Override
	public Teacher findByNo(String no){
		return teacherRepository.findByNo(no);
	}

	public List<Teacher> findAll() {
		return teacherRepository.findAll();
	}
}
