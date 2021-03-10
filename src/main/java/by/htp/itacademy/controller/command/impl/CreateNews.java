package by.htp.itacademy.controller.command.impl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.itacademy.controller.command.Command;

public class CreateNews implements Command{
	
	private static final String CREATE_PAGE = "/WEB-INF/jsp/createnews.jsp";

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(CREATE_PAGE);
        requestDispatcher.forward(request, response);
	}
}
