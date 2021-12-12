package com.example.practica1;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties
public class EpisodioItunes implements Serializable {

	private String  artistName;
	private String  trackName;
	private String  shortDescription;
	private String  trackViewUrl;


	public EpisodioItunes() {
		// TODO Auto-generated constructor stub
	}


	public String getArtistName() {
		return artistName;
	}


	public void setArtistName(String artistName) {
		this.artistName = artistName;
	}


	public String getTrackName() {
		return trackName;
	}


	public void setTrackName(String trackName) {
		this.trackName = trackName;
	}


	public String getShortDescription() {
		return shortDescription;
	}


	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}


	public String getTrackViewUrl() {
		return trackViewUrl;
	}


	public void setTrackViewUrl(String trackViewUrl) {
		this.trackViewUrl = trackViewUrl;
	}



	
	
}
