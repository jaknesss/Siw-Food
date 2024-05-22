package it.uniroma3.siw.model;

import java.util.List;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;


@Entity
public class Recipe {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	private String name;
	private String imagePath;
	
	
	@Column(length = 2000)
	private String description;
	
	@ManyToOne
	private Chef chef;
	
	@OneToMany
	private List<Ingredient> ingredients;
	
	public Long getId() { return id; }
	public String getName() { return name; }
	public Chef getChef() { return chef; }
	public String getDescription() { return description; }
	public List<Ingredient> getIngredients() { return ingredients; }
	public String getImagePath() { return imagePath; }
	public void setImagePath(String imagePath) { this.imagePath = imagePath; }
	public void setName(String name) { this.name = name; }	
	public void setDescription(String description) { this.description = description; }
	public void setChef(Chef chef) { this.chef = chef;}
	public void setIngredients(List<Ingredient> ingredients) { this.ingredients = ingredients; }
	
	@Override
	public int hashCode() { return Objects.hash(chef, description, ingredients, name); }
	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		Recipe other = (Recipe) obj;
		return Objects.equals(ingredients, other.ingredients) && 
			   Objects.equals(name, other.name);
	}
	
	
	
}

