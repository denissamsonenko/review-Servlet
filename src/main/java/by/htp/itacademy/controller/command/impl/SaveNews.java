package by.htp.itacademy.controller.command.impl;

import java.io.IOException;
import java.time.LocalDate;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import by.htp.itacademy.controller.command.Command;
import by.htp.itacademy.entity.News;
import by.htp.itacademy.service.NewsService;
import by.htp.itacademy.service.ServiceException;
import by.htp.itacademy.service.ServiceProvider;

public class SaveNews implements Command {
	
	private static final String PARAMETER_TITLE = "title";
	private static final String PARAMETER_BRIEF = "brief";
	private static final String PARAMETER_CONTENT = "content";
	private static final String PAGE_ALL_NEWS = "controller?command=show_all_news";
	
	private static final Logger logger = Logger.getLogger(SaveNews.class);
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		ServiceProvider sp = ServiceProvider.getInstance();
		NewsService ns = sp.getNewsservice();
		
		News news = new News();
		news.setTitle(request.getParameter(PARAMETER_TITLE));
		news.setBrief(request.getParameter(PARAMETER_BRIEF));
		news.setContent(request.getParameter(PARAMETER_CONTENT));
		news.setDate(LocalDate.now());
		
		try {
			ns.save(news);
		} catch (ServiceException e) {
			logger.error("save news problem" + " " + e);
			throw new ServletException("title brief content must be not null");
		}
		
		response.sendRedirect(PAGE_ALL_NEWS);				
	}
}
