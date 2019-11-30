package hoa.api.services.ticket.microservices.basic_auth_service;

import com.github.cliftonlabs.json_simple.Jsoner;

import hoa.api.services.Services;
import hoa.api.services.ticket.microservices.basic_auth_service.verify.AllUsersVerify;

/**
 * Interfaces with API Controller to return a result of whether a user is valid or not
 * @author nealk
 *
 */
public class Basic_AuthFactory {
	
	//Stateful attribute for user validation. True = 401, False = 201
	public boolean unauthorized = false;
	
	public String init(int id, String userName, String password) {
		AllUsersVerify allUsersVerify = new AllUsersVerify(id, userName, password);
		unauthorized = allUsersVerify.role == null ? true : false;
		String json = allUsersVerify.toJson(Services.BasicAuthVerify);
		System.out.println("Factory: " + json);
		return Jsoner.prettyPrint(json);
	}

}
