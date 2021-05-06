package com.divergentsl.servletjpasample.service;

import java.util.List;

import com.divergentsl.servletjpasample.dao.PatientDao;
import com.divergentsl.servletjpasample.dao.PatientDaoImpl;
import com.divergentsl.servletjpasample.entity.Patient;

public class PatientServiceImpl implements PatientService {
	private PatientDao patientDao = new PatientDaoImpl();

	@Override
	public void add(String name, int age, int weight, String gender, int contactno, String address) {
		Patient patient = new Patient();

		patient.setName(name);
		patient.setAge(age);
		patient.setWeight(weight);
		patient.setGender(gender);
		patient.setContactNo(contactno);
		patient.setAddress(address);

		patientDao.add(patient);
	}

	@Override
	public boolean remove(int id) {
		Patient patient = this.searchById(id);
		if (patient != null) {
			this.patientDao.remove(id);
			return true;
		}
		return false;
	}

	@Override
	public Patient searchById(int id) {
		return patientDao.searchById(id);
	}

	@Override
	public List<Patient> listAll() {
		return this.patientDao.listAll();
	}

}
