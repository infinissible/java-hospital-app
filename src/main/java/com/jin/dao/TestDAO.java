package com.jin.dao;

import java.util.List;

import com.jin.entity.Test;

public interface TestDAO {
	
	void addTest(Test test);
	List<Test> viewAllTests();

}
