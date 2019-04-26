package com.luobo.service.impl;

import com.luobo.entity.BigWork;
import com.luobo.repository.BaseRepository;
import com.luobo.repository.BigWorkRepository;
import com.luobo.service.BigWorkService;
import com.luobo.util.Page;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by ws
 * On 2/2/2017.2:40 PM
 */
@Service
public class BigWorkServiceImpl extends BaseServiceImpl<BigWork,Long> implements BigWorkService {

	@Autowired
	private BigWorkRepository repository;

	@Override
	public BaseRepository<BigWork, Long> getDao() {
		return repository;
	}

	@Override
	public Page<BigWork> findAllByTeacher(Long teacherId, Integer index, Integer pageSize){
		return repository.findAllByTeacher(teacherId, index, pageSize);
	}
}
