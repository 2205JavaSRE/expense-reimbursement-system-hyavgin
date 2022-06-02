package com.project1.dao;

import java.util.List;

import com.project1.models.Reimbursment;
import com.project1.models.User;

public class ReimbursmentDaoImpl implements ReimbursmentDao {

	@Override
	public void createNewReimbursment(Reimbursment r) {
		System.out.println("calisiyormu");
		

	}

	@Override
	public int employeLogin(User u) {
		System.out.println("employelogin");
		return 0;
	}

	@Override
	public List<Reimbursment> allReimbursmentById() {
		System.out.println("liste");
		return null;
	}

}
