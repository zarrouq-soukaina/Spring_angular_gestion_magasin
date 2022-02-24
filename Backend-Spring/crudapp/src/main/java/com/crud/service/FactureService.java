package com.crud.service;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.management.AttributeNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import com.crud.model.Commande;
import com.crud.model.Facture;
import com.crud.repository.FactureCrud;
import com.crud.model.Facture;
import com.crud.model.Facture;




@Service
public class FactureService {
	@Autowired
	private FactureCrud F ;
	public Facture createFacture(Facture fc) {
		Facture fct = new Facture();
		fct.setDatefacture(fc.getDatefacture());
		fct.setModePaiement(fc.getModePaiement());
		fct.setCommandesfacture(fc.getCommandesfacture());
		F.save(fct);
		return fct;
	}
	public  void deleteFacture(String fId) {
		F.deleteById(fId);
		System.out.println("suppression de facture");
		
	}public Iterable<Facture> getAllFactures() {
		return F.findAll();
	}

	public Optional<Facture> getFactureById(String fId)
			throws AttributeNotFoundException {
		return F.findById(fId);
	}
	public Facture updateFacture(String pId,
			Facture FactureDetails) throws AttributeNotFoundException {
		Facture Facture = F.findById(pId)
				.orElseThrow();

		Facture.setDatefacture(FactureDetails.getDatefacture());
		Facture.setModePaiement(FactureDetails.getModePaiement());
		Facture.setCommandesfacture(FactureDetails.getCommandesfacture());
		
	
		
		final Facture updatedFacture = F.save(Facture);
		return updatedFacture;
	}
}
