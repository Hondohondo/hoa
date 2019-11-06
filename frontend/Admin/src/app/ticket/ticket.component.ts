/**
 * Ticket class that handles all functionality behind the Ticket component.
 */
import { Component, OnInit } from '@angular/core';
import { HOAService } from '../hoa.service';
import { Ticket } from '../Ticket';
import { TicketPost } from '../TicketPost';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-ticket',
  templateUrl: './ticket.component.html',
  styleUrls: ['./ticket.component.css']
})
export class TicketComponent implements OnInit {

  tickets: Ticket[]; //Holds an array of Ticket objects.
  headers = ["ticketId", "name", "subject", "createdDate"]; //variable is used to create the table headers in the HTML for this component.
  intakeForm: FormGroup; //Represents the FormGroup used to send a ticket back to the API.
  isOpen : boolean = false; //Currently not used.

  /**
   * A TicketPost object names ticket. Will be used to send a ticket back to API.
   */
  ticket: TicketPost = {
    ticketMessage:'',
    subject:'',
    email:'',
    phoneNumber:'',
    name:''
  }

  /**
   * Creates a formGroup using a FormBuilder, fb.
   * Adds validators to each input elements and monitors input submissions.
   */
  constructor(public HOAService : HOAService, private fb: FormBuilder) {
    this.intakeForm = fb.group({
      ticketMessage: ['', Validators.required],
      subject: ['', Validators.required],
      email:['', Validators.required],
      phoneNumber:['', Validators.required],
      name:['', Validators.required]
    })
   }

  ngOnInit() {
    
  }

  /**
   * Method calls getAllTickets() from HOAService class then grabs the API's JSON response and populates the tickets[] with the data.
   */
  getAllTickets(){
    this.HOAService.getAllTickets()
      .subscribe((data)=>{
        console.log(data);
        this.tickets=data['tickets'];
        console.log(this.tickets);
      });
  }

  /**
   * Methods calls the addTicket() from HOASerive with an the input as a value of the intakeForm.
   * After the ticket is send. The method resets all data fields in the intakeForms.
   * A alert is sent to the user to notify that the ticket is sent.
   */
  addNewTicket(){
    // this.ticket.ticketMessage = this.ticketMessage.value;
    // this.ticket.email='';
    // this.ticket.name='';
    // this.ticket.subject='';
    // this.ticket.phoneNumber=''; 
    // this.HOAService.addTicket(this.ticket);
    this.HOAService.addTicket(this.intakeForm.value)
    .subscribe(data => {
      console.log(data);
      this.intakeForm.reset();
    });
    alert("Thanks for submitting a ticket!");
    console.warn(this.intakeForm.value);
  }
}
