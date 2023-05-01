package com.jin.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.jin.dao.TestDAO;
import com.jin.entity.Doctor;
import com.jin.entity.Test;
import com.jin.util.SessionUtil;

public class TestDAOImpl implements TestDAO {

	@Override
	public void addTest(Test test) {
		Session session = SessionUtil.getSession();
		Transaction transaction = session.beginTransaction();
		session.persist(test);
		transaction.commit();
		
		System.out.println("A test inserted successfully");
		
		session.close();
		
	}

	@Override
	public List<Test> viewAllTests() {
		Session session = SessionUtil.getSession();
		Transaction transaction = session.beginTransaction();
		
		Query q = session.createQuery("from Patient");
		
		List <Test> testList = q.getResultList();
		
		session.close();
		
		return testList;
	}
}
