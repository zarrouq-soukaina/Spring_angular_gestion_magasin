package com.crud.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Facture {
	@Id
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	private String fId;
	private Date datefacture;
	private String modePaiement;

	
    @ManyToOne
	@JoinColumn(name = "commande_id", nullable = false)
	private Commande commandesfacture;

	

	public Commande getCommandesfacture() {
		return commandesfacture;
	}

	public void setCommandesfacture(Commande commandesfacture) {
		this.commandesfacture = commandesfacture;
	}

	public String getfId() {
		return fId;
	}

	public void setfId(String fId) {
		this.fId = fId;
	}

	public Date getDatefacture() {
		return datefacture;
	}

	public void setDatefacture(Date datefacture) {
		this.datefacture = datefacture;
	}

	public String getModePaiement() {
		return modePaiement;
	}

	public void setModePaiement(String modePaiement) {
		this.modePaiement = modePaiement;
	}

	@Override
	public String toString() {
		return "Facture [fId=" + fId + ", datefacture=" + datefacture + ", modePaiement=" + modePaiement
				+ ", commandesfacture=" + commandesfacture + "]";
	}
	

}
