package it.uniroma3.siw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import it.uniroma3.siw.model.Recipe;
import it.uniroma3.siw.service.RecipeService;

@Controller
public class RecipeController {

	@Autowired
	private RecipeService recipeService;
	
	@GetMapping("/recipes")
	public String getRecipes(Model model) {
		model.addAttribute("recipes", recipeService.findAll());
		return "recipes.html";
	}
	
	@GetMapping("/formNewRecipe")
	public String addNewRecipe(Model model) {
		model.addAttribute("recipe", new Recipe());
		return "formNewRecipe.html";
	}
	
	
    @PostMapping("/recipes")
    public String newRecipe(@ModelAttribute("recipe")Recipe recipe, Model model) {
         if(this.recipeService.existsByName(recipe.getName())) {
        	 model.addAttribute("messaggioDiErrore", "This recipe already exists");
        	 return "formNewRecipe.html";
         } else {
        	 this.recipeService.save(recipe);
        	 return "redirect:recipes";
         }
    }
	
}
