package com.luobo.service;

import com.luobo.entity.Teacher;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;

public interface TeacherService {

	@Transactional(readOnly = true)
	Teacher find(Long id);

	Teacher findByNo(String no);

	public List<Teacher> findAll();
}
