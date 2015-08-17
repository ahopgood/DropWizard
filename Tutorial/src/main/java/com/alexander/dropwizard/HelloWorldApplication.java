package com.alexander.dropwizard;

import com.alexander.dropwizard.helathchecks.TemplateHealthCheck;
import com.alexander.dropwizard.resources.HelloWorldResource;
import com.alexander.dropwizard.resources.PersonResource;
import com.alexander.dropwizard.resources.PersonsResource;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class HelloWorldApplication extends Application<HelloWorldConfiguration>{

	public static void main(String[] args) throws Exception {
		new HelloWorldApplication().run(args);
	}

	@Override
	public String getName(){
		return "Hello World";
	}
	
	@Override
	public void initialize(Bootstrap<HelloWorldConfiguration> bootstrap){
		
	}
	
	@Override
	public void run(HelloWorldConfiguration config, Environment environment)
			throws Exception {

		final HelloWorldResource resource = 
				new HelloWorldResource(config.getTemplate(), config.getDefaultName());
		environment.jersey().register(resource);
		
		final TemplateHealthCheck healthCheck = 
				new TemplateHealthCheck(config.getTemplate());
		environment.healthChecks().register("template", healthCheck);
		
		PersonService personService = new PersonService();
		
		final PersonResource personResource =
				new PersonResource();
		personResource.setPersonService(personService);
		environment.jersey().register(personResource);

		final PersonsResource personsResource =
				new PersonsResource();
		personsResource.setPersonService(personService);
		environment.jersey().register(personsResource);

	}
}
