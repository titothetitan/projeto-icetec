package com.titoschmidt.apicandidatos.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.titoschmidt.apicandidatos.entities.Candidato;
import com.titoschmidt.apicandidatos.repositories.CandidatoRepository;
import com.titoschmidt.apicandidatos.services.CandidatoService;

@RestController
@RequestMapping(value="/candidatos")
public class CandidatoController {
	
	@Autowired
	private CandidatoService service;
	
	//INSERIR
	@RequestMapping(method=RequestMethod.POST)
	public Candidato save(@RequestBody Candidato candidato) {
		return service.insert(candidato);
	}
	
	// BUSCAR
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Candidato> findById(@PathVariable Integer id) {
		Candidato candidato = service.find(id).get();
		return ResponseEntity.ok().body(candidato);
	}
	
	//ATUALIZAR
	/**/
	
	//EXCLUIR
	@RequestMapping(path="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Object> delete(@PathVariable int id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	// LISTAR
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<Candidato>> findAll() { 
		List<Candidato> list = service.findAll();  		
		return ResponseEntity.ok().body(list);
	}
}
