package com.example.practica1;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties
public class Embedded  implements Serializable{
	
	private List<EpisodioEmaze> episodes;
	
	public Embedded() {
		// TODO Auto-generated constructor stub
	}

	public List<EpisodioEmaze> getEpisodes() {
		return episodes;
	}

	public void setEpisodes(List<EpisodioEmaze> episodes) {
		this.episodes = episodes;
	}
	
	
	
	

}
