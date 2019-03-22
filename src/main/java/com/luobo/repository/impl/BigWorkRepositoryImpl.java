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
	public void update(BigWork bigWork) {
		String teacherUpdate = "";
		String studentUpdate = "";
		String openUpdate = "";
		String scoreUpdate = "";
		if (bigWork.getScore() != null) {
			scoreUpdate = ",b.score.id=:scoreId";
		}
		if (bigWork.getName() != null) {
			teacherUpdate = ",b.name=:name, b.remark=:remark,b.studentId = :studentId";
		} else if (bigWork.getProjectSrc() != null) {
			studentUpdate = ",b.projectSrc=:projectSrc, b.gitSrc=:gitSrc,b.imgSrc = :imgSrc";
		} else {
			openUpdate = ",b.open = :open";
		}
		String hql = "update BigWork b set b.id=:id" + teacherUpdate + studentUpdate
			+ openUpdate + scoreUpdate
			+ " where b.id=:id";
		Query query = getCurrentSession().createQuery(hql);
		query.setParameter("id",bigWork.getId());
		if (bigWork.getScore() != null) {
			query.setParameter("scoreId",bigWork.getScore().getId());
		}
		if (bigWork.getName() != null) {
			query.setParameter("name",bigWork.getName());
			query.setParameter("remark",bigWork.getRemark());
			query.setParameter("studentId",bigWork.getStudentId());
		} else if (bigWork.getProjectSrc() != null){
			query.setParameter("projectSrc",bigWork.getProjectSrc());
			query.setParameter("gitSrc",bigWork.getGitSrc());
			query.setParameter("imgSrc",bigWork.getImgSrc());
		} else {
			query.setParameter("open",bigWork.getOpen());
		}
		query.executeUpdate();
	}

	@Override
	public void updateWorkBindStudent(Long studentId, Long id) {
		String hql = "update BigWork b set b.studentId = :studentId where b.id = :id";
		getCurrentSession()
			.createQuery(hql)
			.setParameter("id",id)
			.setParameter("studentId",studentId)
			.executeUpdate();
	}
}