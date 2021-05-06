package com.divergentsl.servletjpasample.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.divergentsl.servletjpasample.entity.Doctor;
import com.divergentsl.servletjpasample.utility.EntityManagerUtility;

@Repository
public class DoctorDaoImpl implements DoctorDao<Doctor> {

	@Override
	public Doctor insert(Doctor doctor) {
		EntityManager entityManager = EntityManagerUtility.getEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(doctor);
		entityManager.getTransaction().commit();
		entityManager.close();
		return doctor;
	}

	@Override
	public Doctor find(int id) {
		EntityManager entityManager = EntityManagerUtility.getEntityManager();
		Doctor doctor = entityManager.find(Doctor.class, id);
		entityManager.close();
		return doctor;
	}

	@Override
	public List<Doctor> findAll() {
		EntityManager entityManager = EntityManagerUtility.getEntityManager();
		TypedQuery<Doctor> query = entityManager.createQuery("Select d from Doctor d", Doctor.class);
		List<Doctor> doctor = query.getResultList();
		entityManager.close();
		return doctor;
	}

	@Override
	public void remove(int id) {
		EntityManager entityManager = EntityManagerUtility.getEntityManager();
		Doctor doctor = entityManager.find(Doctor.class, id);
		if (doctor != null) {
			entityManager.getTransaction().begin();
			entityManager.remove(doctor);
			entityManager.getTransaction().commit();
			entityManager.close();
		}
	}

}
