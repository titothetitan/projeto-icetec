package com.titoschmidt.apicandidatos.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.titoschmidt.apicandidatos.entities.Candidato;
import com.titoschmidt.apicandidatos.repositories.CandidatoRepository;

@RestController
@RequestMapping(value="/candidatos")
public class CandidatoController {
	
	@Autowired
	private CandidatoRepository candidatoRepository;
	
	@GetMapping // ao inserir no navegador localhost:8080/candidatos, será chamada esta função
	public ResponseEntity<List<Candidato>> findAll() { //retorna uma lista de Candidatos
		List<Candidato> list = candidatoRepository.findAll();  		
		return ResponseEntity.ok().body(list); //informa uma resposta de código 200 (sucesso)
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Candidato> findById(@PathVariable Long id) { // PathVariable reconhece o /id 
		Candidato candidato = candidatoRepository.findById(id).get(); // retorna um candidato pelo id 
		return ResponseEntity.ok().body(candidato);
	}
}
