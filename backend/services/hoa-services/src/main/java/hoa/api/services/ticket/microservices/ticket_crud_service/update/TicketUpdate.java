package hoa.api.services.ticket.microservices.ticket_crud_service.update;

import java.io.IOException;
import java.io.Writer;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.json.simple.JSONObject;

import com.github.cliftonlabs.json_simple.JsonObject;

import hoa.api.services.Services;
import hoa.api.services.SqlOperationType;
import hoa.api.services.ticket.microservices.ticket_crud_service.Ticket;

/**
 * Updates a Ticket
 * @author nealk
 *
 */
public class TicketUpdate extends Ticket{

	protected TicketUpdate() {
		super(SqlOperationType.update);
		// TODO Auto-generated constructor stub
		super.queryDb();
	}
	
	/**
	 * Updates the ticket.
	 * @param ticketId
	 * @param ticketMessage
	 * @param isActive
	 */
	public TicketUpdate(int ticketId, String ticketMessage, boolean isActive) {
		super(SqlOperationType.update);
		System.out.println("ticket message in update = " + ticketMessage);
		this.setTicketId(ticketId);
		this.setMessage(ticketMessage);
		this.setActive(isActive);
		super.queryDb();
	}

	@Override
	/**
	 * Executes the Statement.
	 */
	protected ResultSet executeSql(PreparedStatement stmt) {
		// TODO Auto-generated method stub
		try {
			stmt.executeUpdate();
			//return stmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	/**
	 * Returns the query String back to the caller.
	 */
	protected String getQuery() {
		// TODO Auto-generated method stub
		//int isActive = (super.isActive == true) ? 1 : 0;
		System.out.println("ticket message = " + this.message);
		return "UPDATE TICKET"
				+ " SET TicketMessage = '" + this.getMessage()
				+ "', IsActive = '" + this.getIsActive() 
				+ "' WHERE TicketID = " + this.getTicketId();
		
	}

	@Override
	/**
	 * Writes the JSON back to the caller.
	 */
	public void toJson(Writer writer) throws IOException {
		// TODO Auto-generated method stub
		String status = "updated.";
		JsonObject json = new JsonObject();
		json.put("status", status);
		json.toJson(writer);
	}

	@Override
	/**
	 * Returns the service name to the caller.
	 */
	public Services getServiceName() {
		// TODO Auto-generated method stub
		return Services.TicketUpdate;
	}

}
