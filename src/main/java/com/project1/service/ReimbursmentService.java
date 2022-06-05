package com.project1.service;

import java.util.List;

import com.project1.dao.ReimbursmentDao;
import com.project1.dao.ReimbursmentDaoImpl;
import com.project1.models.Reimbursment;

public class ReimbursmentService {
	
	private static ReimbursmentDao rDao = new ReimbursmentDaoImpl();
	
	public void requestSubmit(String username, double totalCost, String expenseType, String paymentType) {
		
		Reimbursment newReimbursment = new Reimbursment(-1, -1, username, totalCost, expenseType, paymentType);
		
		rDao.createNewReimbursment(newReimbursment);
	}
	
	public List<Reimbursment> allReimbursment(){
		
		List<Reimbursment> reimbursmentList = rDao.allReimbursmentById();
		
		for(Reimbursment r : reimbursmentList) {
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


	public void paymentUpdate(int id, String Status) {
		
		rDao.paymentStatusuUpgrade(id, Status);
		
	}


}
