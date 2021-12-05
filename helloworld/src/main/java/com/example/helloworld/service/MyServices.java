package com.example.helloworld.service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/myservices")
public class MyServices {
	
	@GetMapping(path="/helloworld/{name}")
	public String holaMundo(@PathVariable("name") String name) {
		return "Hola " + name + " , \nBienvenido a Spring Boot 4";
	}

}
