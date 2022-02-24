package com.crud.controller;


import java.util.List;

import javax.management.AttributeNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.crud.model.Produit;
import com.crud.service.ProduitService;


@RestController
public class ProduitController {
	@Autowired
	private ProduitService produitService;

	@GetMapping("/Produits")
	public Iterable<com.crud.model.Produit> getAllProduits() {
		return produitService.getAllProduits();
	}

	@GetMapping("/Produits/get/{pId}")
	public ResponseEntity<Produit> getProduitById(@PathVariable(value = "pId") String pId)
			throws AttributeNotFoundException {
		Produit Produit = produitService.getProduitById(pId).orElseThrow();
		return ResponseEntity.ok().body(Produit);
	}

	@RequestMapping(value = "/add/prodit", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Produit addProduit(@Validated @RequestBody Produit produit)
			
			 {
		return produitService.createProduit(produit);
	}

	@RequestMapping(value = "/dell/produit/{pId}", method = RequestMethod.DELETE)
	public String dellProduit(@PathVariable("pId") String pId) {
		produitService.deleteProduit(pId);
		return "Produit supprimé avec succès ";

	}

	@PutMapping("/produits/update/{pId}")
	public ResponseEntity<Produit> updateProduit(@PathVariable(value = "pId") String pId,
			@Validated @RequestBody Produit produitDetails) throws AttributeNotFoundException {
		Produit updatedProduit = produitService.updateProduit(pId, produitDetails);
		return ResponseEntity.ok(updatedProduit);
	}

}
