package com.example.practica1;

import java.io.Serializable;



import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties
public class ShowEmaze implements Serializable{
	
	private String name;
	private Embedded _embedded;
	
	public ShowEmaze() {
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Embedded get_embedded() {
		return _embedded;
	}

	public void set_embedded(Embedded _embedded) {
		this._embedded = _embedded;
	}
	
	
	
	

}
