package com.ithc.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ithc.bean.User;
import com.ithc.service.UserService;
import com.ithc.service.UserServiceImpl;
@WebServlet("/userGrzx")
public class UserGrzx extends HttpServlet{

	private UserService userService = new UserServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//用id去查询
		String sid = req.getParameter("id");
		int id = Integer.parseInt(sid);
		//用id去查询
		User user = userService.findById(id);
		
		HttpSession session = req.getSession();
		session.removeAttribute("user");
		session.setAttribute("user", user);
		req.getRequestDispatcher("WEB-INF/views/grzx.jsp").forward(req, resp);
		
	}
	
	

}
