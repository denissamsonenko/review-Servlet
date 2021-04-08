package by.htp.itacademy.controller.command.impl;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import by.htp.itacademy.controller.command.Command;

public class ChangeLocale implements Command {

	private static final String GET_REQUEST_URL = "Referer";
	private static final String PARAMETER_LOCAL = "local";
	private static final Logger logger = Logger.getLogger(ChangeLocale.class);

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.getSession(true).setAttribute("local", request.getParameter(PARAMETER_LOCAL));

		String page = request.getHeader(GET_REQUEST_URL);
		if (page == null) {
			logger.error("Header is null" + " " + page);
			throw new ServletException("request url is null");
		}

		response.sendRedirect(page);
	}
}