import { FournisseurDetailsComponent } from '../fournisseur-details/fournisseur-details.component';
import { Observable } from "rxjs";
import { FournisseurService } from "../fournisseur.service";
import { Fournisseur } from "../fournisseur";
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
@Component({
  selector: 'app-fournisseur-list',
  templateUrl: './fournisseur-list.component.html',
  styleUrls: ['./fournisseur-list.component.css']
})
export class FournisseurListComponent implements OnInit {

  fournisseurs!: Observable<Fournisseur[]>;

  constructor(private fournisseurService: FournisseurService,
    private router: Router) {}

  ngOnInit() {
    this.reloadData(); 
  }

  reloadData() { 
    this.fournisseurs = this.fournisseurService.getFournisseursList();
  }

  dellFournisseur(frId: String) {
    this.fournisseurService.dellFournisseur(frId)
      .subscribe(
        data => {
          console.log(data);
          this.reloadData();
        },
        error => console.log(error));
  }

  fournisseurDetails(frId: String){
    this.router.navigate(['detailsfour', frId]);
  }
  updateFournisseur(frId: String){
    this.router.navigate(['updatefour', frId]);
  }

}
