package com.jin.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionUtil {

	
	public static Session getSession()
	{
		Configuration cfg=new Configuration();
    	System.out.println(cfg.getProperty("hibernate.connection.driver_class"));
    	    
    	cfg.configure("/com/jin/config/hibernate.cfg.xml");    
    	    cfg.setProperty("hibernate.connection.driver_class","com.mysql.jdbc.Driver");
    	    
    	    
    	System.out.println(cfg.getProperty("hibernate.connection.driver_class"));

    	SessionFactory factory=cfg.buildSessionFactory();
    	    
    	Session ses=factory.openSession();
		
		return ses;
	}
}
