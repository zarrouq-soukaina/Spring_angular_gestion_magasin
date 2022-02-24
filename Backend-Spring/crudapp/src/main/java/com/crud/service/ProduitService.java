package com.crud.service;
import java.util.List;
import java.util.Optional;

import javax.management.AttributeNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;
import com.crud.model.Produit;
import com.crud.repository.ProduitCrud;

@Service
public class ProduitService {
	@Autowired
	private ProduitCrud P ;
	public Produit createProduit(Produit pr) {
		Produit prd = new Produit();
		prd.setDesignation(pr.getDesignation());
		prd.setPrix(pr.getPrix() );
		prd.setTva(pr.getTva());
		P.save(prd);
		return prd;
		}
	public  void deleteProduit(String pId) {
		P.deleteById(pId);
		System.out.println("suppression de produite");
		
	}public Iterable<Produit> getAllProduits() {
		return P.findAll();
	}

	public Optional<Produit> getProduitById(String pId)
			throws AttributeNotFoundException {
		return P.findById(pId);
	}
	public Produit updateProduit(String pId,
			Produit ProduitDetails) throws AttributeNotFoundException {
		Produit Produit = P.findById(pId)
				.orElseThrow();

		Produit.setDesignation(ProduitDetails.getDesignation());
		Produit.setPrix(ProduitDetails.getPrix());
		Produit.setTva(ProduitDetails.getTva());
		
		//Produit.setCommandes(ProduitDetails.getCommandes());
		
		final Produit updatedProduit = P.save(Produit);
		return updatedProduit;
	}
}