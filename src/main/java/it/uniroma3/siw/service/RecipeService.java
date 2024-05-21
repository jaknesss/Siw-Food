package it.uniroma3.siw.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.uniroma3.siw.model.Recipe;
import it.uniroma3.siw.repository.RecipeRepository;

@Service 
public class RecipeService {
	@Autowired
	private RecipeRepository recipeRepository;
	public Iterable<Recipe> findAll() { return recipeRepository.findAll(); }	
	public Boolean existsByName(String name) { return recipeRepository.existsByName(name); } 
	public Recipe save(Recipe recipe) { return this.recipeRepository.save(recipe);}

}
	
