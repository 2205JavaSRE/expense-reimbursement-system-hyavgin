package com.project1.controller;

import org.eclipse.jetty.http.HttpStatus;

import com.project1.models.User;
import com.project1.service.AuthenticateService;

import io.javalin.http.Context;
import io.javalin.http.HttpCode;

public class AuthenticateController {
	

	public static boolean authenticate(Context ctx) {
		
		
			User u = ctx.bodyAsClass(User.class);
			
			ctx.sessionAttribute("user",u);
			
			boolean access = AuthenticateService.authenticateUser(u.getUsername(), u.getPassword());
			
			if (access) {
				ctx.result("You have access");
				ctx.status(HttpStatus.ACCEPTED_202);
			}else {
				ctx.result("You do not have access");
				ctx.status(HttpCode.FORBIDDEN);
			}
		
		return access;
	}

	public static void logout(Context ctx) {
		
		ctx.consumeSessionAttribute("user");
		
	}
	public static boolean sessionCheck(Context ctx) {
		
		User u = ctx.sessionAttribute("user");

		boolean access = false ;
		
		if ( u == null) {
			ctx.result("Wrong input or yo do not login yet!");
			ctx.status(HttpCode.FORBIDDEN);
			
		}else {
			access = AuthenticateService.authenticateUser(u.getUsername(), u.getPassword());
			ctx.result("You have access");
			ctx.status(HttpStatus.ACCEPTED_202);
		}
	
	return access;
		
		
	}

}
