import { CommandeProduit } from '../commandeProduit';
import { Component, OnInit, Input } from '@angular/core';
import { CommandeProduitService } from '../commande-produit.service';
import { CommandeProduitListComponent } from '../commande-produit-list/commande-produit-list.component';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-commande-produit-details',
  templateUrl: './commande-produit-details.component.html',
  styleUrls: ['./commande-produit-details.component.css']
})
export class CommandeProduitDetailsComponent implements OnInit {

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

  list(){
    this.router.navigate(['CommandeProduits']);
  }
}
