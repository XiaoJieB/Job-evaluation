package com.luobo.service.impl;

import com.luobo.entity.BigWork;
import com.luobo.repository.BigWorkRepository;
import com.luobo.service.BigWorkService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by ws
 * On 2/2/2017.2:40 PM
 */
@Service
public class BigWorkServiceImpl implements BigWorkService {

	@Autowired
	private BigWorkRepository bigWorkRepository;

	public Long save(BigWork bigWork) {
		return bigWorkRepository.save(bigWork);
	}

	@Override
	public List<BigWork> findAllByTeacher(Long teacherId){
		return bigWorkRepository.findAllByTeacher(teacherId);
	}

	@Override
	public void delete(Long workId) {
		bigWorkRepository.delete(workId);
	}

	public BigWork get(Long workId) {
		return bigWorkRepository.get(workId);
	}

	public BigWork load(Long workId) {
		return bigWorkRepository.load(workId);
	}

	@Override
	public void update(BigWork bigWork) {
		bigWorkRepository.update(bigWork);
	}

	@Override
	public List<BigWork> findAll() {
		return bigWorkRepository.findAll();
	}

	@Override
	public void updateWorkBindStudent (Long stuId, Long workId) {
		bigWorkRepository.updateWorkBindStudent(stuId,workId);
	}
}
