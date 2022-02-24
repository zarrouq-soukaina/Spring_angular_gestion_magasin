import { Produit } from "./produit";
import { Client } from "./client";
export class Commande {
    cmId!:string;
    dateCommande!: Date ;
    client :Client = new Client();  

}