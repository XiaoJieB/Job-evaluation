package com.luobo.repository.impl;

import com.luobo.entity.Student;
import com.luobo.repository.StudentRepository;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * . Description: Date: 2019/3/11 14:19
 *
 * @author: ws
 * @version: 1.0
 */
@Repository
public class StudentRepositoryImpl implements StudentRepository {

	@Autowired
	private SessionFactory sessionFactory;

	private Session getCurrentSession() {
		return this.sessionFactory.openSession();
	}

	public Student load(Long id) {
		return (Student) getCurrentSession().load(Student.class, id);
	}

	public Student get(Long id) {
		return (Student) getCurrentSession().get(Student.class, id);
	}

	public List<Student> findAll() {
		String hql = "from Student s";
		Query query = getCurrentSession().createQuery(hql);
		List<Student> students = query.list();
		return students;
	}

	public void persist(Student entity) {
		getCurrentSession().persist(entity);
	}

	public Long save(Student entity) {
		return (Long) getCurrentSession().save(entity);
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

	public Student findByNo(String no) {
		String hql = "from Student s where s.number = :no";
		Query query = getCurrentSession().createQuery(hql);
		query.setParameter("no",no);
		List<Student> students = query.list();
		if (students != null && students.size() != 0) {
			return (Student) students.get(0);
		}
		return null;
	}
}
