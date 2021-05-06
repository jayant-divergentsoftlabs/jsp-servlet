package com.divergentsl.servletjpasample.service;

import java.util.List;

import com.divergentsl.servletjpasample.entity.Doctor;


public interface DoctorService {
	public Doctor insert(Doctor doctor);

	public Doctor find(int id);

	public List<Doctor> findAllDoctor();

	public void removeDoctor(int id);
}
