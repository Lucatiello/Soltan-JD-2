package by.htp.ex.controller.impl;

import by.htp.ex.controller.Command;
import by.htp.ex.util.validation.UserActivationCheck;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public final class ChangeLocale implements Command{
	private final UserActivationCheck activationCheck = UserActivationCheck.getInstance();
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getSession(true).setAttribute("locale", request.getParameter("locale"));
		boolean isActive = activationCheck.isUserActive(request);
		String path = isActive ? "controller?command=go_to_news_list" : "index.jsp";

		response.sendRedirect(path);
	}

}
