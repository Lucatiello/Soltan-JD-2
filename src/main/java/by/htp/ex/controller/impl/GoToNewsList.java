package by.htp.ex.controller.impl;

import java.io.IOException;
import java.util.List;

import by.htp.ex.bean.News;
import by.htp.ex.controller.Command;
import by.htp.ex.service.INewsService;
import by.htp.ex.service.ServiceException;
import by.htp.ex.service.ServiceProvider;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class GoToNewsList implements Command {
	
	private final INewsService newsService = ServiceProvider.getInstance().getNewsService();
	private static final String JSP_NEWS_PARAM = "news";
	private static final String JSP_PRESENTATION_PARAM = "presentation";
	private static final String JSP_NEWS_LIST_PARAM = "newsList";
	
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			List<News> newsList = newsService.list();
			request.setAttribute(JSP_NEWS_PARAM, newsList);
			request.setAttribute(JSP_PRESENTATION_PARAM, JSP_NEWS_LIST_PARAM);
			request.getRequestDispatcher("WEB-INF/pages/layouts/baseLayout.jsp").forward(request, response);
		}

		catch (ServiceException e) {
			e.printStackTrace();
		}
	}
}
