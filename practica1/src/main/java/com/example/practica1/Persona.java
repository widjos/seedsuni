package com.example.practica1;

import java.io.Serializable;

public class Persona implements Serializable{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private String trackName;
	private String type;
	private String service;
	private String serviceUrl;
	
	public Persona(String name, String trackName , String type , String service , String serviceUrl) {
		
		this.name = name;
		this.trackName = trackName;
		this.type = type;
		this.service = service;
		this.serviceUrl = serviceUrl;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTrackName() {
		return trackName;
	}

	public void setTrackName(String trackName) {
		this.trackName = trackName;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}

	public String getServiceUrl() {
		return serviceUrl;
	}

	public void setServiceUrl(String serviceUrl) {
		this.serviceUrl = serviceUrl;
	}

	@Override
	public String toString() {
		return "{"
				+ "name= '"+name +"\',"  
				+ "trackName= '"+trackName+"\',"  
				+ "type= '"+type+"\',"
				+ "service= '"+service+"\',"	
				+ "serviceUrl= '"+serviceUrl+"\'," 
				+ 
				"}";
	}
	

}
