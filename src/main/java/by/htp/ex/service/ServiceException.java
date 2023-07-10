package by.htp.ex.service;

public class ServiceException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4662515306069600243L;

	public ServiceException(String e) {
		super(e);
	}
	
	public ServiceException(Exception e) {
		super(e);
	}

	public ServiceException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public ServiceException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public ServiceException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	
	
	
}
