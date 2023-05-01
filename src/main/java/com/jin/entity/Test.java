package com.jin.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "Test")
public class Test {
	
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int testId;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "DoctorDSS")
	private Doctor doctor;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "PatientSS")
	private Patient patient;
	
	@Column(name = "Name")
	private String name;
	
	@Column(name = "TestDate")
	@Temporal(TemporalType.TIMESTAMP)
	private Date testDate;
	
	@Column(name = "TestTime")
	@Temporal(TemporalType.TIMESTAMP)
	private Date TestTime;
	
	@Column(name = "Result")
	private String result;

	public Test() {
		super();
	}

	public Test(Doctor doctor, Patient patient, String name, Date testDate, Date testTime, String result) {
		super();
		this.doctor = doctor;
		this.patient = patient;
		this.name = name;
		this.testDate = testDate;
		TestTime = testTime;
		this.result = result;
	}

	public int getTestId() {
		return testId;
	}

	public void setTestId(int testId) {
		this.testId = testId;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getTestDate() {
		return testDate;
	}

	public void setTestDate(Date testDate) {
		this.testDate = testDate;
	}

	public Date getTestTime() {
		return TestTime;
	}

	public void setTestTime(Date testTime) {
		TestTime = testTime;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	@Override
	public String toString() {
		return "Test [testId=" + testId + ", doctor=" + doctor + ", patient=" + patient + ", name=" + name
				+ ", testDate=" + testDate + ", TestTime=" + TestTime + ", result=" + result + "]";
	}
	
	

}
