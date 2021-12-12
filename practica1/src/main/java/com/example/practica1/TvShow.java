package com.example.practica1;

import java.io.Serializable;

public class TvShow  implements Serializable{
	

	private String  serieName;
	private String  episodeName;
	private String  description;
	private String  urlEpisode;
	private String  service;
	private String  serviceUrl;
	

	public TvShow(String serieName, String episodeName, String description, String urlEpisode, String service,
			String serviceUrl) {
		super();
		this.serieName = serieName;
		this.episodeName = episodeName;
		this.description = description;
		this.urlEpisode = urlEpisode;
		this.service = service;
		this.serviceUrl = serviceUrl;
	}

	public String getUrlEpisode() {
		return urlEpisode;
	}

	public void setUrlEpisode(String urlEpisode) {
		this.urlEpisode = urlEpisode;
	}

	public String getSerieName() {
		return serieName;
	}

	public void setSerieName(String serieName) {
		this.serieName = serieName;
	}

	public String getEpisodeName() {
		return episodeName;
	}

	public void setEpisodeName(String episodeName) {
		this.episodeName = episodeName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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
	

	

}
