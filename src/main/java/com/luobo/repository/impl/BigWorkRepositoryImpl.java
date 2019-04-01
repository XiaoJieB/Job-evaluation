package com.luobo.repository.impl;

import com.luobo.entity.BigWork;
import com.luobo.repository.BigWorkRepository;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
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

	private static Class<BigWork> bigWorkClass = (Class<BigWork>) BigWork.class;

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
		String hql = "from BigWork";
		Query query = getCurrentSession().createQuery(hql);
		List<BigWork> bigWorks = query.list();
		return bigWorks;
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
		String hql = "delete from BigWork b where b.id = :id";
		getCurrentSession().createQuery(hql).setParameter("id",id).executeUpdate();
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

	@Override
	public void update(BigWork bigWork) throws Exception {
		String update = "";
		Field fields[] = bigWorkClass.getDeclaredFields();
		Field.setAccessible(fields, true);
		List<Field> names = new ArrayList<Field>();
		for (Field field : fields) {
			String name = field.getName();
			if (field.get(bigWork) != null
				&& field.getName() != "created"
				&& field.getName() != "id") {
				names.add(field);
				if (field.getType().toString().indexOf("java.") != -1) {
					update += ",b." + name + "=:" + field.getName();
				} else {
					update += ",b." + field.getName() + ".id"+ "=:" + field.getName()+"Id";
				}
			}
		}
		String hql = "update BigWork b set b.id=:id" + update + " where b.id=:id";
		Query query = getCurrentSession().createQuery(hql);
		Method[] methods = bigWorkClass.getDeclaredMethods();
		for (Method method : methods) {
			String methodStr = method.getName();
			if (methodStr.indexOf("get") != -1) {
				for (int i = 0; i < names.size(); i++) {
					Field field = names.get(i);
					if (methodStr.toLowerCase().indexOf(field.getName().toLowerCase()) != -1) {
						if (field.getType().toString().indexOf("java.") != -1) {
							query.setParameter(field.getName(),method.invoke(bigWork));
						} else {
							if (methodStr.toLowerCase().indexOf("teacher") != -1) {
								query.setParameter("teacherId"
									, bigWork.getTeacher().getId());
							}
							if (methodStr.toLowerCase().indexOf("score") != -1) {
								query.setParameter("scoreId"
									, bigWork.getScore().getId());
							}
						}
					}
				}
			}
		}
		query.setParameter("id",bigWork.getId());
		query.executeUpdate();
	}

	@Override
	public List<Long> findAllStuIdsByTeacher(Long teacherId) {
		String hql = "select b.studentId from BigWork b where b.teacher.id = :teacherId";
		Query query = getCurrentSession().createQuery(hql);
		query.setParameter("teacherId",teacherId);
		List<Long> stuIds = query.list();
		stuIds.removeAll(Collections.singleton(null));
		return stuIds;
	}
}