package com.divergentsl.servletjpasample.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.divergentsl.servletjpasample.entity.Patient;
import com.divergentsl.servletjpasample.utility.EntityManagerUtility;

public class PatientDaoImpl implements PatientDao {

	@Override
	public void remove(int id) {
		EntityManager entityManager = EntityManagerUtility.getEntityManager();
		Patient patient = entityManager.find(Patient.class, id);
		if (patient != null) {
			entityManager.getTransaction().begin();
			entityManager.remove(patient);
			entityManager.getTransaction().commit();
			entityManager.close();
		}
	}

	@Override
	public void add(Patient patient) {
		EntityManager entityManager = EntityManagerUtility.getEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(patient);
		entityManager.getTransaction().commit();
		entityManager.close();

	}

	@Override
	public List<Patient> listAll() {
		EntityManager entityManager = EntityManagerUtility.getEntityManager();
		TypedQuery<Patient> query = entityManager.createQuery("Select e from Patient e", Patient.class);
		List<Patient> patients = query.getResultList();
		entityManager.close();
		return patients;
	}


	@Override
	public Patient searchById(int id) {
		EntityManager entityManager = EntityManagerUtility.getEntityManager();
		Patient patient = entityManager.find(Patient.class, id);
		entityManager.close();
		return patient;
	}

}
