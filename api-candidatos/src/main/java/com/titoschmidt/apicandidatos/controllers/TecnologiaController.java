package com.titoschmidt.apicandidatos.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.titoschmidt.apicandidatos.entities.Candidato;
import com.titoschmidt.apicandidatos.entities.Tecnologia;
import com.titoschmidt.apicandidatos.repositories.CandidatoRepository;
import com.titoschmidt.apicandidatos.repositories.TecnologiaRepository;

@RestController
@RequestMapping(value="/tecnologias")
public class TecnologiaController {
	
	@Autowired
	private TecnologiaRepository tecnologiaRepository;

	// BUSCAR
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<Tecnologia>> findAll() {
		List<Tecnologia> lista = tecnologiaRepository.findAll();
		return ResponseEntity.ok().body(lista);
	}
}
