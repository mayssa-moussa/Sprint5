package com.mayssa.etudiants.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.mayssa.etudiants.entities.Groupe;

@RepositoryRestResource(path="gp")
@CrossOrigin("http://localhost:4200/") //pour autoriser angular
public interface GroupeRepository extends JpaRepository<Groupe, Long>{

}
