package com.demo.task.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.demo.task.domain.Task;

@Repository("taskDao")
public class TaskDaoImpl implements TaskDao<Task>{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}

	@Override
	public void add(Task t) {
		getSession().save(t);
	}

	@Override
	public void delete(Task t) {
		getSession().delete(t);
	}

	@Override
	public boolean delete(Class<Task> clazz, Serializable id) {
		boolean isDeleted = false;
		Object objectToDelete = getSession().load(clazz, id);
		if(objectToDelete != null) {
			getSession().delete(objectToDelete);
			isDeleted = true;
		}
		return isDeleted;
	}

	@Override
	public void update(Task t) {
		getSession().update(t);
	}
	
	@Override
	public Task loadById(Class<Task> clazz, Serializable id) {
		return (Task) getSession().get(clazz, id);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Task> listAll(Class<Task> clazz) {
		return getSession().createCriteria(clazz).list();
	}

	@Override
	@SuppressWarnings("unchecked")
	public <C extends Enum<C>> List<Task> listTaskByCriteria(Class<Task> clazz, Enum<C> c,  String propertyName) {
		Criteria criteria = getSession().createCriteria(clazz).add(Restrictions.eq(propertyName, c));
		return criteria.list();
	}

	@Override
	public Long getCount(Class<Task> clazz) {
		Query query = getSession().createQuery("select count(1) from " + clazz.getName());
		return (Long) query.uniqueResult();
	}

}
