package com.mayssa.etudiants.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Groupe {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long idGroupe;
private String nomGroupe;
@OneToMany(mappedBy = "groupe")
@JsonIgnore
private List<Etudiant> etudiants;
public Long getIdGroupe() {
	return idGroupe;
}
public void setIdGroupe(Long idGroupe) {
	this.idGroupe = idGroupe;
}

}
