package com.crud.controller;
import java.util.Date;
import java.util.List;
import java.util.Set;

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

import com.crud.model.Client;
import com.crud.model.Commande;


import com.crud.service.CommandeService;

@RestController
public class CommandeController {
	@Autowired
	private CommandeService commandeService ;
	
	@GetMapping("/Commandes")
	public Iterable<com.crud.model.Commande> getAllCommandes() {
		return commandeService.getAllCommandes();
	}

	@GetMapping("/Commandes/{cmId}")
	public ResponseEntity<Commande> getCommandeById(@PathVariable(value = "cmId") String cmId)
			throws AttributeNotFoundException {
		Commande Commande =commandeService.getCommandeById(cmId)
				.orElseThrow();
		return ResponseEntity.ok().body(Commande);}
	@RequestMapping(value = "/add/commande", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Commande addCommande(@Validated @RequestBody Commande commande)
			
			 {
		return commandeService.createCommande(commande);
	}
	
       
	@RequestMapping(value = "/dell/Commande/{cmId}", method = RequestMethod.DELETE)
	public String dellCommande(@PathVariable("cmId") String cmId) {
		commandeService.deleteCommande(cmId);
		return "Commande supprimé avec succès ";
		
	}
	@PutMapping("/commandes/update/{id}")
	public ResponseEntity<Commande> updateCommande(@PathVariable(value = "id") String cmId,
			@Validated @RequestBody Commande commandeDetails) throws AttributeNotFoundException {
		Commande updatedCommande = commandeService.updateCommande(cmId, commandeDetails);
		return ResponseEntity.ok(updatedCommande);
	}
	
	
}
