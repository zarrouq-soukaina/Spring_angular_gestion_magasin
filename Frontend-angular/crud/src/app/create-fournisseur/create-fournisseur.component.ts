import { FournisseurService } from '../fournisseur.service';
import { Fournisseur } from '../fournisseur';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
@Component({
  selector: 'app-create-fournisseur',
  templateUrl: './create-fournisseur.component.html',
  styleUrls: ['./create-fournisseur.component.css']
})
export class CreateFournisseurComponent implements OnInit {

  fournisseur: Fournisseur = new Fournisseur();
  submitted = false;

  constructor(private fournisseurService: FournisseurService,
    private router: Router) { }

  ngOnInit() {
  }

  newFournisseur(): void {
    this.submitted = false;
    this.fournisseur = new Fournisseur();
  }

  save() {
    this.fournisseurService
    .addFournisseur(this.fournisseur).subscribe(data => {
      console.log(data)
      this.fournisseur = new Fournisseur();
      this.gotoList();
    }, 
    error => console.log(error));
  }

  onSubmit() {
    this.submitted = true;
    this.save();    
  }

  gotoList() {
    this.router.navigate(['/Fournisseurs']);
  }

}
