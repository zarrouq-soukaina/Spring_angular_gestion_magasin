package com.crud.controller;
import java.util.Date;
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

import com.crud.model.Facture;
import com.crud.model.Commande;
import com.crud.model.Facture;
import com.crud.model.Produit;
import com.crud.service.FactureService;
import com.crud.service.ProduitService;
@RestController
public class FactureController {
	@Autowired
	private FactureService factureService ;
	@RequestMapping(value = "/add/facture", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Facture addFacture(@Validated @RequestBody Facture facture)
			
			 {
		return factureService.createFacture(facture);
	}
	@RequestMapping(value = "/dell/Facture/{fId}", method = RequestMethod.DELETE)
	public String dellFacture(@PathVariable("fId") String fId) {
		factureService.deleteFacture(fId);
		return "Facture supprimé avec succès ";
		}
	
	@GetMapping("/Factures")
	public Iterable<com.crud.model.Facture> getAllFactures() {
		return factureService.getAllFactures();
	}

	@GetMapping("/Factures/{fId}")
	public ResponseEntity<Facture> getFactureById(@PathVariable(value = "fId") String fId)
			throws AttributeNotFoundException {
		Facture Facture =factureService.getFactureById(fId)
				.orElseThrow();
		return ResponseEntity.ok().body(Facture);
	}
	@PutMapping("/factures/update/{id}")
	public ResponseEntity<Facture> updateFacture(@PathVariable(value = "id") String fId,
			@Validated @RequestBody Facture factureDetails) throws AttributeNotFoundException {
		Facture updatedFacture = factureService.updateFacture(fId, factureDetails);
		return ResponseEntity.ok(updatedFacture);
	}
	
}
