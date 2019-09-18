package hoa.api.services.ticket.microservices.ticket_crud_service.read;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import hoa.api.services.SqlOperationType;
import hoa.api.services.ticket.microservices.ticket_crud_service.Ticket;

public class TicketGetAll extends Ticket{
	
//	public TicketSelect(int ticketId) {
//		this.ticketId = ticketId;
//		this.subject = super.getSubject();
//	}
	
	public TicketGetAll() {
		super(SqlOperationType.select);
		super.queryDb();
	}

	@Override
	protected ResultSet executeSql(PreparedStatement stmt) {
		// TODO Auto-generated method stub
		try {
			return stmt.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	protected String getQuery() {
		// TODO Auto-generated method stub
		return "SELECT * FROM Ticket WHERE IsActive = 1";
	}
}