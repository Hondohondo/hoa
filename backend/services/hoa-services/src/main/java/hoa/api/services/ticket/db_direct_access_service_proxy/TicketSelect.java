package hoa.api.services.ticket.db_direct_access_service_proxy;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TicketSelect extends Ticket{
	
//	public TicketSelect(int ticketId) {
//		this.ticketId = ticketId;
//		this.subject = super.getSubject();
//	}
	
	public TicketSelect(int ticketId) {
		super(SqlOperationType.select);
		this.ticketId = ticketId;
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
		return "SELECT * FROM Ticket WHERE TicketID = " + this.getTicketId();
	}

}
