package hoa.api.services.ticket.microservices.ticket_crud_service;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Hashtable;
import java.util.Map;
import java.util.Observer;

import com.github.cliftonlabs.json_simple.JsonObject;
import com.github.cliftonlabs.json_simple.Jsonable;

import com.microsoft.sqlserver.jdbc.SQLServerException;

import hoa.api.services.Service;
import hoa.api.services.CRUD;
import hoa.api.services.ServiceConstants;
import hoa.api.services.SqlOperationType;
import hoa.api.services.ticket.microservices.ticket_crud_service.read.TicketSelect;

/**
 * Returns a Ticket object. Jsonable is similar to Serializable for Java Beans, but for JSON.
 * </br>
 * </br> {@link #ticketId} = TicketID in UtilityDB.TICKET
 * </br> etc... 
 * </br> TODO: Finish this class documentation.
 * @author Owner
 *
 */
public abstract class Ticket extends Service{
	
	protected volatile int ticketId;
	protected volatile String subject;
	private volatile String message;
	private volatile String createdBy;
	private volatile String createdDate;
	private volatile String name;
	private volatile String phoneNumber;
	private volatile String email;
	private volatile String memberID;
	private volatile String status;
	private volatile boolean isActive;
	private final String connectionString = ServiceConstants.CONNECTION_STRING;
	protected final SqlOperationType operation;
	private Map<SqlOperationType, Ticket> ticketTable; 
	/**
	 * @return the operation
	 */
	public synchronized SqlOperationType getOperation() {
		return operation;
	}

	
	
	protected Ticket(SqlOperationType operation) {
		this.operation = operation;
		//ticketTable = new Hashtable<SqlOperationType, Ticket>();
		//ticketTable.put(SqlOperationType.select, new TicketSelect());
		//queryDb();
	}
	
	@Override
	public void toJson(Writer writer) throws IOException{
		//this.queryDb();
		final JsonObject json = new JsonObject();
		json.put("ticketId", this.getTicketId());
		json.put("subject", this.getSubject());
		json.put("message", this.getMessage());
		json.put("createdBy", this.getCreatedBy());
		json.put("createdDate", this.getCreatedDate());
		json.put("name", this.getName());
		json.put("phoneNumber", this.getPhoneNumber());
		json.put("email", this.getEmail());
		json.put("memberId", this.getMemberID());
		json.toJson(writer);
	}
	
	protected final String queryDb() {
		executeQuery(this.getOperation());
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
						this.message = rs.getString(TicketColumns.TicketMessage.toString());
						this.isActive = (rs.getInt(TicketColumns.IsActive.toString()) == 1) ? true : false;
						this.createdBy = rs.getString(TicketColumns.CreatedBy.toString());
						this.createdDate = rs.getString(TicketColumns.CreatedDate.toString());
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
	
	private String executeQuery(SqlOperationType operation2) {
		// TODO Auto-generated method stub
		if(this.getOperation().equals(SqlOperationType.select)) {
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
							this.message = rs.getString(TicketColumns.TicketMessage.toString());
							this.isActive = (rs.getInt(TicketColumns.IsActive.toString()) == 1) ? true : false;
							this.createdBy = rs.getString(TicketColumns.CreatedBy.toString());
							this.createdDate = rs.getString(TicketColumns.CreatedDate.toString());
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
		} else if(this.getOperation().equals(SqlOperationType.select_get_all)) {
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
							this.message = rs.getString(TicketColumns.TicketMessage.toString());
							this.isActive = (rs.getInt(TicketColumns.IsActive.toString()) == 1) ? true : false;
							this.createdBy = rs.getString(TicketColumns.CreatedBy.toString());
							this.createdDate = rs.getString(TicketColumns.CreatedDate.toString());
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
		
		return "error.";
	}



	protected abstract ResultSet executeSql(PreparedStatement stmt);
	
	protected abstract String getQuery();
	
	/**
	 * @return the ticketId
	 */
	protected synchronized int getTicketId() {
		return ticketId;
	}

	/**
	 * @return the message
	 */
	protected synchronized String getMessage() {
		return message;
	}

	/**
	 * @return the subject
	 */
	protected synchronized String getSubject() {
		return subject;
	}

	/**
	 * @return the createdBy
	 */
	protected synchronized String getCreatedBy() {
		return createdBy;
	}
	
	/**
	 * @return the createdDate
	 */
	public String getCreatedDate() {
		return createdDate;
	}

	/**
	 * @return the name
	 */
	protected synchronized String getName() {
		return name;
	}

	/**
	 * @return the phoneNumber
	 */
	protected synchronized String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * @return the email
	 */
	protected synchronized String getEmail() {
		return email;
	}

	/**
	 * @return the memberID
	 */
	protected synchronized String getMemberID() {
		return memberID;
	}

	/**
	 * @return the isActive
	 */
	protected synchronized boolean getIsActive() {
		return isActive;
	}
	
	/**
	 * @return the status
	 */
	protected synchronized String getStatus() {
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

	/**
	 * @param createdDate the createdDate to set
	 */
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

}

