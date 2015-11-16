package com.alexander.dropwizard;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import com.alexander.dropwizard.json.Person;

public class PersonService {

	private Map<Long, Person> personMap = new HashMap<Long, Person>();
	private AtomicLong counter = new AtomicLong();
	private int pagination = 10;
	
	public Person getPerson(Long id){
		return personMap.get(id);
	}
	
	public Long updatePerson(Person person){
		personMap.put(person.getId(), person);
		return person.getId();
	}
	
	public Person createPerson(Person person){
		Long id = counter.incrementAndGet();
		person.setId(id);
		personMap.put(id, person);
		return person;
	}
	
	public Person removePerson(Long id){
		return personMap.remove(id);
	}
	
	public List<Person> getPersons(){
		Iterator<Long> personIter = personMap.keySet().iterator();
		List<Person> persons = new LinkedList<Person>();
//		int count = 0;
		while(personIter.hasNext()){ 
//				&& count < this.pagination){
			persons.add(personMap.get(personIter.next()));
//			count++;
		}
		return persons;
	}
}
