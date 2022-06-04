package com.project1.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.project1.models.Reimbursment;
import com.project1.models.User;
import com.project1.util.ConnectionFactory;

public class ReimbursmentDaoImpl implements ReimbursmentDao {
	
	private Connection connection = ConnectionFactory.getConnection();
	
	@Override
	public void createNewReimbursment(Reimbursment r) {
		String sql = "INSERT INTO \"Project1\".Reimbursement (Department,username,Reimbursment_date,Tota_Cost, Expense_Type,Payment_Type,Description, reimuserid) values (?, ?, ?, ?, ?, ?, ?,(SELECT userid FROM \"Project1\".employee where username = ?));";
		
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
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public boolean employeLogin(User u) {
		String sql = "SELECT * FROM \"Project1\".employee WHERE username = ? AND password = ? ;";
		try(PreparedStatement ps = connection.prepareStatement(sql))  {
			ps.setString(1, u.getUsername());
			ps.setString(2, u.getPassword());
			
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				
				//result found,means valid inputs
				return true;
				
			}
			
			
		} catch (SQLException e) {
			System.out.println("Login error -->" + e.getMessage());
			return false;
		}
		return false;

		
	}

	@Override
	public List<Reimbursment> allReimbursmentById() {
		String sql = "select * from \"Project1\".reimbursement;";
		List<Reimbursment> reimbursmentList = new ArrayList<>();
		
		try(PreparedStatement ps = connection.prepareStatement(sql)) {
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Reimbursment r = new Reimbursment(rs.getInt("reimuserid"), rs.getString("department"), rs.getString("username"), rs.getString("reimbursment_date"),
						rs.getInt("tota_cost"), rs.getString("expense_type"), rs.getString("payment_type"), rs.getString("payment_status"), rs.getString("description"));
				
				
				reimbursmentList.add(r);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return reimbursmentList;
	}

	@Override
	public List<Reimbursment> reimburstmentByUsername(String username) {
		String sql = "select * from \"Project1\".reimbursement where username = ?;";
		List<Reimbursment> reimbursmentListByusername = new ArrayList<>();
		
		try(PreparedStatement ps = connection.prepareStatement(sql)) {
			ps.setString(1,username);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Reimbursment r = new Reimbursment(rs.getInt("reimuserid"), rs.getString("department"), rs.getString("username"), rs.getString("reimbursment_date"),
						rs.getInt("tota_cost"), rs.getString("expense_type"), rs.getString("payment_type"), rs.getString("payment_status"), rs.getString("description"));
				
				
				reimbursmentListByusername.add(r);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		// TODO Auto-generated method stub
		return reimbursmentListByusername;
	}

	@Override
	public List<Reimbursment> reimburstmentByUsernameandStatus(String username, String status) {
		String sql = "select * from \"Project1\".reimbursement where username = ? and payment_status = ? ";
		List<Reimbursment> reimbursmentListByusernameandStatus = new ArrayList<>();
		
		try(PreparedStatement ps = connection.prepareStatement(sql)) {
			ps.setString(1,username);
			ps.setString(2,status);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Reimbursment r = new Reimbursment(rs.getInt("reimuserid"), rs.getString("department"), rs.getString("username"), rs.getString("reimbursment_date"),
						rs.getInt("tota_cost"), rs.getString("expense_type"), rs.getString("payment_type"), rs.getString("payment_status"), rs.getString("description"));
				
				
				reimbursmentListByusernameandStatus.add(r);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		// TODO Auto-generated method stub
		return reimbursmentListByusernameandStatus;
	}

}
