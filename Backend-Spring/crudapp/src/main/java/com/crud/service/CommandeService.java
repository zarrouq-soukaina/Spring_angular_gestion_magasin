package com.crud.service;
import java.util.Date;
import java.util.Optional;
import java.util.Set;

import javax.management.AttributeNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import com.crud.model.Client;
import com.crud.model.Commande;
import com.crud.model.Produit;
import com.crud.repository.CommandeCrud;
import com.crud.model.Commande;
import com.crud.model.Commande;

@Service
public class CommandeService {
	@Autowired
	private CommandeCrud C ;
	public Commande createCommande(Commande cd) {
		Commande cm = new Commande();
		cm.setDateCommande(cd.getDateCommande());
		cm.setClient(cd.getClient());
		C.save(cm);
		return cm;
		}
	public  void deleteCommande(String cmId) {
		C.deleteById(cmId);
		System.out.println("suppression de Commande");
	}
	public Iterable<Commande> getAllCommandes() {
		return C.findAll();
	}

	public Optional<Commande> getCommandeById(String cmId)
			throws AttributeNotFoundException {
		return C.findById(cmId);
	}
	public Commande updateCommande(String cmId,Commande CommandeDetails) throws AttributeNotFoundException {
		Commande Commande = C.findById(cmId)
				.orElseThrow();

		Commande.setDateCommande(CommandeDetails.getDateCommande());
		Commande.setClient(CommandeDetails.getClient());
		
	
	
		
		final Commande updatedCommande = C.save(Commande);
		return updatedCommande;
	}
}
