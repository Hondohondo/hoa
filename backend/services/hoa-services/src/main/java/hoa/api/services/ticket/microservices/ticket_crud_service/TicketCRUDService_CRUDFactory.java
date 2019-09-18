package hoa.api.services.ticket.microservices.ticket_crud_service;

import hoa.api.services.ticket.microservices.CRUDService_CRUDFactory;
import hoa.api.services.ticket.microservices.ticket_crud_service.create.TicketInsert;
import hoa.api.services.ticket.microservices.ticket_crud_service.read.TicketSelect;
import hoa.api.services.ticket.microservices.ticket_crud_service.read.TicketGetAll;

public class TicketCRUDService_CRUDFactory extends CRUDService_CRUDFactory{
	
	public Ticket init(int ticketId) {
		return new TicketSelect(ticketId);
	}
	
	public Ticket init(){
		return new TicketGetAll();
	}
	
	public Ticket init(String subject, String ticketMessage, boolean isActive, String name, String phoneNumber, String email, String memberId) {
		return new TicketInsert(subject, ticketMessage, isActive, name, phoneNumber, email, memberId);
	}

}
