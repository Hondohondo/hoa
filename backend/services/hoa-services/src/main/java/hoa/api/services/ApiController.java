package hoa.api.services;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import hoa.api.services.ticket.microservices.ticket_crud_service.Ticket;
import hoa.api.services.ticket.microservices.ticket_crud_service.TicketCRUDService_CRUDFactory;
import hoa.api.services.ticket.microservices.ticket_crud_service.TicketCRUDService_Constants;

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
	@RequestMapping(method = RequestMethod.GET, value = TicketCRUDService_Constants.READ_BY_TICKETID)
	@ResponseStatus(HttpStatus.OK)
	public Ticket retrierveByTicketId (@RequestParam(value="id") int id) {
		return new TicketCRUDService_CRUDFactory().init(id);
	}
	
	/**
	 * SERVICE: ticket/microservices/ticket_crud_service/
	 * TYPE: GET
	 * DESCRIPTION: Individual record retrieval from TicketDB by TicketID number.
	 * @param id
	 * @return
	 */
	@RequestMapping(TicketCRUDService_Constants.CREATE)
	public Ticket insertNew (@RequestParam(value="subject") String subject,
							 @RequestParam(value="ticketMessage") String ticketMessage,
							 @RequestParam(value="isActive") boolean isActive,
							 @RequestParam(value="createdBy") String createdBy,
							 @RequestParam(value="name") String name,
							 @RequestParam(value="phoneNumber") String phoneNumber,
							 @RequestParam(value="email") String email,
							 @RequestParam(value="memberId") String memberId) {
		return new TicketCRUDService_CRUDFactory().init(subject, ticketMessage, isActive, name, phoneNumber, email, memberId);
	}
	
	

}
