package com.jin.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.jin.dao.PatientDAO;
import com.jin.entity.Patient;
import com.jin.util.SessionUtil;

public class PatientDAOImpl implements PatientDAO {

	@Override
	public void addPatient(Patient patient) {
		
		Session session = SessionUtil.getSession();
		Transaction transaction = session.beginTransaction();
		session.persist(patient);
		transaction.commit();
		
		System.out.println("A patient data inserted successfully");
		
		session.close();
		
	}

	@Override
	public List<Patient> viewAllPatients() {
		
		Session session = SessionUtil.getSession();
		Transaction transaction = session.beginTransaction();
		
		Query q = session.createQuery("from Patient");
		
		List <Patient> patientList = q.getResultList();
		
		session.close();
		
		return patientList;
	}
	
	

}
