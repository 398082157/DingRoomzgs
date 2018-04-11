package com.ithc.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ithc.service.UserService;
import com.ithc.service.UserServiceImpl;

import jdk.nashorn.internal.ir.RuntimeNode.Request;
@WebServlet("/userUpdatePassword")
public class UserUpdatePassword extends HttpServlet{

	private	UserService userService = new UserServiceImpl();
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//获取id与密码
		
		String uid = req.getParameter("id");
		int id = Integer.parseInt(uid);
		String password = req.getParameter("password");
		//根据id修改密码
		int code = userService.updatePassword(id,password);
		if(code == 1){
			//修改成功，重新登入
			resp.sendRedirect("index.jsp");
		}else{
			HttpSession session = req.getSession();
			session.setAttribute("up", "修改失败！！");
			resp.sendRedirect("userGrzx?id="+id);
		}
	}

	
}
