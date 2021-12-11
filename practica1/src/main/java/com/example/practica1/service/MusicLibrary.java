package com.example.practica1.service;



import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.practica1.Emaze;
import com.example.practica1.Manejador;
import com.example.practica1.Persona;


@RestController
@RequestMapping("/rest")
public class MusicLibrary {

	@GetMapping(path="/find/{name}")
	public List<Emaze> SearchByName(@PathVariable("name") String name) {
		Manejador temporal = new Manejador();
		return temporal.servicioEmaze(name);
	}
	
	
}
