package com.titoschmidt.apicandidatos.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.titoschmidt.apicandidatos.entities.Candidato;
import com.titoschmidt.apicandidatos.repositories.CandidatoRepository;

@RestController
@RequestMapping(value="/candidatos")
public class CandidatoController {
	
	@Autowired
	private CandidatoRepository candidatoRepository;
	
	//INSERIR
	@PostMapping
	public Candidato save(@RequestBody Candidato candidato) {
		return candidatoRepository.save(candidato);
	}
	
	// BUSCAR
	@GetMapping(value = "/{id}")
	public ResponseEntity<Candidato> findById(@PathVariable Long id) {
		Candidato candidato = candidatoRepository.findById(id).get();
		return ResponseEntity.ok().body(candidato);
	}
	
	//ATUALIZAR
	@PutMapping(value="/{id}")
	public ResponseEntity update(@PathVariable("id") long id, @RequestBody Candidato candidato) {
	   return candidatoRepository.findById(id)
	           .map(record -> {
	               record.setNome(candidato.getNome());
	               record.setEmail(candidato.getEmail());
	               record.setIdade(candidato.getIdade());
	               record.setUrl(candidato.getUrl());
	               Candidato updated = candidatoRepository.save(record);
	               return ResponseEntity.ok().body(updated);
	           }).orElse(ResponseEntity.notFound().build());
	}
	
	//EXCLUIR
	@DeleteMapping(path ={"/{id}"})
	public ResponseEntity<Object> delete(@PathVariable long id) {
	   return candidatoRepository.findById(id)
	           .map(record -> {
	        	   candidatoRepository.deleteById(id);
	               return ResponseEntity.ok().build();
	           }).orElse(ResponseEntity.notFound().build());
	}
	
	// LISTAR
	@GetMapping 
	public ResponseEntity<List<Candidato>> findAll() { 
		List<Candidato> list = candidatoRepository.findAll();  		
		return ResponseEntity.ok().body(list);
	}
}
