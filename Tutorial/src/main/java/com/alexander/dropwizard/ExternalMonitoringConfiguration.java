package com.alexander.dropwizard;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.dropwizard.Configuration;

public class ExternalMonitoringConfiguration extends Configuration {

	@NotEmpty
	private String ttlWebserviceAddress;
	@NotEmpty
	private String ttlWsgVersion;
	
	@JsonProperty
	public String getTtlWebServiceAddress(){
		return this.ttlWebserviceAddress;
	}
	
	@JsonProperty
	public void setTtlWebServiceAddress(String ttlWebServiceAddress){
		this.ttlWebserviceAddress = ttlWebServiceAddress;
	}
	
	@JsonProperty
	public String getTtlWsgVersion(){
		return this.ttlWsgVersion;
	}
	
	@JsonProperty
	public void setTtlWsgVersion(String ttlWsgVersion){
		this.ttlWsgVersion = ttlWsgVersion;
	}
	
	@NotEmpty
	private String defaultName = "Stranger";
	
	@NotEmpty
	private String template;

	@JsonProperty
	public String getDefaultName() {
		return defaultName;
	}

	@JsonProperty
	public void setDefaultName(String defaultName) {
		this.defaultName = defaultName;
	}

	@JsonProperty
	public String getTemplate() {
		return template;
	}

	@JsonProperty
	public void setTemplate(String template) {
		this.template = template;
	}
}
