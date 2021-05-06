package com.divergentsl.servletjpasample.dao;

import java.util.List;

import com.divergentsl.servletjpasample.entity.Patient;

public interface PatientDao {
	
	void add(Patient patient);

	public List<Patient> listAll();
	
	void remove(int id);
	
	Patient searchById(int id);
	

}
