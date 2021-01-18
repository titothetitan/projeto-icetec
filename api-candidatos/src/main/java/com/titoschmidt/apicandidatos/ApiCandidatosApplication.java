package com.titoschmidt.apicandidatos;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.titoschmidt.apicandidatos.entities.Candidato;
import com.titoschmidt.apicandidatos.entities.Tecnologia;
import com.titoschmidt.apicandidatos.repositories.CandidatoRepository;
import com.titoschmidt.apicandidatos.repositories.TecnologiaRepository;

@SpringBootApplication
public class ApiCandidatosApplication implements CommandLineRunner {
	
	@Autowired
	private CandidatoRepository cr;
	@Autowired
	private TecnologiaRepository tr;

	public static void main(String[] args) {
		SpringApplication.run(ApiCandidatosApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		Tecnologia t1 = new Tecnologia(null, "C#");
		Tecnologia t2 = new Tecnologia(null, "Javascript");
		Tecnologia t3 = new Tecnologia(null, "Nodejs");
		Tecnologia t4 = new Tecnologia(null, "Angular");
		Tecnologia t5 = new Tecnologia(null, "React");
		Tecnologia t6 = new Tecnologia(null, "Ionic");  
		Tecnologia t7 = new Tecnologia(null, "Mensageria");
		Tecnologia t8 = new Tecnologia(null, "PHP");
		Tecnologia t9 = new Tecnologia(null, "Laravel");
		
		List<Tecnologia> tecnologiasTito = new ArrayList<>();
		List<Tecnologia> tecnologiasMaria = new ArrayList<>();
		List<Tecnologia> tecnologiasJoao = new ArrayList<>();
		List<Tecnologia> tecnologiasJose = new ArrayList<>();
		
		tecnologiasTito.add(t1);
		tecnologiasTito.add(t8);
		
		tecnologiasMaria.add(t1);
		tecnologiasMaria.add(t2);
		
		tecnologiasJoao.add(t1);
		tecnologiasJoao.add(t2);
		tecnologiasJoao.add(t8);
		
		tecnologiasJose.add(t3);
		tecnologiasJose.add(t4);
		
		Candidato c1 = new Candidato(null, "Tito", "tito.the.titan@gmail.com", 32, "url", tecnologiasTito);
		Candidato c2 = new Candidato(null, "Maria", "maria@gmail.com", 30, "url", tecnologiasMaria);
		Candidato c3 = new Candidato(null, "João", "joao@gmail.com", 40, "url", tecnologiasJoao);
		Candidato c4 = new Candidato(null, "José", "jose@gmail.com", 22, "url", tecnologiasJose);
		
		tr.save(t1);
		tr.save(t2);
		tr.save(t3);
		tr.save(t4);
		tr.save(t5);
		tr.save(t6);
		tr.save(t7);
		tr.save(t8);
		tr.save(t9);
		cr.save(c1);
		cr.save(c2);
		cr.save(c3);
		cr.save(c4);
	}
}
