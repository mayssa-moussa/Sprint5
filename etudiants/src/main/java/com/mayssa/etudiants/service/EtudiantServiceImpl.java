package com.mayssa.etudiants.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.mayssa.etudiants.entities.Etudiant;
import com.mayssa.etudiants.entities.Groupe;
import com.mayssa.etudiants.repos.EtudiantRepository;

@Service
public class EtudiantServiceImpl implements EtudiantService {
	
	@Autowired
	EtudiantRepository etudiantRepository;

	@Override
	public Etudiant saveEtudiant(Etudiant e) {
		return etudiantRepository.save(e);
	}

	@Override
	public Etudiant updateEtudiant(Etudiant e) {
		return etudiantRepository.save(e);
	}

	@Override
	public void deleteEtudiant(Etudiant e) {
		etudiantRepository.delete(e);
		
	}

	@Override
	public void deleteEtudiantById(Long id) {
		etudiantRepository.deleteById(id);
		
	}

	@Override
	public Etudiant getEtudiant(Long id) {
		return etudiantRepository.findById(id).get();
	}

	@Override
	public List<Etudiant> getAllEtudiants() {
		return etudiantRepository.findAll();
	}

	@Override
	public Page<Etudiant> getAllEtudiantsParPage(int page, int size) {
		return etudiantRepository.findAll(PageRequest.of(page, size));
	}

	@Override
	public List<Etudiant> findByNom(String nom) {
		return etudiantRepository.findByNom(nom);	}

	@Override
	public List<Etudiant> findByNomContains(String nom) {
		return etudiantRepository.findByNomContains(nom);
	}

	@Override
	public List<Etudiant> findByNomPrenom(String nom, String prenom) {
		return etudiantRepository.findByNomPrenom(nom, prenom);
	}

	@Override
	public List<Etudiant> findByGroupe(Groupe groupe) {
		return etudiantRepository.findByGroupe(groupe);
	}

	@Override
	public List<Etudiant> findByGroupeIdGroupe(Long id) {
		return etudiantRepository.findByGroupeIdGroupe(id);
	}

	@Override
	public List<Etudiant> findByOrderByNomAsc() {
		return etudiantRepository.findByOrderByNomAsc();
	}

	@Override
	public List<Etudiant> trierEtudiantsNomsPrenom() {
		return etudiantRepository.trierEtudiantsNomDateNaiss();
	}

}
