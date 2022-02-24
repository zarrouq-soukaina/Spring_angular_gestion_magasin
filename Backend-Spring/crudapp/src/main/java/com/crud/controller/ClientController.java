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
import com.crud.model.Client;
import com.crud.model.Client;
import com.crud.service.ClientService;
@RestController
public class ClientController {
	@Autowired
	private ClientService clientService ;
	@RequestMapping(value = "/add/client", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Client addClient(@Validated @RequestBody Client client)
			
			 {
		return clientService.createClient(client);
	}
	@RequestMapping(value = "/dell/Client/{cId} ", method = RequestMethod.DELETE)
	public String dellClient(@PathVariable("cId") String cId) {
		clientService.deleteClient(cId);
		return "Client supprimé avec succès ";
		
	}
	@GetMapping("/Clients")
	public Iterable<com.crud.model.Client> getAllClients() {
		return clientService.getAllClients();
	}

	@GetMapping("/Clients/{id}")
	public ResponseEntity<Client> getClientById(@PathVariable(value = "id") String cId)
			throws AttributeNotFoundException {
		Client Client =clientService.getClientById(cId)
				.orElseThrow();
		return ResponseEntity.ok().body(Client);
	}
	@PutMapping("/clients/update/{id}")
	public ResponseEntity<Client> updateClient(@PathVariable(value = "id") String cId,
			@Validated @RequestBody Client clientDetails) throws AttributeNotFoundException {
		Client updatedClient = clientService.updateClient(cId, clientDetails);
		return ResponseEntity.ok(updatedClient);
	}
	
}
