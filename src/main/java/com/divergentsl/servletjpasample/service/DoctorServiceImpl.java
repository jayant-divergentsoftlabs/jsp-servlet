package com.divergentsl.servletjpasample.service;

import java.util.List;
import com.divergentsl.servletjpasample.dao.DoctorDao;
import com.divergentsl.servletjpasample.dao.DoctorDaoImpl;
import com.divergentsl.servletjpasample.entity.Doctor;


public class DoctorServiceImpl implements DoctorService {

	private DoctorDao doctorDao=new DoctorDaoImpl();

	public DoctorServiceImpl() {
		
		doctorDao = new DoctorDaoImpl();

	}

	@Override
	public Doctor insert(Doctor doctor) {
		return doctorDao.insert(doctor);
	}

	@Override
	public Doctor find(int id) {
		return  doctorDao.find(id);
	}

	@Override
	public List<Doctor> findAllDoctor() {
		return doctorDao.findAll();
	}

	@Override
	public void removeDoctor(int id) {
		doctorDao.remove(id);

	}

}