import { Component, OnInit } from '@angular/core';
import { Produit } from '../produit';
import { ActivatedRoute, Router } from '@angular/router';
import { ProduitService } from '../produit.service';


@Component({
  selector: 'app-update-produit',
  templateUrl: './update-produit.component.html',
  styleUrls: ['./update-produit.component.css']
})
export class UpdateProduitComponent implements OnInit {

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

  updateProduit() {
    this.produitService.updateProduit(this.pId, this.produit)
      .subscribe(data => {
        console.log(data);
        this.produit = new Produit();
        this.gotoList();
      }, error => console.log(error));
  } 

  onSubmit() {
    this.updateProduit();     
  }

  gotoList() {
    this.router.navigate(['/Produits']);
  }
}
