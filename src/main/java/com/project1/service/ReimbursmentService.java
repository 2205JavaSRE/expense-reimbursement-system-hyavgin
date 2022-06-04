package com.project1.service;

import java.util.List;

import com.project1.dao.ReimbursmentDao;
import com.project1.dao.ReimbursmentDaoImpl;
import com.project1.models.Reimbursment;

public class ReimbursmentService {
	
	private static ReimbursmentDao rDao = new ReimbursmentDaoImpl();
	
	public void requestSubmit(String department,String username, String date, double totalCost, String expenseType, String paymentType, String description) {
		
		Reimbursment newReimbursment = new Reimbursment(-1,department, username, date, totalCost, expenseType, paymentType, null, description);
		
		rDao.createNewReimbursment(newReimbursment);
	}
	
	public List<Reimbursment> allReimbursment(){
		
		List<Reimbursment> reimbursmentList = rDao.allReimbursmentById();
		
		for(Reimbursment r : reimbursmentList) {
			/*System.out.println("User Id :" + r.getUserid());
			System.out.println("Username :" + r.getUsername());
			System.out.println("Department :" + r.getDepartment());
			System.out.println("Date :" + r.getDate());
			System.out.println("Total Cost :" + r.getTotalCost());
			System.out.println("Expense Type :" + r.getExpenseType());
			System.out.println("Payment Type " + r.getPaymentType());
			System.out.println("Pament Status :" + r.getPaymentStatus());
			System.out.println("Description :" + r.getDescription());*/
		}
		
		
		return reimbursmentList;
		
	}
	
	
	public List<Reimbursment> reimburstmentByUsername(String username) {
		
		List<Reimbursment> reimbursmentListByUsername = rDao.reimburstmentByUsername(username);
		
		
		
		return reimbursmentListByUsername;
		
	}
	
	
	public List<Reimbursment> reimburstmentByUsernameandStatus(String username, String status) {
		
		List<Reimbursment> reimbursmentListByStatus = rDao.reimburstmentByUsernameandStatus(username,status);
		
		return reimbursmentListByStatus;
		
	}

}
