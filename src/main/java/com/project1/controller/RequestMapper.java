package com.project1.controller;

import io.javalin.Javalin;
import io.javalin.http.HttpCode;

public class RequestMapper {
	
	private ReimbursmentControl rController = new ReimbursmentControl();
	
	
	public void configureRoutes(Javalin app) {
		
		
		app.post("/api/requestSubmit", ctx ->{

			boolean access = AuthenticateController.sessionCheck(ctx);
	
			if(access) {
				System.out.println("execute without manager");
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
		
		
		app.get("/reimbutsement/m/{username}/{status}", ctx->{
			
			
			
			boolean access = AuthenticateController.managerCheck(ctx);
			
			if(access) {
				rController.statusCheck(ctx);
			}else {
				ctx.status(HttpCode.FORBIDDEN);
			}
			
			
			
		});
		
		app.get("/reimbutsement/m/{username}", ctx->{
			
			boolean access = AuthenticateController.managerCheck(ctx);
			
			if(access) {
				rController.usernameCheck(ctx);
			}else {
				ctx.status(HttpCode.FORBIDDEN);
			}
			
			
		});
		
		
		app.put("/api/paymentupdate", ctx ->{

			boolean access = AuthenticateController.managerCheck(ctx);
	
			if(access) {
				System.out.println("execute without manager");
				rController.paymentStatusUpdate(ctx);			
			}else {
				ctx.status(HttpCode.FORBIDDEN);
			}
			
			
			
		} );
		
		
		
		
	}
	
}
