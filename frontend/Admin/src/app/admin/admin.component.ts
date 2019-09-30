import { Component, OnInit } from '@angular/core';
import { HOAService } from '../hoa.service';
import { Ticket } from '../Ticket';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {

  tickets: Ticket[];
  headers = ["ticketId", "name", "subject", "createdDate"];

  constructor(public HOAService : HOAService) { }

  ngOnInit() {
    this.getAllTickets();
  }

  getAllTickets(){
    this.HOAService.getAllTickets()
      .subscribe((data)=>{
        console.log(data);
        this.tickets=data['tickets'];
        console.log(this.tickets);
      });
  }
}
