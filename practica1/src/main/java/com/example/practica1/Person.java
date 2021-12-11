package com.example.practica1;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties
public class Person implements Serializable{
	
	private int id;
	private String url;
	private String name;
	
	public Person() {
		
	}
	
	public Person(int id, String url, String name) {
		super();
		this.id = id;
		this.url = url;
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Artista [id=" + id + ", url=" + url + ", name=" + name + "]";
	}

	
	

	

	

}
