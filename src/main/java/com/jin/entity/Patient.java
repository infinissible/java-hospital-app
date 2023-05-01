package com.jin.entity;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;



@Entity
@Table(name = "Patient")
public class Patient {
	
	@Id
	@Column(name = "SS")
//	@GenericGenerator(name = "myGenerator",strategy = "increment")
//	@GeneratedValue(generator = "myGenerator",  strategy = GenerationType.AUTO)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int SSId;
	
	@Column(name = "Name")
	private String patientName;
	
	@Column(name = "Insurance")
	private String insurance;
	
	@Column(name = "DateAdmitted")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateAdmitted;
	
	@Column(name = "DateCheckedOut")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateCheckedOut;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "DoctorDSS")
	private Doctor doctor;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="patient", fetch = FetchType.EAGER)
	private List<Test> test = new ArrayList<>();
	
	public Patient() {
		super();
	}

	public Patient(String patientName, String insurance, Date dateAdmitted, Date dateCheckedOut, Doctor doctor) {
		super();
		this.patientName = patientName;
		this.insurance = insurance;
		this.dateAdmitted = dateAdmitted;
		this.dateCheckedOut = dateCheckedOut;
		this.doctor = doctor;
	}


	public int getSSId() {
		return SSId;
	}

	public void setSSId(int sSId) {
		SSId = sSId;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public String getInsurance() {
		return insurance;
	}

	public void setInsurance(String insurance) {
		this.insurance = insurance;
	}



	public Date getDateAdmitted() {
		return dateAdmitted;
	}


	public void setDateAdmitted(Date dateAdmitted) {
		this.dateAdmitted = dateAdmitted;
	}


	public Date getDateCheckedOut() {
		return dateCheckedOut;
	}


	public void setDateCheckedOut(Date dateCheckedOut) {
		this.dateCheckedOut = dateCheckedOut;
	}


	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public List<Test> getTest() {
		return test;
	}

	public void setTest(List<Test> test) {
		this.test = test;
	}

	@Override
	public String toString() {
		return "Patient [SSId=" + SSId + ", patientName=" + patientName + ", insurance=" + insurance + ", dateAdmitted="
				+ dateAdmitted + ", dateCheckedOut=" + dateCheckedOut + ", doctor=" + doctor +  "]";
	}
		
	

}
