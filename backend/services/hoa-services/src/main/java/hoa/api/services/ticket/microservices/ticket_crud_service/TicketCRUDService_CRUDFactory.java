package hoa.api.services.ticket.microservices.ticket_crud_service;

import com.github.cliftonlabs.json_simple.Jsoner;

import hoa.api.services.Services;
import hoa.api.services.ticket.microservices.CRUDService_CRUDFactory;
import hoa.api.services.ticket.microservices.ticket_crud_service.read.TicketSelectGetAll;
import hoa.api.services.ticket.microservices.ticket_crud_service.read.TicketSelect;

public class TicketCRUDService_CRUDFactory extends CRUDService_CRUDFactory{
	
	public String init(int ticketId) {
		TicketSelect ticketSelect = new TicketSelect(ticketId);
		String json = Jsoner.serialize(ticketSelect.toJson(Services.TicketSelect));
		System.out.println("factory: " + json);
		return Jsoner.prettyPrint(json);
	}
	
	public String init(){
		TicketSelectGetAll ticketSelectGetAll = new TicketSelectGetAll();
		String json = Jsoner.serialize(ticketSelectGetAll.toJson(Services.TicketGetAll));
		System.out.println("factory: " + json);
		return Jsoner.prettyPrint(json);
	}
	
	public Ticket init(String subject, String ticketMessage, boolean isActive, String name, String phoneNumber, String email, String memberId) {
		return null;
	}

}
