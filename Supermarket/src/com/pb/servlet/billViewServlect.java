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

@WebServlet("/billViewServlect")
public class billViewServlect extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("=====账单查询功能正在执行======");
		BillServiceImpl service = new BillServiceImpl();
		List<Bill> list=service.seachAllBill();//查询到所有账单
		request.setAttribute("list", list);//对查询到的账单封装
		request.getRequestDispatcher("billView.jsp").forward(request, response);//转发到账单jsp页面
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
