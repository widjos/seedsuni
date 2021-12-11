package com.example.practica1;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@JsonIgnoreProperties
public class Emaze  implements Serializable{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	private double score;
	private Person person;
	
	public Emaze() {
		
	}
	
	public Emaze(double score, Person person) {
		super();
		this.score = score;
		this.person = person;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}
	
	@Override
	public String toString() {
		return "Emaze [score=" + score + ", persona=" + person + "]";
	}


}
