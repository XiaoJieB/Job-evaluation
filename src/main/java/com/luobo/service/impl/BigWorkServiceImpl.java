package com.luobo.service.impl;

import com.luobo.entity.BigWork;
import com.luobo.repository.BigWorkRepository;
import com.luobo.service.BigWorkService;
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
}
