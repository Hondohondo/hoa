package hoa.api.services.ticket.microservices.ticket_crud_service;

import hoa.api.services.ServiceConstants;

/**
 * Endpoint constants for the Ticket Service
 * @author nealk
 *
 */
public abstract class TicketCRUDService_Constants extends ServiceConstants{
	
	public static final String READ_BY_TICKETID = "/services/ticket/microservices/ticket_crud_service/by_ticketid";
	public static final String CREATE = "/services/ticket/microservices/ticket_crud_service/";
	public static final String UPDATE = "/services/ticket/microservices/ticket_crud_service/";
	public static final String READ_ALL = "/services/ticket/microservices/ticket_crud_service/GetAll";
}
