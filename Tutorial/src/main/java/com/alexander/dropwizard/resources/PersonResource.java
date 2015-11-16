package com.alexander.dropwizard.resources;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.alexander.dropwizard.PersonService;
import com.alexander.dropwizard.json.Person;

@Path("/person")
@Produces(MediaType.APPLICATION_JSON)
public class PersonResource {

	private	PersonService personService;
	
//	@GET
//	public List<Long> getAllPersons(){
//		Long[] longArray = new Long[personMap.keySet().size()];
//		return Arrays.asList(personMap.keySet().toArray(longArray));
//	}
	
	@GET
	public Person getPerson(@QueryParam("id") Long id){
//		return personMap.get(id);
		return personService.getPerson(id);
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public Long updatePerson(Person person){
//		personMap.put(person.getId(), person);
//		return person.getId();
		return personService.updatePerson(person);
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Person createPerson(Person person){
//		Long id = counter.incrementAndGet();
//		person.setId(id);
//		personMap.put(id, person);
//		return person;
		return personService.createPerson(person);
	}
	
	@DELETE
	public Person removePerson(@QueryParam("id") Long id){
//		return personMap.remove(id);
		return personService.removePerson(id);
	}
	
	public void setPersonService(PersonService personService){
		this.personService = personService;
	}
}
