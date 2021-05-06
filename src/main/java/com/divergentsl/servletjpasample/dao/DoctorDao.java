package com.divergentsl.servletjpasample.dao;

import java.util.List;

import com.divergentsl.servletjpasample.entity.Doctor;

public interface DoctorDao<T> {
	
	public Doctor insert(T doctor);

	public Doctor find(int id);

	public List<T> findAll();

	public void remove(int id);
	

}
