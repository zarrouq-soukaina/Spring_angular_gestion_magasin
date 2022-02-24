import { Commande } from "./commande";

export class Facture {
    fId!:string;
    datefacture!:  Date;
    modePaiement!:  String;
    commandesfacture: Commande = new Commande; 
    
 
} 