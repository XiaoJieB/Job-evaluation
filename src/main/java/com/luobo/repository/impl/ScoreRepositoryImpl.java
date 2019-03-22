package com.luobo.repository.impl;

import com.luobo.repository.ScoreRepository;
import com.luobo.entity.Score;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by ws
 * On 2/2/2017.2:30 PM
 */
@Repository
public class ScoreRepositoryImpl implements ScoreRepository {

	@Autowired
	private SessionFactory sessionFactory;

	private Session getCurrentSession() {
		return this.sessionFactory.openSession();
	}

	public Score load(Long id) {
		return (Score)getCurrentSession().load(Score.class,id);
	}

	public Score get(Long id) {
		return (Score)getCurrentSession().get(Score.class,id);
	}

	public List<Score> findAll() {
		return null;
	}

	public void persist(Score entity) {
		getCurrentSession().persist(entity);
	}

	public Long save(Score entity) {
		return (Long)getCurrentSession().save(entity);
	}

	public void saveOrUpdate(Score entity) {
		getCurrentSession().saveOrUpdate(entity);
	}

	public void delete(Long id) {
		Score score = load(id);
		getCurrentSession().delete(score);
	}

	public void flush() {
		getCurrentSession().flush();
	}

	@Override
	public Score findByWorkId(Long workId) {
		String hql = "from Score s where s.bigWorkId = :workId";
		Query query = getCurrentSession().createQuery(hql);
		query.setParameter("workId",workId);
		List<Score> scores = query.list();
		if (scores != null && scores.size() != 0) {
			return scores.get(0);
		}
		return null;
	}
}