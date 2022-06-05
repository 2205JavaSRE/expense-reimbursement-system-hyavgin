package com.project1.controller;

import java.util.List;

import org.eclipse.jetty.http.HttpStatus;

import com.project1.models.Reimbursment;
import com.project1.models.User;
import com.project1.service.ReimbursmentService;

import io.javalin.http.Context;
import io.javalin.http.HttpCode;

public class ReimbursmentControl {
	
	private ReimbursmentService rService =new ReimbursmentService();
	
	public void requestSubmit(Context ctx) {
		
		Reimbursment jsonReimbursment =ctx.bodyAsClass(Reimbursment.class);
		
		rService.requestSubmit(jsonReimbursment.getUsername(), jsonReimbursment.getTotalCost(),jsonReimbursment.getExpenseType(),jsonReimbursment.getPaymentStatus());
		
		ctx.status(201);
		ctx.status(HttpCode.CREATED);
		ctx.result("New Reimbursement submitted by: " + jsonReimbursment.getUsername());
		System.out.println("New Reimbursment Submitted by :" +jsonReimbursment.getUsername());
		
		
	}
	
	public void allReimbursment(Context ctx) {
		
		List<Reimbursment> reimbursmentList = rService.allReimbursment();
		
		ctx.json(reimbursmentList);
		
	}
	public void statusCheck(Context ctx) {
		
		String name = ctx.pathParam("username");
		String status = ctx.pathParam("status");

		User u = ctx.sessionAttribute("user");
		if (u.getUsername().equals(name)) {
			List<Reimbursment> reimbursmentListByStatus =rService.reimburstmentByUsernameandStatus(name,status);
			ctx.json(reimbursmentListByStatus);
			ctx.status(HttpStatus.ACCEPTED_202);
		}else {
			ctx.result("you do not have access here");
			ctx.status(HttpCode.FORBIDDEN);
		}
		
	}
		
	public void usernameCheck(Context ctx) {
			
			String name = ctx.pathParam("username");
			User u = ctx.sessionAttribute("user");
			if (u.getUsername().equals(name)) {
				List<Reimbursment> reimbursmentListByUsername =rService.reimburstmentByUsername(name);
				ctx.json(reimbursmentListByUsername);
				ctx.status(HttpStatus.ACCEPTED_202);
			}else {
				ctx.result("you do not have access here");
				ctx.status(HttpCode.FORBIDDEN);
			}
		
		
		
	}
	public void paymentStatusUpdate(Context ctx) {
		
		Reimbursment jsonReimbursment =ctx.bodyAsClass(Reimbursment.class);
		
		rService.paymentUpdate(jsonReimbursment.getReimbursementId(), jsonReimbursment.getPaymentStatus());
		ctx.result("Payment Status Updated");
		ctx.status(HttpStatus.ACCEPTED_202);
	}
	
	

}
