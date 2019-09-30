import { Component, OnInit } from '@angular/core';
import { HOAService } from '../hoa.service';
import { Ticket } from '../Ticket';
import { TicketPost } from '../TicketPost';

@Component({
  selector: 'app-ticket',
  templateUrl: './ticket.component.html',
  styleUrls: ['./ticket.component.css']
})
export class TicketComponent implements OnInit {

  tickets: Ticket[];
  headers = ["ticketId", "name", "subject", "createdDate"];

  ticket: TicketPost = {
    ticketMessage:'',
    subject:'',
    email:'',
    phoneNumber:'',
    name:''
  }

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

  addNewTicket(){
    this.ticket.ticketMessage ='';
    this.ticket.email='';
    this.ticket.name='';
    this.ticket.subject='';
    this.ticket.phoneNumber=''; 
    this.HOAService.addTicket(this.ticket);
  }
}
