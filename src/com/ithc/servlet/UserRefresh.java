package com.ithc.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ithc.service.UserService;
import com.ithc.service.UserServiceImpl;
@WebServlet("/userRefresh")
public class UserRefresh extends HttpServlet{
	private UserService userService = new UserServiceImpl();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		String username = req.getParameter("username");
//		String password = req.getParameter("password");
		String name = req.getParameter("name");
		String gender = req.getParameter("gender");
		int permission = Integer.parseInt(req.getParameter("permission"));
		String remark = req.getParameter("remark");
		//点击grzx.jsp页面的保存按钮修改
		int code = userService.refresh(id,username,name,gender,permission,remark);
		if(code == 1){
			resp.sendRedirect("userGrzx?id="+id);
		}
	}
	
	
	

}
