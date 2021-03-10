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

public class FindForUpdate implements Command{
	
	private static final String PARAMETER_ID = "id";
	private static final String CREATE_PAGE = "/WEB-INF/jsp/createnews.jsp";
	
	private static final Logger logger = Logger.getLogger(FindForUpdate.class);
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServiceProvider sp = ServiceProvider.getInstance();
		NewsService ns = sp.getNewsservice();
		
		News news = null;
		
		try {
			int id = Integer.parseInt(request.getParameter(PARAMETER_ID));
			news=ns.find(id);
		} catch (NumberFormatException|ServiceException e) {
			logger.error("find for update problem"+ " " + e);
			throw new ServletException("news not found or other error", e);
		}
		request.setAttribute("news", news);
		
		RequestDispatcher rd = request.getRequestDispatcher(CREATE_PAGE);
		rd.forward(request, response);
	}
}
