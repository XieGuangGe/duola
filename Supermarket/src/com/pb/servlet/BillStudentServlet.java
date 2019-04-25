package com.pb.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.BillStudentServiceImpl;
import bean.PageBean;

/**
 * Servlet implementation class BillStudentServlet
 */
@WebServlet("/BillStudentServlet")
public class BillStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BillStudentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		BillStudentServiceImpl impl=new BillStudentServiceImpl();
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
				String name = request.getParameter("productName");
				
				String is=request.getParameter("query_isPay");
				int ispay;
				if (is==null) {
					ispay=-1;
				} else {
					ispay = Integer.parseInt(is);
				}
					
				
				//int ispay = Integer.parseInt(request.getParameter("query_isPay"));
			
				request.setAttribute("namess", name);
				request.setAttribute("ispays", ispay);

				// 4.获取pagebean
				PageBean pb = impl.getPageBean(pc, ps, name, ispay);

				// 5.将pagebean放入request域中
				request.setAttribute("pb", pb);

				// 6.请求转发到前台页面
				request.getRequestDispatcher("billView.jsp").forward(request, response);
		
		
		
	}

}
