package it.uniroma3.siw.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.uniroma3.siw.model.Ingredient;
import it.uniroma3.siw.repository.IngredientRepository;

@Service
public class IngredientService {
	
	@Autowired 
	public IngredientRepository ingredientRepository;
	public Iterable<Ingredient> findAll() { return ingredientRepository.findAll(); }
	
}
