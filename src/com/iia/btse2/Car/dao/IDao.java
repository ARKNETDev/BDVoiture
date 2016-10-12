package com.iia.btse2.Car.dao;

import java.util.List;

public interface IDao<T> {

	boolean create(T object);
	
	boolean update(T object);
	
	boolean delete(T object);
	
	T findById(int id);
	
	List<T> findAll();
}
