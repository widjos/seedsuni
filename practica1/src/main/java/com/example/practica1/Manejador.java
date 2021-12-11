package com.example.practica1;

import java.lang.reflect.Array;
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
	RestTemplate template;

	public Manejador() {
		template = new RestTemplate();

	}

	public List<Emaze> servicioEmaze(String value) {

		List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();
		MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
		converter.setSupportedMediaTypes(Collections.singletonList(MediaType.ALL));
		messageConverters.add(converter);
		template.setMessageConverters(messageConverters);

		String url = "https://api.tvmaze.com/search/people?q="+ value;
		logger.debug("Por aqui si paso");
		Emaze[] response = this.template.getForObject(url, Emaze[].class);

		return Arrays.asList(response);

	}

}
