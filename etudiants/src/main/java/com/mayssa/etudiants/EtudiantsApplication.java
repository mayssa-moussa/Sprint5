package com.mayssa.etudiants;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import com.mayssa.etudiants.entities.Etudiant;
import com.mayssa.etudiants.entities.Groupe;
import com.mayssa.etudiants.service.EtudiantService;

@SpringBootApplication
public class EtudiantsApplication implements CommandLineRunner{
	
	@Autowired
	EtudiantService etudiantService;

	@Autowired
	private RepositoryRestConfiguration repositoryRestConfiguration;
	
	public static void main(String[] args) {
		SpringApplication.run(EtudiantsApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
	repositoryRestConfiguration.exposeIdsFor(Etudiant.class,Groupe.class);
	}

	/*@Override
	public void run(String... args) throws Exception {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date dateNaiss = null;
        try {
            dateNaiss = dateFormat.parse("14/07/2003");
        } catch (ParseException e) {
            e.printStackTrace();
        }
		 etudiantService.saveEtudiant(new Etudiant("abidi","ahmed",dateNaiss,"bizerte","ahmed.abidi@gmail.com",2022,"GC"));
		 etudiantService.saveEtudiant(new Etudiant("makhlouf","sami",dateNaiss,"nabeul","sami@gmail.com",2023,"IT"));
		 etudiantService.saveEtudiant(new Etudiant("sfia","salma",dateNaiss,"tunis","salma@gmail.com",2024,"DM"));
		
	}*/

}
