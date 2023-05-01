package com.jin;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.jin.dao.impl.DoctorDAOImpl;
import com.jin.dao.impl.PatientDAOImpl;
import com.jin.dao.impl.TestDAOImpl;
import com.jin.entity.Doctor;
import com.jin.entity.Patient;

public class RetrivePatient {

	public static void main(String[] args) {
		
		PatientDAOImpl patientDao = new PatientDAOImpl();

		
		List<Patient> getAllPatients = patientDao.viewAllPatients();		
		for(Patient p: getAllPatients) {
			System.out.println(p.toString());
		}

	}

}
