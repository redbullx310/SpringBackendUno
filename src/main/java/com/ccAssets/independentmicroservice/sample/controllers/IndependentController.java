package com.ccAssets.independentmicroservice.sample.controllers;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ccAssets.independentmicroservice.sample.IndependentEntity;
import com.ccAssets.independentmicroservice.sample.IndependentEntityRepository;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class IndependentController {
	
	@Autowired
	private IndependentEntityRepository repo;
	
	@GetMapping("/independentEntity")
	public Collection<IndependentEntity> getAllEntities(){
		return repo.findAll();
	}
	
	@GetMapping("/independentEntity/{id}")
	public ResponseEntity<IndependentEntity> getIndependentEntity(@PathVariable Long id){
		Optional<IndependentEntity> result = repo.findById(id);
		return result.map(response -> ResponseEntity.ok().body(response))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
	
	@PostMapping("/independentEntity")
	public ResponseEntity<IndependentEntity> createIndependentEntity(@Valid @RequestBody IndependentEntity entity) throws URISyntaxException{
		IndependentEntity result = repo.save(entity);
		return ResponseEntity.created(new URI("/independentEntity/"+result.getId())).body(result);
	}
	
	@PutMapping("/independentEntity/{id}")
	public ResponseEntity<IndependentEntity> updateEntity(@Valid @RequestBody IndependentEntity entity){
		IndependentEntity result = repo.save(entity);
		return ResponseEntity.ok().body(result);
	}
	
	@DeleteMapping("/independentEntity/{id}")
	public ResponseEntity<IndependentEntity> deleteEntity(@PathVariable Long id){
		repo.deleteById(id);
		return ResponseEntity.ok().build();
	}

}
