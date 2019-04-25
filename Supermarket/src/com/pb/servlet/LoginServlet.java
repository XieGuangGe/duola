package com.pb.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pb.service.impl.UserServiceImpl;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = request.getParameter("username");
		String pwd = request.getParameter("password");
		// 查询登陆是否正确
		UserServiceImpl serviceimpl = new UserServiceImpl();
		Object[] flag = serviceimpl.login(name, pwd);
		if (flag[0].equals(true)) {
			request.getSession().setAttribute("user", flag[1]);
			request.getSession().setAttribute("name", name);
			request.getRequestDispatcher("frame.jsp").forward(request, response);
		} else {
			PrintWriter out = response.getWriter();
			out.print("<script>alert('用户名或密码错误,请重新登录');window.location.href='login.jsp';</script>");
		}
	}
}
