package dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

@SuppressWarnings("all")
public class BaseDAOImpl<T> {

	@Autowired
	private SessionFactory sessionFactory;

	protected Session callCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	protected Class<T> callTClass() {
		Type genType = getClass().getGenericSuperclass();
		Type[] params = ((ParameterizedType) genType).getActualTypeArguments();
		return (Class) params[0];
	}

	protected Class<T> getTClass() {
		return null;
	}

	public Serializable save(T o) {
		return callCurrentSession().save(o);
	}

	public void delete(T o) {
		callCurrentSession().delete(o);
	}

	public void update(T o) {
		callCurrentSession().update(o);
	}

	public void saveOrUpdate(T o) {
		callCurrentSession().saveOrUpdate(o);
	}

	public List<T> findAll() {
		String hql = String.format("from %s", callTClass().getName());
		return find(hql, null, null, null);
	}

	public List<T> find(Integer start, Integer limit) {
		String hql = String.format("from %s", callTClass().getName());
		return find(hql, null, start, limit);
	}

	public List<T> find(String hql) {
		return find(hql, null, null, null);
	}

	public List<T> find(String hql, Object[] params) {
		return find(hql, params, null, null);
	}

	public List<T> find(String hql, Object[] params, Integer start, Integer limit) {
		Query query = callCurrentSession().createQuery(hql);
		if (params != null && params.length > 0) {
			for (int i = 0; i < params.length; i++) {
				query.setParameter(i, params[i]);
			}
		}
		if (start != null && start > -1) {
			query.setFirstResult(start);
		}
		if (limit != null && limit > -1) {
			query.setMaxResults(limit);
		}
		return query.list();
	}

	public T get(Serializable id) {
		return (T) callCurrentSession().get(callTClass(), id);
	}

	public T get(String hql, Object[] params) {
		List<T> list = find(hql, params, null, null);
		return list.size() != 1 ? null : list.get(0);
	}

	public Long countAll() {
		String hql = String.format("select count(id) from %s", callTClass().getName());
		return count(hql, null);
	}

	public Long count(String hql) {
		return count(hql, null);
	}

	public Long count(String hql, Object[] params) {
		Query query = callCurrentSession().createQuery(hql);
		if (params != null && params.length > 0) {
			for (int i = 0; i < params.length; i++) {
				query.setParameter(i, params[i]);
			}
		}
		return (Long) query.uniqueResult();
	}

	public Integer executeHQL(String hql) {
		return executeHQL(hql, null);
	}

	public Integer executeHQL(String hql, Object[] params) {
		Query query = callCurrentSession().createQuery(hql);
		if (params != null && params.length > 0) {
			for (int i = 0; i < params.length; i++) {
				query.setParameter(i, params[i]);
			}
		}
		return query.executeUpdate();
	}

}
