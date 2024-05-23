package it.uniroma3.siw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import it.uniroma3.siw.model.Chef;
import it.uniroma3.siw.model.Credentials;
import it.uniroma3.siw.model.Recipe;
import it.uniroma3.siw.service.ChefService;
import it.uniroma3.siw.service.CredentialsService;
import it.uniroma3.siw.service.RecipeService;

@Controller
public class RecipeController {

	@Autowired
	private RecipeService recipeService;
	@Autowired
	private ChefService chefService;

	@Autowired
	private CredentialsService credentialsService;
	
	@GetMapping("/formNewRecipe")
    public String addNewRecipe(Model model) {
        model.addAttribute("recipe", new Recipe());
        return "formNewRecipe.html";
    }

	@GetMapping("/myRecipes")
	 public String showMyRecipes(Model model) {
		Chef chef = chefService.findByUsername(getUsernameFromSecurityContext());
		model.addAttribute("recipes", chef.getRecipes());
		return "recipes.html";
    }
	
	@GetMapping("/recipes")
	 public String showEveryRecipe(Model model) {
		model.addAttribute("recipes", recipeService.findAll());
		return "recipes.html";
	}
		
	@GetMapping("/recipes/{id}")
	public String getRecipe(@PathVariable("id") Long id, Model model) {
		model.addAttribute("recipe", this.recipeService.findById(id).get());
		return "recipe.html";
	}
	
	
	@PostMapping("/myRecipes")
    public String newRecipe(@ModelAttribute("recipe") Recipe recipe, Model model) {
        if (this.recipeService.existsByName(recipe.getName())) {
            model.addAttribute("messaggioDiErrore", "This recipe already exists");
            return "formNewRecipe.html";
        } else {
            Chef chef = chefService.findByUsername(getUsernameFromSecurityContext());
            if (chef != null) recipe.setChef(chef);
            this.recipeService.save(recipe);
            chef.getRecipes().add(recipe);
            return "redirect:myRecipes";        
            }
    }

    private String getUsernameFromSecurityContext() {
    	UserDetails userDetails = (UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    	//Credentials credentials = credentialsService.getCredentials(userDetails.getUsername());
        return credentialsService.getCredentials(userDetails.getUsername()).getUsername();
    }    
}
