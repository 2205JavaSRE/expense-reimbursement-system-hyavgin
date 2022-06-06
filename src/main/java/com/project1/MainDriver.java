package com.project1;

import java.rmi.registry.Registry;

import com.project1.controller.RequestMapper;


import io.javalin.Javalin;
import io.javalin.plugin.metrics.MicrometerPlugin;
import io.micrometer.prometheus.PrometheusConfig;
import io.micrometer.prometheus.PrometheusMeterRegistry;

public class MainDriver {
	
	public static void main(String[] args ) {
		
		PrometheusMeterRegistry registry = new PrometheusMeterRegistry(PrometheusConfig.DEFAULT);
		registry.config().commonTags("application","My-Frist-Monitored-App");
		
		
		Javalin app = Javalin.create(config -> {config.registerPlugin(new MicrometerPlugin(registry));}).start(7115);
		
		
		RequestMapper requestMapper = new RequestMapper();
		requestMapper.configureRoutes(app);
		



		
		
		
	}
	
	
}
