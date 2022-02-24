import { Component, OnInit } from '@angular/core';
import { Client } from '../client';
import { ActivatedRoute, Router } from '@angular/router';
import { ClientService } from '../client.service';


@Component({
  selector: 'app-update-client',
  templateUrl: './update-client.component.html',
  styleUrls: ['./update-client.component.css']
})
export class UpdateClientComponent implements OnInit {

  cId!: String;
  client!: Client;

  constructor(private route: ActivatedRoute,private router: Router,
    private clientService: ClientService) { }

  ngOnInit() {
    this.client = new Client();

    this.cId = this.route.snapshot.params['cId'];
    
    this.clientService.getClient(this.cId)
      .subscribe(data => {
        console.log(data)
        this.client = data;
      }, error => console.log(error));
  }

  updateClient() {
    this.clientService.updateClient(this.cId, this.client)
      .subscribe(data => {
        console.log(data);
        this.client = new Client();
        this.gotoList();
      }, error => console.log(error));
  } 

  onSubmit() {
    this.updateClient();     
  }

  gotoList() {
    this.router.navigate(['/Clients']);
  }
}
