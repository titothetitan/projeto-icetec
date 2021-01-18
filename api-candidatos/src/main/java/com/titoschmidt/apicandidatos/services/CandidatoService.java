package com.titoschmidt.apicandidatos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.titoschmidt.apicandidatos.entities.Candidato;
import com.titoschmidt.apicandidatos.repositories.CandidatoRepository;

import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class CandidatoService {
	
	@Autowired
	private CandidatoRepository repo;

	public Optional<Candidato> find(Integer id) {
		Optional<Candidato> obj = repo.findById(id);
		return obj;
	}
	
	public Candidato insert(Candidato obj) {
		obj.setId(null);
		return repo.save(obj);
	}
		
	public void delete(Integer id) {
		find(id);	
		repo.deleteById(id);				
	}
	
	public List<Candidato> findAll() {
		return repo.findAll();
	}
}
