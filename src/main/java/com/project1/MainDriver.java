package com.project1;

import java.sql.Connection;

import com.project1.controller.RequestMapper;
import com.project1.dao.ReimbursmentDao;
import com.project1.dao.ReimbursmentDaoImpl;
import com.project1.models.Reimbursment;
import com.project1.util.ConnectionFactory;

import io.javalin.Javalin;

public class MainDriver {
	
	public static void main(String[] args ) {
		
		Javalin app = Javalin.create().start(7112);
		
		RequestMapper requestMapper = new RequestMapper();
		requestMapper.configureRoutes(app);
		
		
		
		
		
		
		/*
		System.out.println("Elhamdulillah ilk adimi attik :D");
		Connection connection = ConnectionFactory.getConnection();
		ReimbursmentDao reimDao = new ReimbursmentDaoImpl();
		reimDao.allReimbursmentById();
		reimDao.createNewReimbursment(new Reimbursment(-1,"Engineering" , "havgin", "06/02/2022", 999.99, "Lodging", "Credit", null, "Education Travil hotel expenses"));
		reimDao.employeLogin(null);*/
		
		
	}
	
	
}
