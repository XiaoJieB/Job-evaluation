package com.luobo.repository;

import com.luobo.entity.BigWork;
import com.luobo.util.Page;
import java.util.List;

public interface BigWorkRepository extends BaseRepository<BigWork,Long> {

	Page<BigWork> findAllByTeacher(Long teacherId, Integer index, Integer pageSize);

	void update (BigWork bigWork) throws Exception;

	public List<Long> findAllStuIdsByTeacher(Long teacherId);
}
