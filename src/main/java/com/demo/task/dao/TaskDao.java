package com.demo.task.dao;

import java.io.Serializable;
import java.util.List;

public interface TaskDao <T> {
	
	public void add(T t);
	
	public void delete(T t);
	
	public boolean delete(Class<T> clazz, Serializable id);
	
	public void update(T t);
	
	public T loadById(Class<T> clazz, Serializable id);
	
	public List<T> listAll(Class<T> clazz);
	
	public <C extends Enum<C>> List<T> listTaskByCriteria(Class<T> clazz, Enum<C> c, String propertyName);
	
	public Long getCount(Class<T> clazz);
	
}
