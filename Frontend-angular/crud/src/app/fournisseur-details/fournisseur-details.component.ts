import { Fournisseur } from '../fournisseur';
import { Component, OnInit, Input } from '@angular/core';
import { FournisseurService } from '../fournisseur.service';
import { FournisseurListComponent } from '../fournisseur-list/fournisseur-list.component';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-fournisseur-details',
  templateUrl: './fournisseur-details.component.html',
  styleUrls: ['./fournisseur-details.component.css']
})
export class FournisseurDetailsComponent implements OnInit {

  frId!: String;
  fournisseur!: Fournisseur; 

  constructor(private route: ActivatedRoute,private router: Router,
    private fournisseurService: FournisseurService) { }

  ngOnInit() {
    this.fournisseur = new Fournisseur();

    this.frId = this.route.snapshot.params['frId'];
    
    this.fournisseurService.getFournisseur(this.frId)
      .subscribe(data => {
        console.log(data)
        this.fournisseur = data;
      }, error => console.log(error));
  }

  list(){
    this.router.navigate(['Fournisseurs']);
  }
}
