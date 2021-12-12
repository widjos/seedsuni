package com.example.practica1;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties
public class ShowItunes implements Serializable {
	
	private float resultCount;
	private List<EpisodioItunes> results ;
	
	public float getResultCount() {
		return resultCount;
	}
	
	public ShowItunes() {
		// TODO Auto-generated constructor stub
	}
	
	public void setResultCount(float resultCount) {
		this.resultCount = resultCount;
	}
	public List<EpisodioItunes> getResults() {
		return results;
	}
	public void setResults(List<EpisodioItunes> results) {
		this.results = results;
	}

	
}
