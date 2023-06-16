package by.htp.ex.controller.impl;

import java.io.IOException;

import by.htp.ex.controller.Command;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class DoSignOut implements Command {
     private static final String JSP_USER_PARAM = "user";
     private static final String JSP_USER_NOT_ACTIVE = "not active";
	
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			request.getSession(true).setAttribute(JSP_USER_PARAM, JSP_USER_NOT_ACTIVE);
			response.sendRedirect("index.jsp");
		
	}

}
