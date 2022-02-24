import { Facture } from '../facture';
import { Component, OnInit, Input } from '@angular/core';
import { FactureService } from '../facture.service';
import { FactureListComponent } from '../facture-list/facture-list.component';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-facture-details',
  templateUrl: './facture-details.component.html',
  styleUrls: ['./facture-details.component.css']
})
export class FactureDetailsComponent implements OnInit {

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

  list(){
    this.router.navigate(['Factures']);
  }
}
