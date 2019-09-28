import { Injectable, Inject } from '@angular/core';
import { Ticket } from '../app/Ticket';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Http, Response } from '@angular/http';
import { Observable, from } from 'rxjs';
import { map, catchError} from 'rxjs/operators'
import { ArrayType } from '@angular/compiler';

@Injectable({
  providedIn: 'root'
})
export class HOAService {

  constructor(private http: HttpClient) { }

  public getAllTicketURL : string = 
  "http://hoa.api.ngrok.io/services/ticket/microservices/ticket_crud_service/GetAll";
  public getTicketByIdURL: string = 
  "http://hoa.api.ngrok.io/services/ticket/microservices/ticket_crud_service/by_ticketid?id=";

  getAllTickets(){
    // return this.http.get(this.getAllTicketURL)
    // .pipe(map((x:Response)=> x.json()
    // ));
    // return this.http.get<Ticket[]>(this.getAllTicketURL)
    // .pipe(map(res => res['tickets']));
    // return this.http.get<Ticket[]>(
    //   this.getAllTicketURL).pipe(map((data:any) =>{
    //     console.log(data);
    //     return data;
    //   }));
    return this.http.get(this.getAllTicketURL);
  };

  getTicketById(id : number): Observable<HttpResponse<Ticket>>{
    return this.http.get<Ticket>(
      this.getTicketByIdURL + id,{observe: 'response'})
  };
}
