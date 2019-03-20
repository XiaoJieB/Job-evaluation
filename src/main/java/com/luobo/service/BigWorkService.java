package com.luobo.service;

import com.luobo.entity.BigWork;
import java.util.List;

public interface BigWorkService {
	Long save(BigWork bigWork);

	List<BigWork> findAllByTeacher(Long teacherId);

	void delete(Long workId);
}
