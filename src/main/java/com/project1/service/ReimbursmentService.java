package com.project1.service;

import java.util.List;

import com.project1.dao.ReimbursmentDao;
import com.project1.dao.ReimbursmentDaoImpl;
import com.project1.models.Reimbursment;

public class ReimbursmentService {
	
	private static ReimbursmentDao rDao = new ReimbursmentDaoImpl();
	
	//new reimbursement request submit interacting with dao
	public void requestSubmit(String username, double totalCost, String expenseType, String paymentType) {
		
		Reimbursment newReimbursment = new Reimbursment(-1, -1, username, totalCost, expenseType, paymentType);
		
		rDao.createNewReimbursment(newReimbursment);
	}
	// connecting with dao layer to see all reimbursement
	public List<Reimbursment> allReimbursment(){
		
		List<Reimbursment> reimbursmentList = rDao.allReimbursmentById();
		
		for(Reimbursment r : reimbursmentList) {
		}
		
		
		return reimbursmentList;
		
	}
	
	// connecting with dao layer to see reimbursement by name
	public List<Reimbursment> reimburstmentByUsername(String username) {
		
		List<Reimbursment> reimbursmentListByUsername = rDao.reimburstmentByUsername(username);
		
		
		
		return reimbursmentListByUsername;
		
	}
	
	// connecting with dao layer to see reimbursement by name and statement
	public List<Reimbursment> reimburstmentByUsernameandStatus(String username, String status) {
		
		List<Reimbursment> reimbursmentListByStatus = rDao.reimburstmentByUsernameandStatus(username,status);
		
		return reimbursmentListByStatus;
		
	}

	// connecting with dao layer to see individual reimbursement by name and statement
	public void paymentUpdate(int id, String Status) {
		
		rDao.paymentStatusuUpgrade(id, Status);
		
	}

	// connecting with dao layer to see all reimbursement past and present
	public List<Reimbursment> allReimbursement(){
		
		List<Reimbursment> reimbursmentList = rDao.allReimbursment();
		
		for(Reimbursment r : reimbursmentList) {
		}
		
		
		return reimbursmentList;
		
	}
	
	// connecting with dao layer to see reimbursement by name 
	public List<Reimbursment> reimburstmentAllByUsername(String username) {
		
		List<Reimbursment> reimbursmentListByUsername = rDao.reimburstmentAllByUsername(username);
		
		
		
		return reimbursmentListByUsername;
		
	}




}
