package com.devsuperior.myfirstproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devsuperior.myfirstproject.entities.Product;

/**
 * 
 * @author emersonsouza
 *O @component seria no caso a parte de injeção de dependencia
 *do spring boot
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{
	
	
}