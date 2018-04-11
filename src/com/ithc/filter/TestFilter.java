package com.ithc.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class TestFilter implements Filter {

	private String encoding;

	@Override
	public void init(FilterConfig fc) throws ServletException {
		encoding = fc.getInitParameter("encoding");
		if(encoding == null){
			encoding = "UTF-8";
		}
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		
		req.setCharacterEncoding(encoding);
		
		chain.doFilter(req, resp);
	}

	@Override
	public void destroy() {
		
	}

}
