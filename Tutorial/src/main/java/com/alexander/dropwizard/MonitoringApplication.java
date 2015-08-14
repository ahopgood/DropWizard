package com.alexander.dropwizard;

import com.alexander.dropwizard.helathchecks.TemplateHealthCheck;
import com.alexander.dropwizard.resources.HelloWorldResource;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class MonitoringApplication extends Application<ExternalMonitoringConfiguration>{

	public static void main(String[] args) throws Exception {
		new MonitoringApplication().run(args);
	}

	@Override
	public String getName(){
		return "UKR Monitoring";
	}
	
	@Override
	public void initialize(Bootstrap<ExternalMonitoringConfiguration> bootstrap){
		
	}
	
	@Override
	public void run(ExternalMonitoringConfiguration config, Environment environment)
			throws Exception {

		final HelloWorldResource resource = 
				new HelloWorldResource(config.getTemplate(), config.getDefaultName());
		environment.jersey().register(resource);
		
		final TemplateHealthCheck healthCheck = 
				new TemplateHealthCheck(config.getTemplate());
		environment.healthChecks().register("template", healthCheck);
	}
}
