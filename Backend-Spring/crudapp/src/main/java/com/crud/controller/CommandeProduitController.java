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
import com.crud.model.CommandeProduit;
import com.crud.model.Produit;

import com.crud.service.CommandeProduitService;

@RestController
public class CommandeProduitController {
	@Autowired
	private CommandeProduitService commandeProduitService ;
	
	@GetMapping("/CommandeProduits")
	public Iterable<com.crud.model.CommandeProduit> getAllCommandeProduits() {
		return commandeProduitService.getAllCommandeProduits();
	}

	@GetMapping("/CommandeProduits/{id}")
	public ResponseEntity<CommandeProduit> getCommandeProduitByid(@PathVariable(value = "id") String id)
			throws AttributeNotFoundException {
		CommandeProduit CommandeProduit =commandeProduitService.getCommandeProduitById(id)
				.orElseThrow();
		return ResponseEntity.ok().body(CommandeProduit);}
	
	
	@RequestMapping(value = "/add/commandeProduit", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public CommandeProduit addCommandeProduit(@Validated @RequestBody CommandeProduit commandeProduit)
			
			 {
		return commandeProduitService.createCommandeProduit(commandeProduit);
	}
	
	
       
	@RequestMapping(value = "/dell/CommandeProduit/{id}", method = RequestMethod.DELETE)
	public String dellCommandeProduit(@PathVariable("id") String id) {
		commandeProduitService.deleteCommandeProduit(id);
		return "CommandeProduit supprimé avec succès ";
		
	}
	@PutMapping("/commandeProduits/update/{id}")
	public ResponseEntity<CommandeProduit> updateCommandeProduit(@PathVariable(value = "id") String id,
			@Validated @RequestBody CommandeProduit commandeProduitDetails) throws AttributeNotFoundException {
		CommandeProduit updatedCommandeProduit = commandeProduitService.updateCommandeProduit(id, commandeProduitDetails);
		return ResponseEntity.ok(updatedCommandeProduit);
	}
	
	
}
