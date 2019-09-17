package hoa.api.services;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hoa.api.services.ticket.db_direct_access_service_proxy.Ticket;
import hoa.api.services.ticket.db_direct_access_service_proxy.TicketDBDirectAccessServiceProxyFactory;
import hoa.api.services.ticket.db_direct_access_service_proxy.TicketSelect;

/**
 * All new request maps must have the following comments:
 * SERVICE: ServiceName/subfolder
 * TYPE: Http Type (GET, POST, PUT, DELETE)
 * Description: Include whether its a batch or individual, the database name, and 
 * 				details about the request params.
 * @author Owner
 *
 */
@RestController
public class ApiController {
	
	/**
	 * SERVICE: Ticket/db_direct_access_service_proxy
	 * TYPE: GET
	 * DESCRIPTION: Individual record retrieval from TicketDB by TicketID number.
	 * @param id
	 * @return
	 */
	@RequestMapping("/services/ticket/db_direct_access_service_proxy")
	public Ticket get (@RequestParam(value="id") int id) {
		return new TicketDBDirectAccessServiceProxyFactory().init(id);
	}

}
