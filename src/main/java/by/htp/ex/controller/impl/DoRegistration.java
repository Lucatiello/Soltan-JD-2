package by.htp.ex.controller.impl;

import java.io.IOException;

import javax.sound.midi.Soundbank;

import org.mindrot.jbcrypt.BCrypt;

import by.htp.ex.bean.NewUserInfo;
import by.htp.ex.controller.Command;
import by.htp.ex.service.IUserService;
import by.htp.ex.service.ServiceException;
import by.htp.ex.service.ServiceProvider;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class DoRegistration implements Command {

	private final IUserService userService = ServiceProvider.getInstance().getUserService();

	private static final String JSP_NAME = "name";
	private static final String JSP_SURNAME = "surname";
	private static final String JSP_LOGIN = "login";
	private static final String JSP_PASSWORD = "password";
	private static final String JSP_EMIAL = "email";

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String name;
		String surname;
		String login;
		String password;
		String email;
		String role = "user";

		name = request.getParameter(JSP_NAME);
		surname = request.getParameter(JSP_SURNAME);
		login = request.getParameter(JSP_LOGIN);
	
		
		password = BCrypt.hashpw(request.getParameter(JSP_PASSWORD), BCrypt.gensalt());
		
		
		email = request.getParameter(JSP_EMIAL);

		NewUserInfo newUser = new NewUserInfo(name, surname, login, password, email, role);

		try {

			if (userService.registration(newUser)) {

				request.getSession(true).setAttribute("user2", "not visible");
				request.getSession().setAttribute("welcome", "registered");
				
				response.sendRedirect("controller?command=go_to_registration_page");

			} else {

				response.sendRedirect("controller?command=go_to_base_page");

			}

		} catch (ServiceException e) {

			request.setAttribute("error", "error");
			request.setAttribute("errorE", e.getMessage());
		
			request.getRequestDispatcher("/WEB-INF/pages/layouts/baseLayout.jsp").forward(request, response);
		}

	}

}