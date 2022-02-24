import { Component, OnInit } from '@angular/core';
import { Facture } from '../facture';
import { ActivatedRoute, Router } from '@angular/router';
import { FactureService } from '../facture.service';


@Component({
  selector: 'app-update-facture',
  templateUrl: './update-facture.component.html',
  styleUrls: ['./update-facture.component.css']
})
export class UpdateFactureComponent implements OnInit {

  fId!: String;
  facture!: Facture;

  constructor(private route: ActivatedRoute,private router: Router,
    private factureService: FactureService) { }

  ngOnInit() {
    this.facture = new Facture();

    this.fId = this.route.snapshot.params['fId'];
    
    this.factureService.getFacture(this.fId)
      .subscribe(data => {
        console.log(data)
        this.facture = data;
      }, error => console.log(error));
  }

  updateFacture() {
    this.factureService.updateFacture(this.fId, this.facture)
      .subscribe(data => {
        console.log(data);
        this.facture = new Facture();
        this.gotoList();
      }, error => console.log(error));
  } 

  onSubmit() {
    this.updateFacture();     
  }

  gotoList() {
    this.router.navigate(['/Factures']);
  }
}
