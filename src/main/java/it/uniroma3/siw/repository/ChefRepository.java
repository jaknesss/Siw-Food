package it.uniroma3.siw.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import it.uniroma3.siw.model.Chef;

public interface ChefRepository extends CrudRepository<Chef, Long> {
    
	@Query(value = "SELECT * FROM chef WHERE username = :username", nativeQuery=true)
	public Chef findByUsername(@Param("username") String username);
    
    public Chef findByNameAndSurname(String name, String surname);
}
