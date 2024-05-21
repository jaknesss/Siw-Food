package it.uniroma3.siw.model;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Ingredient {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private Long qnt;
	//private String image;
	
	public String getName() { return name; }
	
	public void setName(String name) { this.name = name; }
	
	public Long getQnt() { return qnt; }

	public void setQnt(Long qnt) { this.qnt = qnt; }
	
	@Override
	public int hashCode() { return Objects.hash(name); }
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		Ingredient other = (Ingredient) obj;
		return Objects.equals(name, other.name);
	}
}
