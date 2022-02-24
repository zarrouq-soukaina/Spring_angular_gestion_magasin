import { CommandeProduitDetailsComponent } from '../commande-produit-details/commande-produit-details.component';
import { Observable } from "rxjs";
import { CommandeProduitService } from "../commande-produit.service";
import { CommandeProduit } from "../commandeProduit";
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
@Component({
  selector: 'app-commande-produit-list',
  templateUrl: './commande-produit-list.component.html',
  styleUrls: ['./commande-produit-list.component.css']
})
export class CommandeProduitListComponent implements OnInit {

  commandeProduits!: Observable<CommandeProduit[]>;

  constructor(private commandeProduitService: CommandeProduitService,
    private router: Router) {}

  ngOnInit() {
    this.reloadData();
  }

  reloadData() { 
    this.commandeProduits = this.commandeProduitService.getCommandeProduitsList();
  }

  dellCommandeProduit(id: String) {
    this.commandeProduitService.dellCommandeProduit(id)
      .subscribe(
        data => {
          console.log(data);
          this.reloadData();
        },
        error => console.log(error));
  }

  commandeProduitDetails(id: String){
    this.router.navigate(['detailsprodcom', id]);
  }
  updateCommandeProduit(id: String){
    this.router.navigate(['updateprodcom', id]);
  }

}
