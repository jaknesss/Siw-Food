package it.uniroma3.it.model;

import java.util.Date;
import java.util.Objects;

import org.springframework.stereotype.Controller;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Chef {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private String surname;
	private Date birthDate;
	//private String profilePic;
	
	public String getName() {
		return name;
	}
	public String getSurname() {
		return surname;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(birthDate, name, surname);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Chef other = (Chef) obj;
		return Objects.equals(birthDate, other.birthDate) && Objects.equals(name, other.name)
				&& Objects.equals(surname, other.surname);
	}

}
