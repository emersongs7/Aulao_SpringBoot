package com.devsuperior.myfirstproject.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.myfirstproject.entities.Category;
import com.devsuperior.myfirstproject.repositories.CategoryRepository;

@RestController	//Define que essa classe será um recurso REST
@RequestMapping(value = "/categories") // Define o caminho pelo qual esse recurso vai responder
public class CategoryResource {
	
	/**
	Essa anotação @Autowired faz um pré processamento por debaixo dos panos e ele já resolve a depencia pra vc
	pra isso funcionar vc precisa colocar o @componente no CategoryRepository
	 */
	
	@Autowired 
	private CategoryRepository categoryRepository;

	@GetMapping // para que o metodo seja um ENDPOINT da aplicação que vai responder por uma requisição GET do HTTP
	public ResponseEntity<List<Category>> findAll() {
		
		List<Category> list = categoryRepository.findAll();		
		return ResponseEntity.ok().body(list);
		//esse .ok() seria um metodo que retorna uma resposta 200
	}

	@GetMapping(value = "/{id}") // para retornar 1 unico objeto
	public ResponseEntity<Category> findById(@PathVariable Long id) {
		Category cat = categoryRepository.findById(id).get();
		return ResponseEntity.ok().body(cat); 
	
	}
	 
}
