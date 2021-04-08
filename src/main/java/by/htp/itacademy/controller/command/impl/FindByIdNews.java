package by.htp.itacademy.controller.command.impl;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import by.htp.itacademy.controller.command.Command;
import by.htp.itacademy.entity.News;
import by.htp.itacademy.service.NewsService;
import by.htp.itacademy.service.ServiceException;
import by.htp.itacademy.service.ServiceProvider;

public class FindByIdNews implements Command {

	private static final String PARAMETER_ID = "id";
	private static final String PAGE_BY_ID = "/WEB-INF/jsp/shownews.jsp";

	private static final Logger logger = Logger.getLogger(FindByIdNews.class);

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ServiceProvider sp = ServiceProvider.getInstance();
		NewsService ns = sp.getNewsservice();

		News news = null;

		try {
			int id = Integer.parseInt(request.getParameter(PARAMETER_ID));
			news = ns.find(id);
		} catch (NumberFormatException | ServiceException e) {
			logger.error("find by id problem" + " " + e);
			throw new ServletException("news not found or other problem, try again");
		}

		request.setAttribute("news", news);

		RequestDispatcher rd = request.getRequestDispatcher(PAGE_BY_ID);
		rd.forward(request, response);
	}
}
