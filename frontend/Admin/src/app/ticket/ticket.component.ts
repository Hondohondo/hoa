import { Component, OnInit } from '@angular/core';
import { HOAService } from '../hoa.service';
import { Ticket } from '../Ticket';

@Component({
  selector: 'app-ticket',
  templateUrl: './ticket.component.html',
  styleUrls: ['./ticket.component.css']
})
export class TicketComponent implements OnInit {

  tickets: any[];

  constructor(public HOAService : HOAService) { }

  ngOnInit() {
  }

  getAllTickets(){
    this.HOAService.getAllTickets()
      .subscribe((data) => {
        console.log(data);
        if(typeof data === "string"){
          alert("fuck");
        }
        this.tickets = data['tickets'];
        console.log(this.tickets);
      })
  }







  
  printArray(){
    console.log(this.tickets[0]);
    // if(typeof this.tickets === "string"){
    //   alert("string!");
    // }
  }
}
