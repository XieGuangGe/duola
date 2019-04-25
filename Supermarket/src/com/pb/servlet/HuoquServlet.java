package com.pb.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pb.entity.Supplier;
import com.pb.service.impl.SupplierServiceImpl;

@WebServlet("/HuoquServlet")
public class HuoquServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SupplierServiceImpl service=new SupplierServiceImpl();
		int id = Integer.parseInt(request.getParameter("id"));
		System.out.println("要查询的供应商id："+id);
		Supplier supplier = service.seachByid(id);
		request.setAttribute("sss", supplier);
		request.getRequestDispatcher("proAM.jsp").forward(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
