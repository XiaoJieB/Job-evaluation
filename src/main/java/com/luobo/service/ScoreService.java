package com.luobo.service;

import com.luobo.entity.Score;

public interface ScoreService {

	Long save(Score score);

	Score findByWorkId(Long workId);
}
