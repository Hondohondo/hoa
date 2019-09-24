package hoa.api.services.ticket.microservices.ticket_crud_service.create;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Observable;

import hoa.api.services.Services;
import hoa.api.services.SqlOperationType;
import hoa.api.services.ticket.microservices.ticket_crud_service.Ticket;
import hoa.api.services.ticket.microservices.ticket_crud_service.TicketColumns;

public class TicketInsert extends Ticket{

	protected TicketInsert(SqlOperationType operation) {
		super(operation);
		// TODO Auto-generated constructor stub
	}


	public TicketInsert(String subject, String ticketMessage, boolean isActive, String name, String phoneNumber,
			String email, String memberId) {
		// TODO Auto-generated constructor stub
		super(SqlOperationType.insert);
		this.setSubject(subject);
		this.setMessage(ticketMessage);
		this.setActive(isActive);
		this.setName(name);
		this.setPhoneNumber(phoneNumber);
		this.setEmail(email);
		this.setMemberID(memberId);
	}



	@Override
	protected ResultSet executeSql(PreparedStatement stmt) {
		// TODO Auto-generated method stub
		try {
			stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	protected String getQuery() {
		// TODO Auto-generated method stub
		System.out.println(this.getSubject());
		return "INSERT into TICKET ("
				+ TicketColumns.Subject + ", "
						+ TicketColumns.TicketMessage + ", "
								+ TicketColumns.IsActive + ", "
										+ TicketColumns.CreatedBy + ", "
												+ TicketColumns.Name + ", "
														+ TicketColumns.PhoneNumber + ", "
																+ TicketColumns.Email + ", "
																		+ TicketColumns.MemberID + ") VALUES ('"
																				+ this.getSubject() + "','"
																						+ this.getMessage() + "','"
																								+ this.getIsActive() + "','"
																										+ this .getCreatedBy() + "','"
																												+ this.getName() + "','"
																														+ this.getEmail() + "','"
																																+ this.getMemberID() + "');";
	}

	@Override
	public Services getServiceName() {
		// TODO Auto-generated method stub
		return Services.TicketInsert;
	}

}
