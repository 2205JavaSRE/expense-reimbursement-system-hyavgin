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
			
			rController.allReimbursment(ctx);
			
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
			
			rController.statusCheck(ctx);
		});
		
		app.get("/reimbutsement/{username}", ctx->{
			
			rController.usernameCheck(ctx);
		});
		
	}
	
}
