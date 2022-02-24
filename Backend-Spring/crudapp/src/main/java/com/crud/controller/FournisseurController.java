package com.crud.controller;

import java.util.List;

import javax.management.AttributeNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.crud.model.Fournisseur;
import com.crud.model.Fournisseur;

import com.crud.service.FournisseurService;
@RestController
public class FournisseurController {
	@Autowired
	private FournisseurService fournisseurService ;
	@RequestMapping(value = "/add/fournisseur", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Fournisseur addFournisseur(@Validated @RequestBody Fournisseur fournisseur)
			
			 {
		return fournisseurService.createFournisseur(fournisseur);
	}
	@RequestMapping(value = "/dell/Fournisseur/{frId}",method = RequestMethod.DELETE)
	public String dellFournisseur(@PathVariable("frId") String frId) {
		fournisseurService.deleteFournisseur(frId);
		return "Fournisseur supprimé avec succès ";
		
	}
	@GetMapping("/Fournisseurs")
	public Iterable<com.crud.model.Fournisseur> getAllFournisseurs() {
		return fournisseurService.getAllFournisseurs();
	}

	@GetMapping("/Fournisseurs/{id}")
	public ResponseEntity<Fournisseur> getFournisseurById(@PathVariable(value = "id") String frId)
			throws AttributeNotFoundException {
		Fournisseur Fournisseur =fournisseurService.getFournisseurById(frId)
				.orElseThrow();
		return ResponseEntity.ok().body(Fournisseur);
	}
	@PutMapping("/fournisseurs/update/{id}")
	public ResponseEntity<Fournisseur> updateFournisseur(@PathVariable(value = "id") String frId,
			@Validated @RequestBody Fournisseur fournisseurDetails) throws AttributeNotFoundException {
		Fournisseur updatedFournisseur = fournisseurService.updateFournisseur(frId, fournisseurDetails);
		return ResponseEntity.ok(updatedFournisseur);
	}
	
}
