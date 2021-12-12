package com.example.practica1.service;



import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.practica1.Manejador;
import com.example.practica1.Persona;
import com.example.practica1.ShowEmaze;
import com.example.practica1.ShowItunes;
import com.example.practica1.TvShow;


@RestController
@RequestMapping("/rest")
public class MusicLibrary {
	
	Manejador temporal = new Manejador();

	@GetMapping(path="/find/{name}")
	public List<Persona> searchByName(@PathVariable("name") String name) {
		return temporal.combinarEmazeItunes(name);
	}
	
	@GetMapping(path="/find/tvshow/{name}")
	public List<TvShow> getTvShow(@PathVariable("name") String name){
		return temporal.obtenerEpisodios(name);
	}
	
	
	
}
