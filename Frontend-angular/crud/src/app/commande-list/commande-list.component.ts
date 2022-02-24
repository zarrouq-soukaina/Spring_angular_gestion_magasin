import { CommandeDetailsComponent } from '../commande-details/commande-details.component';
import { Observable } from "rxjs";
import { CommandeService } from "../commande.service";
import { Commande } from "../commande";
import { ClientService } from '../client.service';
import { Client } from '../client';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
@Component({
  selector: 'app-commande-list',
  templateUrl: './commande-list.component.html',
  styleUrls: ['./commande-list.component.css']
})
export class CommandeListComponent implements OnInit {

  commandes!: Observable<Commande[]>;

  constructor(private commandeService: CommandeService,
    private router: Router) {}

  ngOnInit() {
    this.reloadData();
  }

  reloadData() { 
    this.commandes = this.commandeService.getCommandesList();
  }

  dellCommande(cmId: String) {
    this.commandeService.dellCommande(cmId)
      .subscribe(
        data => {
          console.log(data);
          this.reloadData();
        },
        error => console.log(error));
  }

  commandeDetails(cmId: String){
    this.router.navigate(['detailscom', cmId]);
  }

}
