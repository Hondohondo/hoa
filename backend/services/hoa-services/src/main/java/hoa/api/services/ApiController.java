package hoa.api.services;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hoa.api.services.ticket.microservices.ticket_crud_service.Ticket;
import hoa.api.services.ticket.microservices.ticket_crud_service.TicketCRUDService_CRUDFactory;

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
	 * SERVICE: ticket/microservices/ticket_crud_service/read
	 * TYPE: GET
	 * DESCRIPTION: Individual record retrieval from TicketDB by TicketID number.
	 * @param id
	 * @return
	 */
	@RequestMapping("/services/ticket/microservices/ticket_crud_service/read")
	public Ticket get (@RequestParam(value="id") int id) {
		return new TicketCRUDService_CRUDFactory().init(id);
	}

}
