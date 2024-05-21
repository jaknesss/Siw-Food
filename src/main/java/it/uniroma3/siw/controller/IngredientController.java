package it.uniroma3.siw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import it.uniroma3.siw.service.IngredientService;

@Controller
public class IngredientController {
	
	@Autowired 
	private IngredientService ingredientRepository;
	
	@GetMapping("/ingredients")
	public String getIngredients(Model model) {
		model.addAttribute("ingredients", ingredientRepository.findAll());
		return "ingredients.html";
	}	
	
	
	
	
}

