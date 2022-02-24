import { Produit } from '../produit';
import { Component, OnInit, Input } from '@angular/core';
import { ProduitService } from '../produit.service';
import { ProduitListComponent } from '../produit-list/produit-list.component';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-produit-details',
  templateUrl: './produit-details.component.html',
  styleUrls: ['./produit-details.component.css']
})
export class ProduitDetailsComponent implements OnInit {

  pId!: String;
  produit!: Produit; 

  constructor(private route: ActivatedRoute,private router: Router,
    private produitService: ProduitService) { }

  ngOnInit() {
    this.produit = new Produit();

    this.pId = this.route.snapshot.params['pId'];
    
    this.produitService.getProduit(this.pId)
      .subscribe(data => {
        console.log(data)
        this.produit = data; 
      }, error => console.log(error));
  } 

  list(){
    this.router.navigate(['Produits']);
  }
}
