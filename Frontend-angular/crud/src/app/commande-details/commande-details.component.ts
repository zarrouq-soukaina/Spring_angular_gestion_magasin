import { Commande } from '../commande';
import { Component, OnInit, Input } from '@angular/core';
import { CommandeService } from '../commande.service';
import { CommandeListComponent } from '../commande-list/commande-list.component';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-commande-details',
  templateUrl: './commande-details.component.html',
  styleUrls: ['./commande-details.component.css']
})
export class CommandeDetailsComponent implements OnInit {

  cmId!: String;
  commande!: Commande; 

  constructor(private route: ActivatedRoute,private router: Router,
    private commandeService: CommandeService) { }

  ngOnInit() {
    this.commande = new Commande();

    this.cmId = this.route.snapshot.params['cmId'];
    
    this.commandeService.getCommande(this.cmId)
      .subscribe(data => {
        console.log(data)
        this.commande = data;
      }, error => console.log(error));
  }

  list(){
    this.router.navigate(['Commandes']);
  }
}
