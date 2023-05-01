package com.jin;

import java.util.Date;
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
import com.jin.entity.Test;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
		Configuration cfg=new Configuration();
		System.out.println(cfg.getProperty("hibernate.connection.driver_class"));

		cfg.configure("/com/jin/config/hibernate.cfg.xml");    

		System.out.println(cfg.getProperty("hibernate.connection.driver_class"));

		SessionFactory factory=cfg.buildSessionFactory();

		Session ses=factory.openSession();

		Transaction tx=ses.beginTransaction();
		
		DoctorDAOImpl doctorDao = new DoctorDAOImpl();
		Doctor doctor1 = new Doctor("Doc1", "Spec1");
		Doctor doctor2 = new Doctor("Doc2", "Spec2");
		doctorDao.addDoctor(doctor1);
		doctorDao.addDoctor(doctor2);

		
		PatientDAOImpl patientDao = new PatientDAOImpl();
		Patient patient = new Patient("Obama", "Medi-cal", new Date(), new Date(), doctor1);
		Patient patient2 = new Patient("Elon", "Anthem", new Date(), new Date(), doctor2);
		patientDao.addPatient(patient);
		patientDao.addPatient(patient2);
//		tx.commit();
		
		TestDAOImpl testDao = new TestDAOImpl();
		Test test1 = new Test(doctor1, patient, "Test1", new Date(), new Date(), "Result1");
		Test test2 = new Test(doctor1, patient, "Test2", new Date(), new Date(), "Result2");
		testDao.addTest(test1);
		testDao.addTest(test2);

//		List<Patient> patients = patientDao.viewAllPatients();
//		patients.forEach(p -> System.out.println(p.getPatientName()+" "+p.getInsurance()+" "+p.getDoctor()+" "+p.getTest()));

//		List<Test> tests = testDao.viewAllTests();
//		tests.forEach(t -> System.out.println(t.toString()));
		
		ses.close();
		factory.close();
    }
}
