package by.htp.ex.controller.impl;

import java.io.IOException;

import javax.sound.midi.Soundbank;

import by.htp.ex.bean.NewUserInfo;
import by.htp.ex.controller.Command;
import by.htp.ex.service.ServiceException;
import by.htp.ex.service.ServiceProvider;
import by.htp.ex.service.IUserService;
import by.htp.ex.service.impl.UserServiceImpl;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class DoSIgnIn implements Command {

	private final IUserService service = ServiceProvider.getInstance().getUserService();

	private static final String JSP_LOGIN_PARAM = "login";
	private static final String JSP_PASSWORD_PARAM = "password";

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String login;
		String password;

		login = request.getParameter(JSP_LOGIN_PARAM);
		password = request.getParameter(JSP_PASSWORD_PARAM);

		HttpSession session = request.getSession(true);

		NewUserInfo user = null;
		try {

			user = service.signIn(login, password);

			
			if (user == null) {

				
				session.setAttribute("user", "not active");
				session.setAttribute("AuthentificationError", "wrong login or password");
				request.getRequestDispatcher("/WEB-INF/pages/layouts/baseLayout.jsp").forward(request, response);
				
				

			} else {// user admin
				
				session.setAttribute("user", "active");
				session.setAttribute("role", user.getRole());
				
								
				response.sendRedirect("controller?command=go_to_news_list");
			
			}

		} catch (ServiceException e) {

			request.setAttribute("AuthentificationError", "wrong login or password");
			request.setAttribute("errorPage", "wrong login or password");
			request.setAttribute("error", "error");
			request.setAttribute("errorE", e.getMessage());
		
			request.getRequestDispatcher("/WEB-INF/pages/layouts/baseLayout.jsp").forward(request, response);

			// response.sendRedirect("controller?command=go_to_base_page");

			// throw new ServletException(e);
			// request.getSession().setAttribute("AuthentificationError", e.getMessage());
			// request.getRequestDispatcher("/WEB-INF/pages/layouts/baseLayout.jsp").forward(request,
			// response);

			// logging e
			// go-to error page

		}

		// response.getWriter().print("do logination");

	}

}