package com.luobo.repository.impl;

import com.luobo.entity.Teacher;
import com.luobo.repository.TeacherRepository;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * . Description: Date: 2019/3/11 14:11
 *
 * @author: ws
 * @version: 1.0
 */
@Repository
public class TeacherRepositoryImpl implements TeacherRepository {

	@Autowired
	private SessionFactory sessionFactory;

	private Session getCurrentSession() {
		return this.sessionFactory.openSession();
	}

	public Teacher load(Long id) {
		return (Teacher)getCurrentSession().load(Teacher.class,id);
	}

	public Teacher get(Long id) {
		return (Teacher)getCurrentSession().get(Teacher.class,id);
	}

	public List<Teacher> findAll() {
		return null;
	}

	public void persist(Teacher entity) {
		getCurrentSession().persist(entity);
	}

	public Long save(Teacher entity) {
		return (Long)getCurrentSession().save(entity);
	}

	public void saveOrUpdate(Teacher entity) {
		getCurrentSession().saveOrUpdate(entity);
	}

	public void delete(Long id) {
		Teacher teacher = load(id);
		getCurrentSession().delete(teacher);
	}

	public void flush() {
		getCurrentSession().flush();
	}
}
