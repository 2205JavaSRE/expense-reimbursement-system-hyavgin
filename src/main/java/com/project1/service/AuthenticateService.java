package com.project1.service;

import com.project1.dao.ReimbursmentDao;
import com.project1.dao.ReimbursmentDaoImpl;
import com.project1.models.Manager;
import com.project1.models.User;

import io.javalin.http.Context;

public class AuthenticateService {
	
	private static ReimbursmentDao rDao = new ReimbursmentDaoImpl();
	//User name check from Db
	public static boolean authenticateUser(String username, String password) {
		
		User newUser = new User(-1, username, password);
		
		Boolean access = rDao.employeLogin(newUser);
		
		return access;
		
	}
	//manager check from db
	public static boolean authenticateManger(String username, String password) {
		
		Manager newManager = new Manager(username, password);
		
		Boolean access = rDao.managerLogin(newManager);

		return access;
		
	}
	
	
	
	
}
