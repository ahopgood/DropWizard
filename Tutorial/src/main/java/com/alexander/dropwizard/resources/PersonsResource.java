package com.alexander.dropwizard.resources;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.alexander.dropwizard.PersonService;
import com.alexander.dropwizard.json.Person;

@Path("/persons")
@Produces(MediaType.APPLICATION_JSON)
public class PersonsResource {
	
	private PersonService personService;
	
	@GET
	public List<Person> getPersons(){
		return personService.getPersons();
	}
	
	public void setPersonService(PersonService personService){
		this.personService = personService;
	}
}
