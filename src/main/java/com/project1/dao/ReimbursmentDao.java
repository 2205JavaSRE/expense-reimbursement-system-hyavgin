package com.project1.dao;

import java.util.List;

import com.project1.models.Manager;
import com.project1.models.Reimbursment;
import com.project1.models.User;

public interface ReimbursmentDao {
	
	public void createNewReimbursment(Reimbursment r);
	
	public boolean employeLogin(User u);
	
	public List<Reimbursment> allReimbursmentById();
	
	public List<Reimbursment> reimburstmentByUsername(String username);
	
	public List<Reimbursment> reimburstmentByUsernameandStatus(String username, String status);
	
	public boolean managerLogin(Manager m);
	
	public void paymentStatusuUpgrade(int id, String status);
	
	public List<Reimbursment> allReimbursment();
	
	public List<Reimbursment> reimburstmentAllByUsername(String username);

}
