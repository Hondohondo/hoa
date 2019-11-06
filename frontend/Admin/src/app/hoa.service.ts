import { Injectable, Inject } from '@angular/core';
import { Ticket } from '../app/Ticket';
import { TicketPost } from '../app/TicketPost';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Http, Response } from '@angular/http';
import { Observable, from } from 'rxjs';
import { map, catchError } from 'rxjs/operators'
import { ArrayType } from '@angular/compiler';
import { JsonPipe } from '@angular/common';
import { HttpHeaders } from '@angular/common/http';
/**
 * Contains the extra headers for responses when sending a POST request back to the service/API.
 */
const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type': 'application/json',
    'Authorization': 'my-auth-token'
  })
};
/**
 * 
 */
@Injectable({
  providedIn: 'root'
})
/**
 * HOAService is a class that contains the URLs and methods used to send request back to the API.
 * This is the ticketing systems service class which handles interactions with endpoints.
 */
export class HOAService {
  Tickets = [];
  /**
   * @param http -The HttpClient object that gives your the ability to send requests back to the API. Uses angular's HttpClient library.
   */
  constructor(private http: HttpClient) { }

  /**
   * All endpoints for the ticketing system held in variable. Variable names are self defining using <type of request>TicketURL.
   */
  public getAllTicketURL: string =
    "http://hoa.api.ngrok.io/services/ticket/microservices/ticket_crud_service/GetAll";
  public getTicketByIdURL: string =
    "http://hoa.api.ngrok.io/services/ticket/microservices/ticket_crud_service/by_ticketid?id=";
  public postTicketURL: string =
    "http://hoa.api.ngrok.io/services/ticket/microservices/ticket_crud_service/";
  public updateTicketURL: string =
    "http://hoa.api.ngrok.io/services/ticket/microservices/ticket_crud_service/";
  public deleteTicketURL: string =
    "http://hoa.api.ngrok.io/services/ticket/microservices/ticket_crud_service/?id=";

  /**
   * Method used to grab all Ticket objects from API/ Database.
   */
  getAllTickets(): Observable<Ticket> {
    // return this.http.get(this.getAllTicketURL)
    //         .pipe(map((result: Response) => this.Tickets = result['tickets']));\
    return this.http.get(this.getAllTicketURL)
      .pipe(map(data => new Ticket(data)));
  };

  /**
   * Grabs a speific ticket from API based on ID parameter.
   * @param id -ID number of a specific ticket.
   */
  getTicketById(id: number): Observable<Ticket> {
    return this.http.get(
      this.getTicketByIdURL + id).pipe(map(data=>new Ticket(data)));
  };

  /**
   * This method is a POST request that takes in a Ticket object and sends it to the API to be handled and added to the database.
   */
  addTicket(ticket: TicketPost): Observable<TicketPost> {
    return this.http.post<TicketPost>(this.postTicketURL, ticket, httpOptions);
  }

  /**
   * This method is used to update existing tickets in the database using another Ticket object.
   * @param ticket -Ticket used to replace another ticket.
   */
  updateTicket(ticket: Ticket): Observable<Ticket> {
    return this.http.put<Ticket>(this.updateTicketURL, ticket, httpOptions);
  }

  /** DELETE: delete the ticket from the server */
  deleteTicket(id: number): Observable<{}> {
    return this.http.delete(this.deleteTicketURL+id, httpOptions);
  }
}
