package com.luobo.repository.impl;

import com.luobo.entity.BigWork;
import com.luobo.repository.BigWorkRepository;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by ws
 * On 2/2/2017.2:30 PM
 */
@Repository
public class BigWorkRepositoryImpl implements BigWorkRepository {

	@Autowired
	private SessionFactory sessionFactory;

	private Session getCurrentSession() {
		return this.sessionFactory.openSession();
	}

	public BigWork load(Long id) {
		return (BigWork)getCurrentSession().load(BigWork.class,id);
	}

	public BigWork get(Long id) {
		return (BigWork)getCurrentSession().get(BigWork.class,id);
	}

	public List<BigWork> findAll() {
		return null;
	}

	public void persist(BigWork entity) {
		getCurrentSession().persist(entity);
	}

	public Long save(BigWork entity) {
		return (Long)getCurrentSession().save(entity);
	}

	public void saveOrUpdate(BigWork entity) {
		getCurrentSession().saveOrUpdate(entity);
	}

	public void delete(Long id) {
		BigWork bigWork = load(id);
		getCurrentSession().delete(bigWork);
	}

	public void flush() {
		getCurrentSession().flush();
	}

	@Override
	public List<BigWork> findAllByTeacher(Long teacherId) {
		String hql = "from BigWork b where b.teacher.id = :teacherId";
		Query query = getCurrentSession().createQuery(hql);
		query.setParameter("teacherId",teacherId);
		List<BigWork> bigWorks = query.list();
		return bigWorks;
	}
}