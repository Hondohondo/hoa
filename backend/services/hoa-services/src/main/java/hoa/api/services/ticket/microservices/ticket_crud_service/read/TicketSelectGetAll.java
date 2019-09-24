package hoa.api.services.ticket.microservices.ticket_crud_service.read;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Observable;

import hoa.api.services.Services;
import hoa.api.services.SqlOperationType;
import hoa.api.services.ticket.microservices.ticket_crud_service.Ticket;

public class TicketSelectGetAll extends Ticket{
	
//	public TicketSelect(int ticketId) {
//		this.ticketId = ticketId;
//		this.subject = super.getSubject();
//	}
	
	public TicketSelectGetAll() {
		super(SqlOperationType.select_get_all);
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
		return "SELECT * FROM Ticket";
	}

	@Override
	public Services getServiceName() {
		// TODO Auto-generated method stub
		return Services.TicketGetAll;
	}

//	@Override
//	public void update(Observable obsv, Object obj) {
//		// TODO Auto-generated method stub
//		if(obj.equals(Services.TicketGetAll))
//			this.toJson();
//	}
}