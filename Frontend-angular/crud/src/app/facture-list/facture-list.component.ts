import { FactureDetailsComponent } from '../facture-details/facture-details.component';
import { Observable } from "rxjs";
import { FactureService } from "../facture.service";
import { Facture } from "../facture";
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
@Component({
  selector: 'app-facture-list',
  templateUrl: './facture-list.component.html',
  styleUrls: ['./facture-list.component.css']
})
export class FactureListComponent implements OnInit {

  factures!: Observable<Facture[]>;

  constructor(private factureService: FactureService,
    private router: Router) {}

  ngOnInit() {
    this.reloadData(); 
  }

  reloadData() { 
    this.factures = this.factureService.getFacturesList();
  }

  dellFacture(fId: String) {
    this.factureService.dellFacture(fId)
      .subscribe(
        data => {
          console.log(data);
          this.reloadData();
        },
        error => console.log(error));
  }

  factureDetails(fId: String){
    this.router.navigate(['detailsfact', fId]);
  }
  updateFacture(fId: String){
    this.router.navigate(['updatefact', fId]);
  }

}
