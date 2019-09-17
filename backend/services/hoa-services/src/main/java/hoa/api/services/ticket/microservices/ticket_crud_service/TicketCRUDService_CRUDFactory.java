package hoa.api.services.ticket.microservices.ticket_crud_service;

import hoa.api.services.ticket.microservices.CRUDService_CRUDFactory;
import hoa.api.services.ticket.microservices.ticket_crud_service.read.TicketSelect;

public class TicketCRUDService_CRUDFactory extends CRUDService_CRUDFactory{
	
	public Ticket init(int ticketId) {
		return new TicketSelect(ticketId);
	}

}
