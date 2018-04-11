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

@SuppressWarnings("all")
@WebServlet("/userLogin")
public class UserLogin extends HttpServlet {
	private UserService userService = new UserServiceImpl();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 获取登入信息的请求参数
		// 用户名 : username
		// 密码 :password
		/*
		 * 验证码 : codeName 如何判断验证码: validateCode(后台生成的，已经存入session里) 用 codeName 与
		 * 取出validateCode的值做比较
		 */
		String name = req.getParameter("username");
		String password = req.getParameter("password");
		String codeName = req.getParameter("codeName");
		// 获取后台生成的验证码
		HttpSession session = req.getSession();
		String vcode = (String) session.getAttribute("validateCode");
		// 去登入
		User user = userService.login(name, password);
		// 判断验证码
		if (codeName.equalsIgnoreCase(vcode) && user != null) {
			// 登入成功
			session.setAttribute("user", user);
			req.getRequestDispatcher("WEB-INF/views/index.jsp").forward(req, resp);
		} else {
			session.setAttribute("msg", "用户名或密码或验证码错误!!!");
			resp.sendRedirect("index.jsp");
		}
	}
}
