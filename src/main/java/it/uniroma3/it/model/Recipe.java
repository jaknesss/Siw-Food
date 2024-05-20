package it.uniroma3.it.model;

import java.util.Map;

import org.springframework.stereotype.Controller;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Recipe {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	//private Map<Ingredient, Integer> ingredients;
	private String desc;
	private Chef chef;
	
}

