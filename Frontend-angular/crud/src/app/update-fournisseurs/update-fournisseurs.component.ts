import { Component, OnInit } from '@angular/core';
import { Fournisseur } from '../fournisseur';
import { ActivatedRoute, Router } from '@angular/router';
import { FournisseurService } from '../fournisseur.service';


@Component({
  selector: 'app-update-fournisseurs',
  templateUrl: './update-fournisseurs.component.html',
  styleUrls: ['./update-fournisseurs.component.css']
})
export class UpdateFournisseurComponent implements OnInit {

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

  updateFournisseur() {
    this.fournisseurService.updateFournisseur(this.frId, this.fournisseur)
      .subscribe(data => {
        console.log(data);
        this.fournisseur = new Fournisseur();
        this.gotoList();
      }, error => console.log(error));
  } 

  onSubmit() {
    this.updateFournisseur();     
  }

  gotoList() {
    this.router.navigate(['/Fournisseurs']);
  }
}
