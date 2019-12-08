/**
 * Functionality for admin component goes here.
 */
import { Component, OnInit, ViewChild, ElementRef, ChangeDetectionStrategy, ChangeDetectorRef } from '@angular/core';
import { HOAService } from '../hoa.service';
import { Ticket } from '../Ticket';
import { ScrollingModule } from '@angular/cdk/scrolling';
import { NgbModal, ModalDismissReasons, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Observable } from 'rxjs';
import { first } from 'rxjs/operators';
import { resolve } from 'url';

import { Member } from '../_auth_models/Member';
import { UserService } from '../_auth_services/user.service';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css'],
})

export class AdminComponent implements OnInit {
  tickets: Ticket[]; //Holds all ticket objects for API.
  modalForm: FormGroup; //modal intake formgroup
  ticketData: Ticket; //Ticket object that will represent a more informative version of a selected ticket.
  ticketUpdate: Ticket; //Ticket object that will be sent to API to update a ticket. 

  loading = false;//keeps track of when the page is loaded on initialization of the page.
  users: Member[] = []; //Holds information for the current user.

  modalRef: NgbModalRef; //Reference object to the modal object, used to open and close the modal.

  /**
   * All Ticket fields for the modal.
   */
  modalTicketName: any;
  modalTicketId: any;
  modalTicketDate: any;
  modalTicketMessage: any;
  modalTicketSubject: any;
  modalIsActive: any;
  modalTicketPhoneNumber: any;

  //headers for the Admin ticket table.
  headers = ["ticketId", "createdDate", "name", "subject", "isActive"];

/**
 * Constructor creates a formgroup called modalForm that has three fields.
 * @param HOAService -Service to access Ticket system requests to API
 * @param modalService - Object that handles events and actions of the modal.
 * @param fb - formbuilider that creates the modal intake form group.
 * @param userService - Service object that gives access to Member API requests.
 */
  constructor(public HOAService: HOAService, private modalService: NgbModal, private fb: FormBuilder,
    private userService: UserService, private cd: ChangeDetectorRef) {
    this.modalForm = fb.group({
      ticketMessage: ['', Validators.required],
      isActive: ['', Validators.required],
      ticketId: ['']
    })
  }
  /**
   * ngOnInit calls when the page is first loaded.
   * Grabs the information for the current user.
   * Also calls getAllTickets() which grabs all active tickets from the API to be used to create the Admin ticket table.
   */
  ngOnInit() {
    this.loading = true;
    this.getAllTickets();
  }
  /**
   * Method to grab all active tickets from the API and place these Ticket objects into the tickets array.
   */
  getAllTickets() {
    this.HOAService.getAllTickets()
      .subscribe((data) => {
        console.log(data);
        this.tickets = data['tickets'];
        //console.log(this.tickets);
      });
  };
  /**
   * Method to grab more details based on a given ticket id number. ticketData object holds the returned Ticket object.
   */
  async getSelectedTicket(id: number) {
    this.HOAService.getTicketById(id).subscribe(data => {
      this.ticketData = <Ticket>data;
      console.log(this.ticketData.name);
    });
    return;
  }
  
  /**
   * Method used to set all fields of the modalForm based on the attributes of ticketData (the selected ticket object by id).
   * Opens the modal using modalService.
   * content - represents the element (modal)
   * ticket - represents the ticket that is clicked on. Uses this ticket's id to grab more information about the ticket.
   */
  async getTicketInfo(content, ticket: Ticket) {
    this.HOAService.getTicketById(ticket.ticketId).subscribe(data => {
      this.ticketData = data;
      // console.log(data);
      // console.log(this.ticketData.message);
      this.modalTicketDate = this.ticketData.createdDate;
      //this.modalIsActive
      this.modalTicketMessage = this.ticketData.message;
      this.modalTicketId = this.ticketData.ticketId;
      this.modalTicketName = this.ticketData.name;
      this.modalTicketPhoneNumber = this.ticketData.phoneNumber;
      this.modalTicketSubject = this.ticketData.subject;
      this.modalService.open(content, { ariaLabelledBy: 'modal-basic-title' });
    })
  }

  /**
   * content- reference to the element modal.
   * Used to open the modal.
   */
  open(content) {
    this.modalRef = this.modalService.open(content, { ariaLabelledBy: 'modal-basic-title' });
  };

  close(content){
    this.modalRef.close();
  }

  /**
   * Method used to send back a ticket object to update the specifically selected ticket.
   * Resets input fields in the modal. 
   * Closes model after data is sent.
   * Sends an alert to the user when a ticket is sent.
   */
  sendUpdate() {
    this.ticketUpdate = this.modalForm.value;
    this.ticketUpdate.ticketId = this.modalTicketId;
    console.log(this.ticketUpdate);
    this.HOAService.updateTicket(this.ticketUpdate)
      .subscribe(data => {
        console.log(data);
        this.getAllTickets();
      });
    this.modalForm.reset();
    this.modalService.dismissAll();
    alert("Your ticket is now updated!");
    console.warn(this.modalForm.value);
  };

  /**
   * Method that sends back a ticket id for the selected ticket. This ticket will be deleted.
   * Closes modal window when delete request is sent.
   */
  sendDelete() {
    this.HOAService.deleteTicket(this.modalTicketId).subscribe(data=>{
      this.getAllTickets();
    }
    );
    this.modalService.dismissAll();
  }
}
