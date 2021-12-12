package com.example.practica1;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties 
public class Itunes implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private float resultCount;
	private List<PersonItunes> results ;
	
	public Itunes() {
		// TODO Auto-generated constructor stub
	}
	
	public Itunes(float resultCount, List<PersonItunes> results) {
		super();
		this.resultCount = resultCount;
		this.results = results;
	}
	public float getResultCount() {
		return resultCount;
	}
	public void setResultCount(float resultCount) {
		this.resultCount = resultCount;
	}
	public List<PersonItunes> getResults() {
		return results;
	}
	public void setResults(List<PersonItunes> results) {
		this.results = results;
	}
	
	
	
	

	
}
