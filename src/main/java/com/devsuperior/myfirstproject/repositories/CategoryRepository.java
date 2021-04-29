package com.devsuperior.myfirstproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devsuperior.myfirstproject.entities.Category;

/**
 * 
 * @author emersonsouza
 *O @component seria no caso a parte de injeção de dependencia
 *do spring boot
 */
@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>{
	
	
}