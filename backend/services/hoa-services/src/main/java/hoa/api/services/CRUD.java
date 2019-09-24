package hoa.api.services;

/**
 * All CRUD services should implement this.
 *
 */
public interface CRUD {
	
	abstract String queryDb();
	String excuteQuery(SqlOperationType operation);

}
