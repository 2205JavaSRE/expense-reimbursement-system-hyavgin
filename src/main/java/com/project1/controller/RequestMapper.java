package com.project1.controller;

import java.io.File;

import io.javalin.Javalin;
import io.javalin.http.HttpCode;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.binder.jvm.ClassLoaderMetrics;
import io.micrometer.core.instrument.binder.jvm.JvmGcMetrics;
import io.micrometer.core.instrument.binder.jvm.JvmMemoryMetrics;
import io.micrometer.core.instrument.binder.jvm.JvmThreadMetrics;
import io.micrometer.core.instrument.binder.system.DiskSpaceMetrics;
import io.micrometer.core.instrument.binder.system.ProcessorMetrics;
import io.micrometer.core.instrument.binder.system.UptimeMetrics;
import io.micrometer.prometheus.PrometheusConfig;
import io.micrometer.prometheus.PrometheusMeterRegistry;

public class RequestMapper {
	
	private ReimbursmentControl rController = new ReimbursmentControl();
	
	
	public void configureRoutes(Javalin app) {
		
		
		PrometheusMeterRegistry registry = new PrometheusMeterRegistry(PrometheusConfig.DEFAULT);
		registry.config().commonTags("application","My-Frist-Monitored-App");
		
		new ClassLoaderMetrics().bindTo(registry);
		new JvmMemoryMetrics().bindTo(registry);
		new JvmGcMetrics().bindTo(registry);
		new JvmThreadMetrics().bindTo(registry);
		new UptimeMetrics().bindTo(registry);
		new ProcessorMetrics().bindTo(registry);
		new DiskSpaceMetrics(new File(System.getProperty("user.dir"))).bindTo(registry);
		//Counters for request_submit
		Counter counter = Counter.builder("Path_request_submit").description("track number").tag("purpose", "request_submit").register(registry);
		//Counters for request for reimbursement
		Counter counter1 = Counter.builder("Path_request_reimbursement").description("track number").tag("purpose", "reimbursment").register(registry);
		//Counters for request for login
		Counter counter2 = Counter.builder("Path_request_login").description("track number").tag("purpose", "login").register(registry);
		//Counters for request reimbursement control
		Counter counter3 = Counter.builder("Path_request_check").description("track number").tag("purpose", "reimbursement_check").register(registry);
		
		
		//metrics endpoint
		app.get("/metrics", ctx->{
			ctx.result(registry.scrape());
			
		});
		
		
		
		//employe reimbursement submit endpoint
		app.post("/api/requestSubmit", ctx ->{

			boolean access = AuthenticateController.sessionCheck(ctx);
			//session control if its existing user can submit 
			if(access) {
				rController.requestSubmit(ctx);	
				counter.increment(1);
			}else {
				ctx.status(HttpCode.FORBIDDEN);
			}
			
			
			
		} );
		// manger to see all pending reimbursements 
		app.get("/api/reimbursments",ctx->{
			
			
			boolean access = AuthenticateController.managerCheck(ctx);
			//If reimbursement not login can not see reimbursements
			if(access) {
				rController.allReimbursment(ctx);
				counter1.increment(1);
			}else {
				ctx.status(HttpCode.FORBIDDEN);
			}	
		});
		//login endpoint for employee
		app.post("/login", ctx->{
			
			AuthenticateController.authenticate(ctx);
			counter2.increment(1);

		});
		//logout endpoint for employee
		app.get("/logout", ctx->{
			
			AuthenticateController.logout(ctx);
			
		});
		//session check endpoint for employee
		app.get("/session/secret", ctx ->{
			
			AuthenticateController.sessionCheck(ctx);
		});
		
		//get reimbursement by name and status for employee
		app.get("/reimbutsement/{username}/{status}", ctx->{
			
			
			
			boolean access = AuthenticateController.sessionCheck(ctx);
			
			if(access) {
				rController.statusCheck(ctx);
			}else {
				ctx.status(HttpCode.FORBIDDEN);
			}
			
			
			
		});
		//get reimbursement by username for employee
		app.get("/reimbutsement/{username}", ctx->{
			
			boolean access = AuthenticateController.sessionCheck(ctx);
			
			if(access) {
				rController.usernameCheck(ctx);
				counter3.increment(1);
			}else {
				ctx.status(HttpCode.FORBIDDEN);
			}
			
			
		});
		
		//manager login endpoint
		app.post("/mlogin", ctx -> {
			
			AuthenticateController.authenticateManager(ctx);

		});
		//manager logout endpoint
		app.get("/mlogout", ctx -> {
			
			AuthenticateController.logoutManager(ctx);

		});
		
		//manager get reimbursement by name and status
		app.get("/manager/{username}/{status}", ctx->{
			
			
			
			boolean access = AuthenticateController.managerCheck(ctx);
			//if manager does not login it can not see the statement
			if(access) {
				rController.managerStatusCheck(ctx);
			}else {
				ctx.status(HttpCode.FORBIDDEN);
			}
			
			
			
		});
		//manager get reimbursement by name and status
		app.get("/manager/{uniqname}", ctx->{
			
			boolean access = AuthenticateController.managerCheck(ctx);
			//manager login requirement
			if(access) {
				rController.managerCheck(ctx);
			}else {
				ctx.status(HttpCode.FORBIDDEN);
			}
			
			
		});
		
		//manager reimbursement status update endpoint 
		app.put("/api/paymentupdate", ctx ->{

			boolean access = AuthenticateController.managerCheck(ctx);
	
			if(access) {
				rController.paymentStatusUpdate(ctx);			
			}else {
				ctx.status(HttpCode.FORBIDDEN);
			}
			
			
			
		} );
		
		//manager to see all reimbursement past and present
		app.get("/api/reimbursments/all",ctx->{
			
			
			boolean access = AuthenticateController.managerCheck(ctx);
			
			if(access) {
				rController.allReimbursement(ctx);
			}else {
				ctx.status(HttpCode.FORBIDDEN);
			}	
		});
		//get all reimbursement past and present by name
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
