package it.uniroma3.siw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import it.uniroma3.siw.service.ChefService;


@Controller
public class ChefController {

	@Autowired
	private ChefService chefService;
	
	@GetMapping("/chefs")
	public String showChefs(Model model) {
		model.addAttribute("chefs", chefService.findAll());
		return "chefs.html";
	}
	
	@GetMapping("/chefs/{id}")
	public String getChef(@PathVariable("id") Long id, Model model) {
		model.addAttribute("chef", chefService.findById(id).get());
		return "chef.html";
	}
	
	
	
}
