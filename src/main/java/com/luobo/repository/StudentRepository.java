package com.luobo.repository;

import com.luobo.entity.Student;

public interface StudentRepository extends BaseRepository<Student,Long>  {
	public Student findByNo(String no);

}
