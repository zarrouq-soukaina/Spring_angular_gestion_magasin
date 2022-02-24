import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CreateProduitComponent } from './create-produit/create-produit.component';
import { ProduitDetailsComponent } from './produit-details/produit-details.component';
import { ProduitListComponent } from './produit-list/produit-list.component';
import { HttpClientModule } from '@angular/common/http';
import { UpdateProduitComponent } from './update-produit/update-produit.component';
import { CreateFournisseurComponent } from './create-fournisseur/create-fournisseur.component';
import { FournisseurDetailsComponent } from './fournisseur-details/fournisseur-details.component';
import { FournisseurListComponent } from './fournisseur-list/fournisseur-list.component';
import { CreateClientComponent } from './create-client/create-client.component';
import { ClientDetailsComponent } from './client-details/client-details.component';
import { ClientListComponent } from './client-list/client-list.component';
import { CreateCommandeComponent } from './create-commande/create-commande.component';
import { CommandeDetailsComponent } from './commande-details/commande-details.component';
import { CommandeListComponent } from './commande-list/commande-list.component';
import { CreateCommandeProduitComponent } from './create-commande-produit/create-commande-produit.component';
import { CommandeProduitDetailsComponent } from './commande-produit-details/commande-produit-details.component';
import { CommandeProduitListComponent } from './commande-produit-list/commande-produit-list.component';
import { FactureDetailsComponent } from './facture-details/facture-details.component';
import { FactureListComponent } from './facture-list/facture-list.component';
import { CreateFactureComponent } from './create-facture/create-facture.component';
import { UpdateClientComponent } from './update-client/update-client.component';
import { UpdateFournisseurComponent } from './update-fournisseurs/update-fournisseurs.component';
import { UpdateFactureComponent } from './update-facture/update-facture.component';
import { ReactiveFormsModule } from '@angular/forms';
import { UpdateCommandeProduitComponent } from './update-commande-produit/update-commande-produit.component';
@NgModule({
  declarations: [
    AppComponent,
    CreateProduitComponent,
    ProduitDetailsComponent,
    ProduitListComponent,
    UpdateProduitComponent,
    CreateFournisseurComponent,
    FournisseurDetailsComponent,
    FournisseurListComponent,
    CreateClientComponent,
    ClientDetailsComponent,
    ClientListComponent,
    CreateCommandeComponent,
    CommandeDetailsComponent,
    CommandeListComponent,
    CreateCommandeProduitComponent,
    CommandeProduitDetailsComponent,
    CommandeProduitListComponent,
    FactureDetailsComponent,
    FactureListComponent,
    CreateFactureComponent,
    UpdateClientComponent,
    UpdateFournisseurComponent,
    UpdateFactureComponent,
    UpdateCommandeProduitComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }