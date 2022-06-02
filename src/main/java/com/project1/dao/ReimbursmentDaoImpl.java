package com.project1.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.project1.models.Reimbursment;
import com.project1.models.User;
import com.project1.util.ConnectionFactory;

public class ReimbursmentDaoImpl implements ReimbursmentDao {

	@Override
	public void createNewReimbursment(Reimbursment r) {
		String sql = "INSERT INTO \"Project1\".Reimbursement (Department,username,Reimbursment_date,Tota_Cost, Expense_Type,Payment_Type,Description, reimuserid) values (?, ?, ?, ?, ?, ?, ?,(SELECT userid FROM \"Project1\".employee where username = ?));";
		Connection connection = ConnectionFactory.getConnection();
		try(PreparedStatement ps = connection.prepareStatement(sql)) {
			ps.setString(1,r.getDepartment());
			ps.setString(2,r.getUsername());
			ps.setString(3,r.getDate());
			ps.setDouble(4,r.getTotalCost());
			ps.setString(5,r.getExpenseType());
			ps.setString(6,r.getPaymentType());
			ps.setString(7,r.getDescription());
			ps.setString(8,r.getUsername());
			
			
			
			
			ps.execute();
			System.out.println("New request submitted");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

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
