package by.htp.itacademy.controller.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class CharsetFilter implements Filter {
	private String encoding;

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		request.setCharacterEncoding(encoding);
		response.setCharacterEncoding(encoding);

		chain.doFilter(request, response);

	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

		encoding = filterConfig.getInitParameter("characterEncoding");
	}

	@Override
	public void destroy() {
	}
}
