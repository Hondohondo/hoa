package hoa.api.services.ticket.microservices.basic_auth_service.verify;

import java.io.IOException;
import java.io.Writer;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;

import com.github.cliftonlabs.json_simple.JsonObject;

import hoa.api.services.Services;
import hoa.api.services.SqlOperationType;
import hoa.api.services.ticket.microservices.basic_auth_service.AllUsers;

/**
 * Verifies whether a user exists or not.
 * @author nealk
 *
 */
public class AllUsersVerify extends AllUsers{
	
	private boolean hasUsername, hasId;
	public AllUsersVerify() {
		hasUsername = false;
		hasId = false;
	};
	
	/**
	 * Verifies if a user exisys
	 * @param id
	 * @param username
	 * @param password
	 */
	public AllUsersVerify(int id, String username, String password) {
		super(SqlOperationType.select);
		if(!username.isEmpty()) {
			System.out.println(username);
			this.setUsername(username);
			hasUsername = true;
			hasId = false;
		} else {
			hasId = true;
			hasUsername = false;
			this.setId(id);
		}
		
		this.setPassword(password);
		super.queryDb();
	}

	@Override
	/**
	 * Builds the JSON response
	 */
	public void toJson(Writer writer) throws IOException {
		// TODO Auto-generated method stub
		final JsonObject json = new JsonObject();
		json.put("id", this.getId());
		json.put("username", this.getUsername());
		json.put("password", this.getPassword());
		json.put("firstName", this.getFirstName());
		json.put("lastName", this.getLastName());
		json.put("role", this.getRole());
		json.put("token", this.getId());
		json.toJson(writer);
	}

	@Override
	/**
	 * For the Service registry
	 */
	public Services getServiceName() {
		// TODO Auto-generated method stub
		return Services.BasicAuthVerify;
	}

	@Override
	/**
	 * Returns the Query
	 */
	protected String getQuery() {
		// TODO Auto-generated method stub
		if(hasUsername) {
			System.out.println("In getQuery():: " + this.getUsername());
			return "SELECT * FROM ALL_USERS WHERE Username = '" + this.getUsername() /*+ "' AND Password = '" + this.getPassword()*/ + "';";
		} else if(hasId) {
			return "SELECT * FROM ALL_USERS WHERE UID = " + this.getId() /*+ " AND Password = '" + this.getPassword()*/ + "';";
		} else {
			return "";
		}
		
	}
	
	private String encryptPassword(String plainText) {
		String seed = "mtairhoa";
    	StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
    	encryptor.setPassword(seed);
    	return encryptor.encrypt(plainText);
	}

	/**
	 * Executes Statement with JDBC
	 */
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

}
