package com.pb.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pb.entity.Supplier;
import com.pb.service.impl.BillServiceImpl;

@WebServlet("/Transition")
public class Transition extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("=====正在查询所有供货商=====");
		BillServiceImpl service = new BillServiceImpl();
		List<Supplier> supplierlist = service.seachAllSupplier();//获取一个贮存所有供货商信息的集合
		request.getSession().setAttribute("supplierlist", supplierlist);
		request.getRequestDispatcher("billAdd.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
