package com.jin.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Doctor")
public class Doctor {

	@Id
	@Column(name="DSS")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int doctorId;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="doctor")
	private List<Patient> patient = new ArrayList<>();
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="doctor")
	private List<Test> test = new ArrayList<>();
	
	@Column(name="Name")
	private String doctorName;
	
	@Column(name="Specialization")
	private String specialization;

	public Doctor() {
		super();
	}

	public Doctor(String doctorName, String specialization) {
		super();
		this.doctorName = doctorName;
		this.specialization = specialization;
	}

	public int getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	@Override
	public String toString() {
		return "Doctor [doctorId=" + doctorId + ", doctorName=" + doctorName + ", specialization=" + specialization
				+ "]";
	}
	
	
}
