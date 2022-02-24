import { Produit } from "./produit";

import { Commande } from "./commande";
export class CommandeProduit {
    id!:string;
    prix!: number ;
    qteCom!: number;
    produitcmd : Produit = new Produit();
    commandecmd : Commande = new Commande();
 
}