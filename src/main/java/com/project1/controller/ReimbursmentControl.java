package com.project1.controller;

import java.util.List;

import com.project1.models.Reimbursment;
import com.project1.service.ReimbursmentService;

import io.javalin.http.Context;
import io.javalin.http.HttpCode;

public class ReimbursmentControl {
	
	private ReimbursmentService rService =new ReimbursmentService();
	
	public void requestSubmit(Context ctx) {
		
		Reimbursment jsonReimbursment =ctx.bodyAsClass(Reimbursment.class);
		
		rService.requestSubmit(jsonReimbursment.getDepartment(), jsonReimbursment.getUsername(), jsonReimbursment.getDate(), jsonReimbursment.getTotalCost(),
				jsonReimbursment.getExpenseType() ,jsonReimbursment.getPaymentType() ,jsonReimbursment.getDescription());
		
		ctx.status(201);
		ctx.status(HttpCode.CREATED);
		ctx.result("New Reimbursement submitted by: " + jsonReimbursment.getUsername());
		System.out.println("New Reimbursment Submitted by :" +jsonReimbursment.getUsername());
		
		
	}
	
	public void allReimbursment(Context ctx) {
		
		List<Reimbursment> reimbursmentList = rService.allReimbursment();
		
		ctx.json(reimbursmentList);
		
	}

}
