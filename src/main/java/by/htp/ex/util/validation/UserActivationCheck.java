package by.htp.ex.util.validation;

import jakarta.servlet.http.HttpServletRequest;

public final class UserActivationCheck {
	private final static UserActivationCheck instance = new UserActivationCheck();

	private UserActivationCheck(){
	}

	public boolean isUserActive(HttpServletRequest request){
		if (request.getSession().getAttribute("user") == null || !(request.getSession().getAttribute("user").equals("active")))
			return false;
		return true;
	}

	public static UserActivationCheck getInstance(){
		return instance;
	}
}

