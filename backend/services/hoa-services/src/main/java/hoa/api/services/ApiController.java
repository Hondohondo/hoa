package hoa.api.services;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import hoa.api.services.ticket.microservices.CRUDService_CRUDFactory;
import hoa.api.services.ticket.microservices.ticket_crud_service.Ticket;
import hoa.api.services.ticket.microservices.ticket_crud_service.TicketCRUDService_CRUDFactory;
import hoa.api.services.ticket.microservices.ticket_crud_service.TicketCRUDService_Constants;
import hoa.api.services.ticket.microservices.ticket_crud_service.create.TicketInsert;

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
	@RequestMapping(method = RequestMethod.GET, value = TicketCRUDService_Constants.READ_BY_TICKETID,
					/*consumes = "application/json",*/ produces = "application/json")
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
	@RequestMapping(method = RequestMethod.GET, value = TicketCRUDService_Constants.READ_ALL, produces = "application/json")
	@ResponseStatus(HttpStatus.OK)
	@CrossOrigin(/*origins = "http://hoa.ngrok.io" /*+ TicketCRUDService_Constants.READ_ALL*/)
	public String retrierveByAll () {
		return new TicketCRUDService_CRUDFactory().init();
	}
	
	/**
	 * </br>SERVICE: ticket/microservices/ticket_crud_service/
	 * </br>TYPE: POST
	 * </br>DESCRIPTION: Insert a new ticket.
	 * </br>@param id
	 * </br>@return
	 */
	@RequestMapping(method = RequestMethod.POST, value = TicketCRUDService_Constants.CREATE)
	@ResponseStatus(HttpStatus.CREATED)
	@CrossOrigin()
	public /*@ResponseBody*/ String insertNew (
							 @RequestBody TicketInsert ticket
//							 @RequestParam(value="subject", required=false) @RequestBody String subject,
//							 @RequestParam(value="ticketMessage", required=false) String ticketMessage,
//							 @RequestParam(value="isActive", required=false) boolean isActive,
//							 @RequestParam(value="createdBy", required=false) String createdBy,
//							 @RequestParam(value="name", required=false) String name,
//							 @RequestParam(value="phoneNumber", required=false) String phoneNumber,
//							 @RequestParam(value="email", required=false) String email,
//							 @RequestParam(value="memberId", required=false) String memberId
							 ) {
		System.out.println("Subject = " + ticket.subject);
		return new TicketCRUDService_CRUDFactory().init(ticket.subject, ticket.message, ticket.isActive, ticket.name, ticket.phoneNumber, ticket.email, ticket.memberID);
	}
	
	

}
