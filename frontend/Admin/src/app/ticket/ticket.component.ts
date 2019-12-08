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

  intakeForm: FormGroup; //Represents the FormGroup used to send a ticket back to the API.
  submitted = false; //checks to see if intakeform has been submitted.

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
   * Returns an object reference to form group "Intake Form"
   */
  get f(){
    return this.intakeForm.controls;
  }
  /**
   * Methods calls the addTicket() from HOASerive with an the input as a value of the intakeForm.
   * After the ticket is send. The method resets all data fields in the intakeForms.
   * A alert is sent to the user to notify that the ticket is sent.
   */
  addNewTicket(){
    this.submitted = true;
    if(this.intakeForm.invalid){
      alert("Please fill in all fields with the correct responses");
      return;
    }
    if(this.intakeForm.invalid == false){
    this.HOAService.addTicket(this.intakeForm.value)
    .subscribe(data => {
      console.log(data);
      this.intakeForm.reset();
    });
    alert("Thanks for submitting a ticket!");
    console.warn(this.intakeForm.value);
  }
}
}
