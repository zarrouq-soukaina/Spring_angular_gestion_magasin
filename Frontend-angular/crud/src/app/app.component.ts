import { Component } from '@angular/core';
import { UUID } from 'angular2-uuid';
import { ActivatedRoute, Router } from '@angular/router';
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  constructor(private route: ActivatedRoute,private router: Router,
    ) { }
  title = 'crud';
  uuidValue!:string;
  generateUUID(){
    this.uuidValue=UUID.UUID();
    return this.uuidValue;

  }
  listF() {
    this.router.navigate(['/Factures']);
  }

}
