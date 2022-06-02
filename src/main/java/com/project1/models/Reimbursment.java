package com.project1.models;

import java.util.Objects;

public class Reimbursment {
	private int userid;
	private String department;
	private String username;
	private String date; 
	private double totalCost;
	private String expenseType;
	private String paymentType;
	private String paymentStatus;
	private String description;
	
	
	public Reimbursment() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Reimbursment(int userid, String department, String username, String date, double totalCost,
			String expenseType, String paymentType, String paymentStatus, String description) {
		super();
		this.userid = userid;
		this.department = department;
		this.username = username;
		this.date = date;
		this.totalCost = totalCost;
		this.expenseType = expenseType;
		this.paymentType = paymentType;
		this.paymentStatus = paymentStatus;
		this.description = description;
	}


	public int getUserid() {
		return userid;
	}


	public void setUserid(int userid) {
		this.userid = userid;
	}


	public String getDepartment() {
		return department;
	}


	public void setDepartment(String department) {
		this.department = department;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}


	public double getTotalCost() {
		return totalCost;
	}


	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}


	public String getExpenseType() {
		return expenseType;
	}


	public void setExpenseType(String expenseType) {
		this.expenseType = expenseType;
	}


	public String getPaymentType() {
		return paymentType;
	}


	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}


	public String getPaymentStatus() {
		return paymentStatus;
	}


	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	@Override
	public int hashCode() {
		return Objects.hash(date, department, description, expenseType, paymentStatus, paymentType, totalCost, userid,
				username);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reimbursment other = (Reimbursment) obj;
		return Objects.equals(date, other.date) && Objects.equals(department, other.department)
				&& Objects.equals(description, other.description) && Objects.equals(expenseType, other.expenseType)
				&& Objects.equals(paymentStatus, other.paymentStatus) && Objects.equals(paymentType, other.paymentType)
				&& Double.doubleToLongBits(totalCost) == Double.doubleToLongBits(other.totalCost)
				&& userid == other.userid && Objects.equals(username, other.username);
	}


	@Override
	public String toString() {
		return "Reimbursment [userid=" + userid + ", department=" + department + ", username=" + username + ", date="
				+ date + ", totalCost=" + totalCost + ", expenseType=" + expenseType + ", paymentType=" + paymentType
				+ ", paymentStatus=" + paymentStatus + ", description=" + description + "]";
	}
	
	
	

}
