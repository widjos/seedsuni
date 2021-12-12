package com.example.practica1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class Manejador {
	final static Logger logger = LoggerFactory.getLogger(Manejador.class);
	final static String emazePeople = "https://api.tvmaze.com/search/people?q=";
	final static String itunesPeople = "https://itunes.apple.com/search?term=";
	final static String itunesEpisodeShow = "https://itunes.apple.com/search?media=tvShow&term=";
	final static String emazeEpisodeShow = "https://api.tvmaze.com/singlesearch/shows?embed=episodes&q=";
	final static String serviceEmaze = "API  EMAZE";
	final static String serviceItunes = "API iTunes";
	RestTemplate template;

	public Manejador() {
		template = new RestTemplate();
		List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();
		MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
		converter.setSupportedMediaTypes(Collections.singletonList(MediaType.ALL));
		messageConverters.add(converter);
		template.setMessageConverters(messageConverters);

	}

	public List<Emaze> getEmaze(String value) {
		Emaze[] response = this.template.getForObject(emazePeople+value, Emaze[].class);
		return Arrays.asList(response);

	}
	
	public List<Itunes> getItunes(String value){
		Itunes response = this.template.getForObject(itunesPeople+value, Itunes.class);
		return Arrays.asList(response);
	}

	public List<Persona> combinarEmazeItunes(String name){
		
		List<Persona> resultado = new ArrayList<Persona>();
		
		getEmaze(name).forEach(item -> {
			resultado.add(new Persona(item.getPerson().getName(), null,"Persona", serviceEmaze , emazePeople+name));
		});
		
		getItunes(name).get(0).getResults().forEach(item -> {
			resultado.add(new Persona(item.getArtistName(),item.getTrackName(), item.getKind() , serviceItunes , itunesPeople+name ));
		});
		
		return resultado;
	}
		
	public List<ShowItunes> getShowItunes(String show){
		ShowItunes response = this.template.getForObject(itunesEpisodeShow+show, ShowItunes.class);
		return Arrays.asList(response);
	}
		
	public List<ShowEmaze> getShowEmaze(String show){
		ShowEmaze response = this.template.getForObject(emazeEpisodeShow+show, ShowEmaze.class);
		return Arrays.asList(response);
	}
	
	public List<TvShow> obtenerEpisodios(String show){
		
		List<TvShow> result = new ArrayList<TvShow>();
		
		getShowItunes(show).get(0).getResults().forEach(item -> {
			result.add(new  TvShow(item.getArtistName(), item.getTrackName(), item.getShortDescription(), item.getTrackViewUrl() , serviceItunes, itunesEpisodeShow+show));
		});

		
		getShowEmaze(show).get(0).get_embedded().getEpisodes().forEach(item-> {
			result.add( new TvShow(show, item.getName(), item.getSummary(), item.getUrl(), serviceEmaze, emazeEpisodeShow+show));
		});
		
		return result;
	}
	
}
