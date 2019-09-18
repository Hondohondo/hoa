package hoa.api.services.ticket.microservices.ticket_crud_service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

//import com.microsoft.sqlserver.jdbc.SQLServerDriver;
import com.microsoft.sqlserver.jdbc.SQLServerException;

import hoa.api.services.SqlOperationType;


//import com.microsoft.sqlserver.jdbc.SQLServerException;
//import com.microsoft.sqlserver.jdbc.*;

public abstract class Ticket {
	
	protected volatile int ticketId;
	protected volatile String subject;
	private volatile String message;
	private volatile String createdBy;
	private volatile String name;
	private volatile String phoneNumber;
	private volatile String email;
	private volatile String memberID;
	private volatile String status;
	private volatile boolean isActive;
	private final String connectionString = "jdbc:sqlserver://nealkdbserver.database.windows.net:1433;database=UtilityDB;user=neal@nealkdbserver;password=Steel2727;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";
	protected final SqlOperationType operation;
	//private Hashtable<SqlOperationType, Ticket> 
	
	protected Ticket(SqlOperationType operation) {
		this.operation = operation;
		//queryDb();
		
	}
	
	protected final String queryDb() {
		final String sql = getQuery();
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection connection = DriverManager.getConnection(connectionString);
			System.out.println("Connected.");
			PreparedStatement stmt = connection.prepareStatement(sql);
			if(operation.equals(SqlOperationType.insert)){
				stmt.executeUpdate();
				status = "success";
			} else if(operation.equals(SqlOperationType.select)) {
				ResultSet rs = stmt.executeQuery();
				status = "null data.";
				if(rs != null) {
					status = "success";
					while(rs.next()) {				
						this.subject = rs.getString(TicketColumns.Subject.toString());
						System.out.println(subject);
						this.message = rs.getString(TicketColumns.TicketMessage.toString());
						this.isActive = (rs.getInt(TicketColumns.IsActive.toString()) == 1) ? true : false;
						this.createdBy = rs.getString(TicketColumns.CreatedBy.toString());
						this.name = rs.getString(TicketColumns.Name.toString());
						this.phoneNumber = rs.getString(TicketColumns.PhoneNumber.toString());
						this.memberID = rs.getString(TicketColumns.MemberID.toString());
					}
				}
			}
		} 
		catch (SQLServerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		catch (Exception ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		} 
		return status;
	}
	
	protected abstract ResultSet executeSql(PreparedStatement stmt);
	
	protected abstract String getQuery();
	
//	public Ticket(int ticketId, String subject, String message, boolean isActive, String createdBy, String name, String phoneNumber, String email, String memberId) {
//		this.ticketId = ticketId;
//		this.subject = subject;
//		this.message = message;
//		this.isActive = isActive;
//		this.createdBy = createdBy;
//		this.name = name;
//		this.phoneNumber = phoneNumber;
//		this.email = email;
//		this.memberID = memberId;
//	}
	
//	public Ticket(int ticketId) {
//		this.ticketId = ticketId;
//	}
//
	/**
	 * @return the ticketId
	 */
	public synchronized int getTicketId() {
		return ticketId;
	}

	/**
	 * @return the message
	 */
	public synchronized String getMessage() {
		return message;
	}

	/**
	 * @return the subject
	 */
	public synchronized String getSubject() {
		return subject;
	}

	/**
	 * @return the createdBy
	 */
	public synchronized String getCreatedBy() {
		return createdBy;
	}

	/**
	 * @return the name
	 */
	public synchronized String getName() {
		return name;
	}

	/**
	 * @return the phoneNumber
	 */
	public synchronized String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * @return the email
	 */
	public synchronized String getEmail() {
		return email;
	}

	/**
	 * @return the memberID
	 */
	public synchronized String getMemberID() {
		return memberID;
	}

	/**
	 * @return the isActive
	 */
	public synchronized boolean getIsActive() {
		return isActive;
	}
	
	/**
	 * @return the status
	 */
	public synchronized String getStatus() {
		return status;
	}

	/**
	 * @param ticketId the ticketId to set
	 */
	protected synchronized void setTicketId(int ticketId) {
		this.ticketId = ticketId;
	}

	/**
	 * @param subject the subject to set
	 */
	protected synchronized void setSubject(String subject) {
		this.subject = subject;
	}

	/**
	 * @param message the message to set
	 */
	protected synchronized void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @param createdBy the createdBy to set
	 */
	protected synchronized void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	/**
	 * @param name the name to set
	 */
	protected synchronized void setName(String name) {
		this.name = name;
	}

	/**
	 * @param phoneNumber the phoneNumber to set
	 */
	protected synchronized void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/**
	 * @param email the email to set
	 */
	protected synchronized void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @param memberID the memberID to set
	 */
	protected synchronized void setMemberID(String memberID) {
		this.memberID = memberID;
	}

	/**
	 * @param status the status to set
	 */
	protected synchronized void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @param isActive the isActive to set
	 */
	protected synchronized void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	
	/**
	 * @param isActive the isActive to set
	 */
	protected synchronized void setMemberId(String memeberId) {
		this.memberID = memeberId;
	}

}

