package com.ithc.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/userExit")
public class UserExit extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//退出清除登入时存入session的用户信息
		HttpSession session = req.getSession();
		session.removeAttribute("user");
		
		//重新登入
		resp.sendRedirect("index.jsp");
		
	}

	
}
