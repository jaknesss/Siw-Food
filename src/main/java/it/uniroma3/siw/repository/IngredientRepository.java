package it.uniroma3.siw.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.uniroma3.siw.model.Ingredient;


@Repository
public interface IngredientRepository extends CrudRepository<Ingredient, Long> {}
