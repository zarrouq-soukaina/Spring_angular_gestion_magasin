package com.crud.service;
import java.util.Date;
import java.util.Optional;
import java.util.Set;

import javax.management.AttributeNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;


import com.crud.model.Commande;
import com.crud.model.CommandeProduit;
import com.crud.model.Produit;
import com.crud.repository.CommandeProduitCrud;
import com.crud.repository.ProduitCrud;


@Service
public class CommandeProduitService {
	@Autowired
	private CommandeProduitCrud C ;
	private ProduitCrud P ;
	public CommandeProduit createCommandeProduit(CommandeProduit cp) {
		CommandeProduit cm = new CommandeProduit();
		cm.setCommande(cp.getCommandecmd());
		
		cm.setProduitcmd(cp.getProduitcmd());
		cm.setQteCom(cp.getQteCom());
		cm.setPrix(cp.getPrix());
		//int b = cm.getQteCom();
		
        String a = cm.getProduitcmd().getpId();
		//Optional<Produit> aa = P.findById(a);
		//int g = aa.get().getPrix() ;
		//cm.setPrix(g*a);
		C.save(cm);
		return cm; 
		}
	public  void deleteCommandeProduit(String cmId) {
		C.deleteById(cmId);
		System.out.println("suppression de CommandeProduit");
	}
	public Iterable<CommandeProduit> getAllCommandeProduits() {
		return C.findAll();
	}

	public Optional<CommandeProduit> getCommandeProduitById(String cmId)
			throws AttributeNotFoundException {
		return C.findById(cmId);
	}
	public CommandeProduit updateCommandeProduit(String cmId,CommandeProduit CommandeProduitDetails) throws AttributeNotFoundException {
		CommandeProduit CommandeProduit = C.findById(cmId)
				.orElseThrow();

		CommandeProduit.setCommande(CommandeProduitDetails.getCommandecmd());
		CommandeProduit.setProduitcmd(CommandeProduitDetails.getProduitcmd());
		CommandeProduit.setPrix(CommandeProduitDetails.getPrix());
		CommandeProduit.setQteCom(CommandeProduitDetails.getQteCom());
		
		final CommandeProduit updatedCommandeProduit = C.save(CommandeProduit);
		return updatedCommandeProduit;
	}
}
