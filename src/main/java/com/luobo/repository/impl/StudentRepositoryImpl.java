package com.luobo.repository.impl;

import com.luobo.entity.Student;
import com.luobo.repository.StudentRepository;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * . Description: Date: 2019/3/11 14:19
 *
 * @author: ws
 * @version: 1.0
 */
public class StudentRepositoryImpl implements StudentRepository {

	@Autowired
	private SessionFactory sessionFactory;

	private Session getCurrentSession() {
		return this.sessionFactory.openSession();
	}

	public Student load(Long id) {
		return (Student)getCurrentSession().load(Student.class,id);
	}

	public Student get(Long id) {
		return (Student)getCurrentSession().get(Student.class,id);
	}

	public List<Student> findAll() {
		return null;
	}

	public void persist(Student entity) {
		getCurrentSession().persist(entity);
	}

	public Long save(Student entity) {
		return (Long)getCurrentSession().save(entity);
	}

	public void saveOrUpdate(Student entity) {
		getCurrentSession().saveOrUpdate(entity);
	}

	public void delete(Long id) {
		Student student = load(id);
		getCurrentSession().delete(student);
	}

	public void flush() {
		getCurrentSession().flush();
	}
}
