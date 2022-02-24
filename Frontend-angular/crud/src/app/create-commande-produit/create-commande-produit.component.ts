import { Component, OnInit } from '@angular/core';
import { CommandeProduitService } from '../commande-produit.service';
import { Router } from '@angular/router';
import { CommandeProduit } from '../commandeProduit';

@Component({
  selector: 'app-create-commande-produit',
  templateUrl: './create-commande-produit.component.html',
  styleUrls: ['./create-commande-produit.component.css']
})
export class CreateCommandeProduitComponent implements OnInit {
  submitted = false;
  commandeProduit: CommandeProduit = new CommandeProduit();

  constructor(private commandeProduitService: CommandeProduitService,
    private router: Router) { }
  

  ngOnInit(): void {
  }
 

  newCommandeProduit(): void {
    this.submitted = false;
    this.commandeProduit = new CommandeProduit();
  }

  save() {
    this.commandeProduitService
    .addCommandeProduit(this.commandeProduit).subscribe(data => {
      console.log(data)
      this.commandeProduit = new CommandeProduit();
      this.gotoList();
    }, 
    error => console.log(error));
  }

  onSubmit() {
    this.submitted = true;
    this.save();    
  }

  gotoList() {
    this.router.navigate(['/CommandeProduits']);
  }

}

