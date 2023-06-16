package by.htp.ex.controller.impl;

import java.io.IOException;

import by.htp.ex.bean.NewUserInfo;
import by.htp.ex.bean.Role;
import by.htp.ex.controller.Command;
import by.htp.ex.service.IUserService;
import by.htp.ex.service.ServiceProvider;
import by.htp.ex.service.ServiceException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public final class DoRegistration implements Command {
	private static final String JSP_LOGIN_PARAM = "login";
	private static final String JSP_EMAIL_PARAM = "email";
	private static final String JSP_PASSWORD_PARAM = "password";
	private static final String JSP_REGISTRATION_ERROR_PARAM = "RegistrationError";
	private static final IUserService userService = ServiceProvider.getInstance().getUserService();

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String login = request.getParameter(JSP_LOGIN_PARAM);
		String email = request.getParameter(JSP_EMAIL_PARAM);
		String password = request.getParameter(JSP_PASSWORD_PARAM);

		request.getSession().removeAttribute(JSP_REGISTRATION_ERROR_PARAM);

		if (dataValidator(login, email, password)){
			request.getSession(true).setAttribute(JSP_REGISTRATION_ERROR_PARAM,
					"Login/Email/Password error. The number of characters must not be less than 2");

			response.sendRedirect("controller?command=go_to_registration_page");
		}

		else {
			NewUserInfo user = new NewUserInfo(
					request.getParameter(JSP_LOGIN_PARAM),
					request.getParameter(JSP_EMAIL_PARAM),
					request.getParameter(JSP_PASSWORD_PARAM),
					Role.USER);
			try {
				userService.registration(user);
				response.sendRedirect("controller?command=go_to_base_page");
			}
			catch (ServiceException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	public boolean dataValidator(String login, String email, String password){
		return (login.length() < 2 || email.length() < 2 || password.length() < 2);
	}
}
