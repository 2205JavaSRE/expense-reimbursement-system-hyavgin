package com.project1.dao;

import java.util.List;

import com.project1.models.Reimbursment;
import com.project1.models.User;

public interface ReimbursmentDao {
	
	public void createNewReimbursment(Reimbursment r);
	
	public int employeLogin(User u);
	
	public List<Reimbursment> allReimbursmentById();
	
	
	
	

}
