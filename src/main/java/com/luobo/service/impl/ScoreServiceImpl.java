package com.luobo.service.impl;

import com.luobo.entity.Score;
import com.luobo.repository.ScoreRepository;
import com.luobo.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * . Description: Date: 2019/3/22 11:50
 *
 * @author: ws
 * @version: 1.0
 */
@Service
public class ScoreServiceImpl implements ScoreService {

	@Autowired
	private ScoreRepository scoreRepository;

	@Override
	public Long save(Score score) {
		return scoreRepository.save(score);
	}
}
