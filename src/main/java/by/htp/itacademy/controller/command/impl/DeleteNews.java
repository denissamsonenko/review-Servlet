package by.htp.itacademy.controller.command.impl;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import by.htp.itacademy.controller.command.Command;
import by.htp.itacademy.service.NewsService;
import by.htp.itacademy.service.ServiceException;
import by.htp.itacademy.service.ServiceProvider;

public class DeleteNews implements Command {

	private static final String PARAMETER_ID = "id";
	private static final String PAGE_ALL_NEWS = "controller?command=show_all_news";

	private static final Logger logger = Logger.getLogger(DeleteNews.class);

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServiceProvider sp = ServiceProvider.getInstance();
		NewsService ns = sp.getNewsservice();

		String[] values = request.getParameterValues(PARAMETER_ID);

		if (values == null) {
			logger.error("no news selected");
			throw new ServletException("no news selected for delete, try again");
		}

		try {
			for (String idValues : values) {
				int id = Integer.parseInt(idValues);
				ns.delete(id);
			}
		} catch (NumberFormatException | ServiceException e) {
			logger.error("delete err" + " " + e);
			throw new ServletException(e);
		}

		response.sendRedirect(PAGE_ALL_NEWS);
	}
}
