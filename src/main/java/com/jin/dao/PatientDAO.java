package com.jin.dao;

import java.util.List;

import com.jin.entity.Patient;

public interface PatientDAO {
	
	void addPatient(Patient patient);
	List<Patient> viewAllPatients();

}
