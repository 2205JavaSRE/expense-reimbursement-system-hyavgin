package com.project1.controller;

import io.javalin.Javalin;

public class RequestMapper {
	
	private ReimbursmentControl rController = new ReimbursmentControl();
	
	
	public void configureRoutes(Javalin app) {
		
		app.post("/api/requestSubmit", ctx ->{
			rController.requestSubmit(ctx);
			System.out.println("New Reimbursment Submitted");
			
		} );
		
		app.get("/api/reimbursments",ctx->{
			
			rController.allReimbursment(ctx);
			
		});
		
	}
	
}
