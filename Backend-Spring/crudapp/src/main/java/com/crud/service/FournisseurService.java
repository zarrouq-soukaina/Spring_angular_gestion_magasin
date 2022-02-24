package com.crud.service;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.management.AttributeNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import com.crud.model.Commande;
import com.crud.model.Fournisseur;
import com.crud.repository.FournisseurCrud;

@Service
public class FournisseurService {
	@Autowired
	private FournisseurCrud F ;
	public Fournisseur createFournisseur(Fournisseur fr) {
		Fournisseur frn = new Fournisseur();
		frn.setNom(fr.getNom());
		frn.setPrenom(fr.getPrenom());
		frn.setAdresse(fr.getAdresse());
		frn.setTel(fr.getTel());
		
		F.save(frn);
		return frn;
	}
	public  void deleteFournisseur(String frId) {
		F.deleteById(frId);
		System.out.println("suppression de fournisseur");
		
	}public Iterable<Fournisseur> getAllFournisseurs() {
		return F.findAll();
	}

	public Optional<Fournisseur> getFournisseurById(String frId)
			throws AttributeNotFoundException {
		return F.findById(frId);
	}
	public Fournisseur updateFournisseur(String pId,
			Fournisseur FournisseurDetails) throws AttributeNotFoundException {
		Fournisseur Fournisseur = F.findById(pId)
				.orElseThrow();

		Fournisseur.setNom(FournisseurDetails.getNom());
		Fournisseur.setPrenom(FournisseurDetails.getPrenom());
		Fournisseur.setAdresse(FournisseurDetails.getAdresse());
		Fournisseur.setTel(FournisseurDetails.getTel());
		
	
		
		final Fournisseur updatedFournisseur = F.save(Fournisseur);
		return updatedFournisseur;
	}
}
