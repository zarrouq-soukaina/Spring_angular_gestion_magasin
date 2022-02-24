import { FactureService } from '../facture.service';
import { Facture } from '../facture';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
@Component({
  selector: 'app-create-facture',
  templateUrl: './create-facture.component.html',
  styleUrls: ['./create-facture.component.css']
})
export class CreateFactureComponent implements OnInit {

  facture: Facture = new Facture();
  submitted = false;

  constructor(private factureService: FactureService,
    private router: Router) { }

  ngOnInit() {
  }

  newFacture(): void {
    this.submitted = false;
    this.facture = new Facture();
  }

  save() {
    this.factureService
    .addFacture(this.facture).subscribe(data => {
      console.log(data)
      this.facture = new Facture();
      this.gotoList();
    }, 
    error => console.log(error));
  }

  onSubmit() {
    this.submitted = true;
    this.save();    
  }

  gotoList() {
    this.router.navigate(['/Factures']);
  }

}
