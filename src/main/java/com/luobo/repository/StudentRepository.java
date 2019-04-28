package com.luobo.repository;

import com.luobo.entity.Student;
import com.luobo.util.Page;
import java.util.List;

public interface StudentRepository extends BaseRepository<Student,Long>  {
	public Student findByNo(String no);

	void update(Student student);

	List<Student> findAllByTeacher(Long teacherId);

	Page<Student> findByPage(Integer index, Integer pageSize);
}
