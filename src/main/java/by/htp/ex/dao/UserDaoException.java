package by.htp.ex.dao;

public class UserDaoException extends Exception {
	private static final long serialVersionUID = 8814453066415187129L;

	public UserDaoException() {
		super();
	}
	
	public UserDaoException(String message) {
		super(message);
	}
	
	public UserDaoException(Exception e) {
		super(e);
	}
	
	public UserDaoException(String message, Exception e) {
		super(message, e);
	}
}
