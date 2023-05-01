package com.jin.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.jin.dao.DoctorDAO;
import com.jin.entity.Doctor;
import com.jin.util.SessionUtil;

public class DoctorDAOImpl implements DoctorDAO {

	@Override
	public void addDoctor(Doctor doctor) {
		Session session = SessionUtil.getSession();
		Transaction transaction = session.beginTransaction();
		session.persist(doctor);
		transaction.commit();
		
		System.out.println("A doctor data inserted successfully");
		
		session.close();
		
	}

	@Override
	public List<Doctor> viewAllDoctors() {
		Session session = SessionUtil.getSession();
		Transaction transaction = session.beginTransaction();
		
		Query q = session.createQuery("from Patient");
		
		List <Doctor> doctorList = q.getResultList();
		
		session.close();
		
		return doctorList;
	}

}
