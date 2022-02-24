package com.crud.model;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
@Entity
public class CommandeProduit {
	
	@Id
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	private String Id;
	
	
	@ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "produit_id")
    Produit produitcmd;
	
	
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "commande_id")
    Commande commandecmd;

    private int qteCom;
    private int prix;
    
    @Override
	public String toString() {
		return "CommandeProduit [Id=" + Id + ", produitcmd=" + produitcmd + ", commandecmd=" + commandecmd + ", qteCom="
				+ qteCom + ", prix=" + prix + "]";
	}
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public Produit getProduitcmd() {
		return produitcmd;
	}
	public void setProduitcmd(Produit produitcmd) {
		this.produitcmd = produitcmd;
	}
	public Commande getCommandecmd() {
		return commandecmd;
	}
	public void setCommande(Commande commandecmd) {
		this.commandecmd = commandecmd;
	}
	public int getQteCom() {
		return qteCom;
	}
	public void setQteCom(int qteCom) {
		this.qteCom = qteCom;
	}
	public int getPrix() {
		return prix;
	}
	public void setPrix(int prix) {
		this.prix = prix;
	}
    
    
}
