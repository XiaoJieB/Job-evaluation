package com.luobo.service;

import com.luobo.entity.BigWork;
import com.luobo.util.Page;
import java.util.List;

public interface BigWorkService extends BaseService<BigWork,Long>{
	Page<BigWork> findAllByTeacher(Long teacherId, Integer index, Integer pageSize);
}
