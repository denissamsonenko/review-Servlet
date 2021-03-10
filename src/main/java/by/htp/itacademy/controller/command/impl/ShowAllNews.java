package by.htp.itacademy.controller.command.impl;

import java.io.IOException;
import java.util.List;
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

public class ShowAllNews implements Command{
	
	private static final String NEWS_PAGE = "/WEB-INF/jsp/showallnews.jsp";
	private static final String CREATE_PAGE = "controller?command=create_news";
	
	private static final Logger logger = Logger.getLogger(ShowAllNews.class);
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServiceProvider serviceProvider = ServiceProvider.getInstance();
		NewsService ns = serviceProvider.getNewsservice();

		List<News> newsList = null;
		try {
			newsList = ns.findAll();
		} catch (ServiceException e) {
			logger.error("findAll" + " " + e);
			throw new ServletException("some error, try again");
		}
		
		if(newsList.isEmpty()) {
			response.sendRedirect(CREATE_PAGE);
		}else {	
			
		request.setAttribute("newsList", newsList);
		
		RequestDispatcher rd = request.getRequestDispatcher(NEWS_PAGE);
		rd.forward(request, response);
	}
	}
}
