package com.crud.service;
import java.util.Optional;

import javax.management.AttributeNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;
import com.crud.model.Client;
import com.crud.repository.ClientCrud;

@Service
public class ClientService {
	@Autowired
	private ClientCrud C ;
	public Client createClient(Client cln) {
		Client cl = new Client();
		cl.setNom(cln.getNom());
		cl.setPrenom(cln.getPrenom());
		cl.setAdresse(cln.getAdresse());
		cl.setTel(cln.getTel());
		C.save(cl);
		return cl;
		}
	public  void deleteClient(String cId) {
		C.deleteById(cId);
		System.out.println("suppression de Client");
	}
	public Iterable<Client> getAllClients() {
		return C.findAll();
	}

	public Optional<Client> getClientById(String cId)
			throws AttributeNotFoundException {
		return C.findById(cId);
	}
	public Client updateClient(String cId,
			Client ClientDetails) throws AttributeNotFoundException {
		Client Client = C.findById(cId)
				.orElseThrow();

		Client.setNom(ClientDetails.getNom());
		Client.setPrenom(ClientDetails.getPrenom());
		Client.setAdresse(ClientDetails.getAdresse());
		Client.setTel(ClientDetails.getTel());
		//Client.setCommandes(ClientDetails.getCommandes());
		
		final Client updatedClient = C.save(Client);
		return updatedClient;
	}
}
