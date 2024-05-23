package it.uniroma3.siw.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.uniroma3.siw.model.Chef;
import it.uniroma3.siw.repository.ChefRepository;

@Service
public class ChefService {
	 @Autowired
	 private ChefRepository chefRepository;
	
	 public Iterable<Chef> findAll() { return chefRepository.findAll(); }
	 public Chef findByUsername(String username) { return chefRepository.findByUsername(username); }
	 public Optional<Chef> findById(Long id) { return chefRepository.findById(id); }
	 public Chef findByNameAndSuername(String name, String surname) {return chefRepository.findByNameAndSurname(name, surname);}
	 public Chef saveChef(Chef chef) { return chefRepository.save(chef); }
}
