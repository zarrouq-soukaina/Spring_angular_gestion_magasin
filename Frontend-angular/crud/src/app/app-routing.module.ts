import { ProduitDetailsComponent } from './produit-details/produit-details.component';
import { CreateProduitComponent } from './create-produit/create-produit.component';
import { FournisseurDetailsComponent } from './fournisseur-details/fournisseur-details.component';
import { CreateFournisseurComponent } from './create-fournisseur/create-fournisseur.component';
import { ClientDetailsComponent } from './client-details/client-details.component';
import { CreateClientComponent } from './create-client/create-client.component';
import { CommandeDetailsComponent } from './commande-details/commande-details.component';
import { CreateCommandeComponent } from './create-commande/create-commande.component';
import { CommandeProduitDetailsComponent } from './commande-produit-details/commande-produit-details.component';
import { CreateCommandeProduitComponent } from './create-commande-produit/create-commande-produit.component';
import { FactureDetailsComponent } from './facture-details/facture-details.component';
import { CreateFactureComponent } from './create-facture/create-facture.component';


import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms'; 
import { ReactiveFormsModule } from '@angular/forms';
import { Routes, RouterModule } from '@angular/router';
import { ProduitListComponent } from './produit-list/produit-list.component';
import { FournisseurListComponent } from './fournisseur-list/fournisseur-list.component';
import { ClientListComponent } from './client-list/client-list.component';
import { CommandeListComponent } from './commande-list/commande-list.component';
import { CommandeProduitListComponent } from './commande-produit-list/commande-produit-list.component';
import { UpdateProduitComponent } from './update-produit/update-produit.component';
import { UpdateClientComponent } from './update-client/update-client.component';
import { UpdateFournisseurComponent } from './update-fournisseurs/update-fournisseurs.component';
import { FactureListComponent } from './facture-list/facture-list.component';


import { CommonModule } from '@angular/common';
import { UpdateFactureComponent } from './update-facture/update-facture.component';
import { UpdateCommandeProduitComponent } from './update-commande-produit/update-commande-produit.component';

const routes: Routes = [
  { path: '', redirectTo: 'produit', pathMatch: 'full' },

  { path: 'Produits', component: ProduitListComponent },
  { path: 'addproduit', component: CreateProduitComponent },
  { path: 'updateprod/:pId', component: UpdateProduitComponent },
  { path: 'detailsprod/:pId', component: ProduitDetailsComponent },

  { path: 'Fournisseurs', component: FournisseurListComponent }, 
  { path: 'addfour', component: CreateFournisseurComponent },
  { path: 'updatefour/:frId', component: UpdateFournisseurComponent }, 
  { path: 'detailsfour/:frId', component: FournisseurDetailsComponent },

  { path: 'Clients', component: ClientListComponent },
  { path: 'addclient', component: CreateClientComponent },
  { path: 'detailsclient/:cId', component: ClientDetailsComponent },
  { path: 'updateclient/:cId', component: UpdateClientComponent },

  { path: 'Commandes', component: CommandeListComponent },
  { path: 'addcom', component: CreateCommandeComponent },
 
  { path: 'detailscom/:cmId', component: CommandeDetailsComponent },

  { path: 'CommandeProduits', component: CommandeProduitListComponent },
  { path: 'addprodcom', component: CreateCommandeProduitComponent },
  { path: 'updateprodcom/:id', component: UpdateCommandeProduitComponent },
  { path: 'detailsprodcom/:id', component: CommandeProduitDetailsComponent },

  { path: 'Factures', component: FactureListComponent },
  { path: 'addfact', component: CreateFactureComponent },
  { path: 'updatefact/:fId', component: UpdateFactureComponent },
  { path: 'detailsfact/:fId', component: FactureDetailsComponent },


];

@NgModule({
  imports: [RouterModule.forRoot(routes),
    CommonModule,
    FormsModule,
    ReactiveFormsModule],
  exports: [RouterModule]
})
export class AppRoutingModule { }
