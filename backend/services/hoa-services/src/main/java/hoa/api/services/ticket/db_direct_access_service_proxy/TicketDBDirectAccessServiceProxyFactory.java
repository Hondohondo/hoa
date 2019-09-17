package hoa.api.services.ticket.db_direct_access_service_proxy;

public class TicketDBDirectAccessServiceProxyFactory {
	
	public Ticket init(int ticketId) {
		return new TicketSelect(ticketId);
	}

}
