import { Component, OnInit } from '@angular/core';
import { CommandeProduit } from '../commandeProduit';
import { ActivatedRoute, Router } from '@angular/router';
import { CommandeProduitService } from '../commande-produit.service';

@Component({
  selector: 'app-update-commande-produit',
  templateUrl: './update-commande-produit.component.html',
  styleUrls: ['./update-commande-produit.component.css']
})
export class UpdateCommandeProduitComponent implements OnInit {

  id!: String;
  commandeProduit!: CommandeProduit;

  constructor(private route: ActivatedRoute,private router: Router,
    private commandeProduitService: CommandeProduitService) { }

  ngOnInit() {
    this.commandeProduit = new CommandeProduit();

    this.id = this.route.snapshot.params['id'];
    
    this.commandeProduitService.getCommandeProduit(this.id)
      .subscribe(data => {
        console.log(data)
        this.commandeProduit = data;
      }, error => console.log(error));
  }

  updateCommandeProduit() {
    this.commandeProduitService.updateCommandeProduit(this.id, this.commandeProduit)
      .subscribe(data => {
        console.log(data);
        this.commandeProduit = new CommandeProduit();
        this.gotoList();
      }, error => console.log(error));
  } 

  onSubmit() {
    this.updateCommandeProduit();     
  }

  gotoList() {
    this.router.navigate(['/CommandeProduits']);
  }
}
