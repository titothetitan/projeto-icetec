package com.titoschmidt.apicandidatos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.titoschmidt.apicandidatos.entities.Candidato;

@Repository
public interface CandidatoRepository extends JpaRepository<Candidato, Integer> {

}
