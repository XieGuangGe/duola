package com.pb.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pb.entity.Bill;
import com.pb.entity.Supplier;
import com.pb.service.impl.BillServiceImpl;

//修改功能的Servlet
@WebServlet("/SerachUpdatebillServlet")
public class SerachUpdatebillServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("=====正在查询修改的原始数据=====");
		int id = Integer.parseInt(request.getParameter("id"));
		System.out.println("要修改的订单id是："+id);
		request.getSession().setAttribute("upid", id);
		//要根据要修改的订单id查询原始数据
		BillServiceImpl service = new BillServiceImpl();
		Bill bill = service.seachByid(id);
		request.setAttribute("bill", bill);
		//要查找到所有的供应商
		List<Supplier> list=service.seachAllSupplier();
		request.setAttribute("list", list);
		request.getRequestDispatcher("billAMLast.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
