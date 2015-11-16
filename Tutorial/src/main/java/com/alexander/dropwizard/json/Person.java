package com.alexander.dropwizard.json;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Person {

	@NotNull
	private Long id;
	
	@NotNull
	private String firstname;
	
	@NotNull
	private String surname;
	
	@NotNull
	private String address;
	
	public Person(){}
	
	public Person(Long id, String firstname, String surname, String address){
		this.id = id;
		this.firstname = firstname;
		this.surname = surname;
		this.address = address;
	}

	@JsonProperty
	public Long getId() {
		return id;
	}

	@JsonProperty
	public void setId(Long id) {
		this.id = id;
	}

	@JsonProperty
	public String getFirstname() {
		return firstname;
	}

	@JsonProperty
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	@JsonProperty
	public String getSurname() {
		return surname;
	}

	@JsonProperty
	public void setSurname(String surname) {
		this.surname = surname;
	}

	@JsonProperty
	public String getAddress() {
		return address;
	}

	@JsonProperty
	public void setAddress(String address) {
		this.address = address;
	}
	
	
}
