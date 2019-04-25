package com.pb.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pb.entity.Bill;
import com.pb.service.impl.BillServiceImpl;

@WebServlet("/ConditionalQueryServlet")
//根据商品名称和是否付款两个条件查找的Servlet
public class ConditionalQueryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("=====正在按条件查找=====");
		BillServiceImpl service = new BillServiceImpl();
		String name = request.getParameter("productName");
		int ispay = Integer.parseInt(request.getParameter("query_isPay"));
		
		List<Bill> list=service.seachByName(name, ispay);//根据条件查询
		request.setAttribute("list", list);
		request.getRequestDispatcher("billView.jsp").forward(request, response);//转发到账单jsp页面
		System.out.println("查询条件（姓名）："+name);
		System.out.println("是否付款："+ispay);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
