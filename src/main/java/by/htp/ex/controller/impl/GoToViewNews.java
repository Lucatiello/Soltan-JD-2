package by.htp.ex.controller.impl;

import java.io.IOException;

import by.htp.ex.bean.News;
import by.htp.ex.controller.Command;
import by.htp.ex.service.INewsService;
import by.htp.ex.service.ServiceException;
import by.htp.ex.service.ServiceProvider;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public final class GoToViewNews implements Command {
	private final INewsService newsService = ServiceProvider.getInstance().getNewsService();
	private static final String JSP_NEWS_PARAM = "news";
	private static final String JSP_PRESENTATION_PARAM = "presentation";
	private static final String JSP_VIEW_NEWS_PARAM = "newsList";
	private static final String ID = "id";

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter(ID);
		try {
			News news  = newsService.findById(Integer.parseInt(id));

			request.setAttribute(JSP_NEWS_PARAM, news);
			request.setAttribute(JSP_PRESENTATION_PARAM, JSP_VIEW_NEWS_PARAM);
			request.getRequestDispatcher("WEB-INF/pages/layouts/baseLayout.jsp").forward(request, response);
		}
		catch (ServiceException e) {
			e.printStackTrace();
		}
	}
}
