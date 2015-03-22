package dao;

import java.io.Serializable;
import java.util.List;

public interface BaseDAO<T> {

	public Serializable save(T o);

	public void delete(T o);

	public void update(T o);

	public void saveOrUpdate(T o);

	public List<T> findAll();

	public List<T> find(Integer start, Integer limit);

	public List<T> find(String hql);

	public List<T> find(String hql, Object[] params);

	public List<T> find(String hql, Object[] params, Integer start, Integer limit);

	public T get(Serializable id);

	public T get(String hql, Object[] params);

	public Long countAll();

	public Long count(String hql);

	public Long count(String hql, Object[] params);

	public Integer executeHQL(String hql);

	public Integer executeHQL(String hql, Object[] params);

}
