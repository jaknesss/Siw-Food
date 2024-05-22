package it.uniroma3.siw.model;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;


@Entity
public class Chef {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private String surname;
	private String username;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dateOfBirth;
	
	@OneToMany(mappedBy = "chef")
	private List<Recipe> recipes;
	private String imagePath;
	
	public String getName() { return name; }
	public String getSurname() { return surname; }
	public LocalDate getBirthDate() { return dateOfBirth; }
	public String getImagePath() { return imagePath; }
	public String getUsername() { return username; }
	public List<Recipe> getRecipes() { return recipes; }
	public void setRecipes(List<Recipe> recipes) { this.recipes = recipes; }
	public void setUsername(String username) { this.username = username; }
	public void setName(String name) { this.name = name; }
	public void setSurname(String surname) { this.surname = surname; }
	public void setBirthDate(LocalDate dateOfBirth) { this.dateOfBirth = dateOfBirth; }
	public void setImagePath(String imagePath) { this.imagePath = imagePath; }
	@Override
	public int hashCode() { return Objects.hash(dateOfBirth, name, surname); }
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		Chef other = (Chef) obj;
		return Objects.equals(dateOfBirth, other.dateOfBirth) && 
			   Objects.equals(name, other.name) && 
			   Objects.equals(surname, other.surname);
	}

}
