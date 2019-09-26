package hoa.api.services;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import hoa.api.services.ticket.microservices.CRUDService_CRUDFactory;
import hoa.api.services.ticket.microservices.ticket_crud_service.Ticket;
import hoa.api.services.ticket.microservices.ticket_crud_service.TicketCRUDService_CRUDFactory;
import hoa.api.services.ticket.microservices.ticket_crud_service.TicketCRUDService_Constants;

/**
 * </br>All new request maps must have the following comments:
 * </br>SERVICE: ServiceName/subfolder
 * </br>TYPE: Http Type (GET, POST, PUT, DELETE)
 * </br>Description: Include whether its a batch or individual, the database name, and 
 * 				details about the request params.
 * @author Owner
 *
 */
@RestController
public final class ApiController {
	
	/**
	 * </br>SERVICE: /
	 * </br>TYPE: GET
	 * </br>DESCRIPTION: Individual record retrieval from TicketDB by TicketID number.
	 * </br>@return - Greeting message for Services home.
	 */
    @RequestMapping(method = RequestMethod.GET, value = ServiceConstants.SERVICES)
    @ResponseStatus(HttpStatus.OK)
    public String index() {
    	return new CRUDService_CRUDFactory().getServiceHomeMessage();
    }
	
	/**
	 * </br>SERVICE: ticket/microservices/ticket_crud_service/read
	 * </br>TYPE: GET
	 * </br>DESCRIPTION: Individual record retrieval from TicketDB by TicketID number.
	 * </br>@param id
	 * </br>@return
	 */
	@RequestMapping(method = RequestMethod.GET, value = TicketCRUDService_Constants.READ_BY_TICKETID)
	@ResponseStatus(HttpStatus.OK)
	public String retrierveByTicketId (@RequestParam(value="id") int id) {
		return new TicketCRUDService_CRUDFactory().init(id);
	}

	/**
	 * </br>SERVICE: ticket/microservices/ticket_crud_service/read
	 * </br>TYPE: GET
	 * </br>DESCRIPTION: Bulk retreival. 
	 * </br>@return
	 */
	@RequestMapping(method = RequestMethod.GET, value = TicketCRUDService_Constants.READ_ALL)
	@ResponseStatus(HttpStatus.OK)
	public String retrierveByAll () {
		return new TicketCRUDService_CRUDFactory().init();
	}
	
	/**
	 * </br>SERVICE: ticket/microservices/ticket_crud_service/
	 * </br>TYPE: GET
	 * </br>DESCRIPTION: Individual record retrieval from TicketDB by TicketID number.
	 * </br>@param id
	 * </br>@return
	 */
	@RequestMapping(TicketCRUDService_Constants.CREATE)
	@ResponseStatus(HttpStatus.CREATED)
	public String insertNew (@RequestParam(value="subject") String subject,
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
