package com.project1.controller;

import io.javalin.Javalin;
import io.javalin.http.HttpCode;

public class RequestMapper {
	
	private ReimbursmentControl rController = new ReimbursmentControl();
	
	
	public void configureRoutes(Javalin app) {
		
		
		app.post("/api/requestSubmit", ctx ->{

			boolean access = AuthenticateController.sessionCheck(ctx);
	
			if(access) {
				rController.requestSubmit(ctx);				
			}else {
				ctx.status(HttpCode.FORBIDDEN);
			}
			
			
			
		} );
		
		app.get("/api/reimbursments",ctx->{
			
			
			boolean access = AuthenticateController.managerCheck(ctx);
			
			if(access) {
				rController.allReimbursment(ctx);
			}else {
				ctx.status(HttpCode.FORBIDDEN);
			}	
		});
		
		app.post("/login", ctx->{
			
			AuthenticateController.authenticate(ctx);

		});
		app.get("/logout", ctx->{
			
			AuthenticateController.logout(ctx);
			
		});
		app.get("/session/secret", ctx ->{
			
			AuthenticateController.sessionCheck(ctx);
		});
		
		
		app.get("/reimbutsement/{username}/{status}", ctx->{
			
			
			
			boolean access = AuthenticateController.sessionCheck(ctx);
			
			if(access) {
				rController.statusCheck(ctx);
			}else {
				ctx.status(HttpCode.FORBIDDEN);
			}
			
			
			
		});
		
		app.get("/reimbutsement/{username}", ctx->{
			
			boolean access = AuthenticateController.sessionCheck(ctx);
			
			if(access) {
				rController.usernameCheck(ctx);
			}else {
				ctx.status(HttpCode.FORBIDDEN);
			}
			
			
		});
		
		
		app.post("/mlogin", ctx -> {
			
			AuthenticateController.authenticateManager(ctx);

		});
		
		app.get("/mlogout", ctx -> {
			
			AuthenticateController.logoutManager(ctx);

		});
		
		
		app.get("/manager/{username}/{status}", ctx->{
			
			
			
			boolean access = AuthenticateController.managerCheck(ctx);
			
			if(access) {
				rController.managerStatusCheck(ctx);
			}else {
				ctx.status(HttpCode.FORBIDDEN);
			}
			
			
			
		});
		
		app.get("/manager/{uniqname}", ctx->{
			
			boolean access = AuthenticateController.managerCheck(ctx);
			if(access) {
				rController.managerCheck(ctx);
			}else {
				ctx.status(HttpCode.FORBIDDEN);
			}
			
			
		});
		
		
		app.put("/api/paymentupdate", ctx ->{

			boolean access = AuthenticateController.managerCheck(ctx);
	
			if(access) {
				rController.paymentStatusUpdate(ctx);			
			}else {
				ctx.status(HttpCode.FORBIDDEN);
			}
			
			
			
		} );
		
		
		app.get("/api/reimbursments/all",ctx->{
			
			
			boolean access = AuthenticateController.managerCheck(ctx);
			
			if(access) {
				rController.allReimbursement(ctx);
			}else {
				ctx.status(HttpCode.FORBIDDEN);
			}	
		});
		
		app.get("/managerall/{uniqname}", ctx->{
			
			boolean access = AuthenticateController.managerCheck(ctx);
			
			if(access) {
				rController.allReimbursementByUsername(ctx);
			}else {
				ctx.status(HttpCode.FORBIDDEN);
			}
			
			
		});
		
		
		
	}
	
}
