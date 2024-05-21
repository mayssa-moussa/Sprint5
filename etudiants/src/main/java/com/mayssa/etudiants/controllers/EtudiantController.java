package com.mayssa.etudiants.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.mayssa.etudiants.entities.Etudiant;
import com.mayssa.etudiants.service.EtudiantService;

@Controller
public class EtudiantController {
	@Autowired
	EtudiantService etudiantService;

	@RequestMapping("/ListeEtudiants")
	public String listeProduits(ModelMap modelMap, @RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "3") int size) {
		Page<Etudiant> etuds = etudiantService.getAllEtudiantsParPage(page, size);
		modelMap.addAttribute("etudiants", etuds);
		modelMap.addAttribute("pages", new int[etuds.getTotalPages()]);
		modelMap.addAttribute("currentPage", page);
		return "listeEtudiants";
	}

	@RequestMapping("/showCreate")
	public String showCreate() {
		return "createEtudiant";
	}

	@RequestMapping("/saveEtudiant")
	public String saveEtudiant(@ModelAttribute("etudiant") Etudiant etudiant, @RequestParam("date") String date,
			ModelMap modelMap) throws ParseException {
//conversion de la date
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
		Date dateNaiss = dateformat.parse(String.valueOf(date));
		etudiant.setDateNaiss(dateNaiss);

		Etudiant saveEtudiant = etudiantService.saveEtudiant(etudiant);
		String msg = "Etudiant enregistré avec Id " + saveEtudiant.getIdEtudiant();
		modelMap.addAttribute("msg", msg);
		return "createEtudiant";
	}

	@RequestMapping("/supprimerEtudiant")
	public String supprimerEtudiant(@RequestParam("id") Long id, ModelMap modelMap,
			@RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "2") int size) {
		etudiantService.deleteEtudiantById(id);
		Page<Etudiant> etuds = etudiantService.getAllEtudiantsParPage(page, size);
		modelMap.addAttribute("etudiants", etuds);
		modelMap.addAttribute("pages", new int[etuds.getTotalPages()]);
		modelMap.addAttribute("currentPage", page);
		modelMap.addAttribute("size", size);
		return "listeEtudiants";
	}

	@RequestMapping("/modifierEtudiant")
	public String editerProduit(@RequestParam("id") Long id, ModelMap modelMap) {
		Etudiant e = etudiantService.getEtudiant(id);
		modelMap.addAttribute("etudiant", e);
		return "editerEtudiant";
	}

	@RequestMapping("/updateEtudiant")
	public String updateEtudiant(@ModelAttribute("etudiant") Etudiant etudiant, @RequestParam("date") String date,
			ModelMap modelMap) throws ParseException {
//conversion de la date
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
		Date dateNaiss = dateformat.parse(String.valueOf(date));
		etudiant.setDateNaiss(dateNaiss);

		etudiantService.updateEtudiant(etudiant);
		List<Etudiant> etuds = etudiantService.getAllEtudiants();
		modelMap.addAttribute("etudiants", etuds);
		return "listeEtudiants";
	}
}
