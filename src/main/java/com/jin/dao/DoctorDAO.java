package com.jin.dao;

import java.util.List;

import com.jin.entity.Doctor;

public interface DoctorDAO {

	void addDoctor(Doctor doctor);
	List<Doctor> viewAllDoctors();
}
