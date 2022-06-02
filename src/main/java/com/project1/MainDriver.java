package com.project1;

import java.sql.Connection;

import com.project1.dao.ReimbursmentDao;
import com.project1.dao.ReimbursmentDaoImpl;
import com.project1.models.Reimbursment;
import com.project1.util.ConnectionFactory;

public class MainDriver {
	
	public static void main(String[] args ) {
		System.out.println("Elhamdulillah ilk adimi attik :D");
		Connection connection = ConnectionFactory.getConnection();
		ReimbursmentDao reimDao = new ReimbursmentDaoImpl();
		reimDao.allReimbursmentById();
		reimDao.createNewReimbursment(new Reimbursment(-1,"Engineering" , "havgin", "06/02/2022", 999.99, "Lodging", "Credit", null, "Education Travil hotel expenses"));
		reimDao.employeLogin(null);
		
		
	}
	
	
}
