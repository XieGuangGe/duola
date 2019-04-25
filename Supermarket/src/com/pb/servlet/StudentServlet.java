package com.pb.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import bean.PageBean;
import bean.StudentServiceImpl;

/**
 * Servlet implementation class StudentServlet
 */
@WebServlet("/StudentServlet")
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public StudentServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		StudentServiceImpl impl = new StudentServiceImpl();
		// 1.设置中文乱码
		//request.setCharacterEncoding("utf-8");
		// 2.获取前台传递过来当前页（pc）
		String pcstr = request.getParameter("pc");
		int pc;
		// 3.对pc进行判断
		if (pcstr == null || pcstr.trim().isEmpty()) {
			pc = 1;
		} else {
			
			pc = Integer.parseInt(pcstr);
		}
		int ps = 3;

		String providerName = request.getParameter("providerName");
		String providerDesc = request.getParameter("providerDesc");
		
		request.setAttribute("namess", providerName);
		request.setAttribute("descs", providerDesc);

		// 4.获取pagebean
		PageBean pb = impl.getPageBean(pc, ps, providerName, providerDesc);

		// 5.将pagebean放入request域中
		request.setAttribute("pb", pb);

		// 6.请求转发到前台页面
		request.getRequestDispatcher("proView.jsp").forward(request, response);
	}

}
