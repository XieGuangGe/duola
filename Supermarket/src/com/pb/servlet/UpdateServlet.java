package com.pb.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pb.entity.Supplier;
import com.pb.service.impl.SupplierServiceImpl;

@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UpdateServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		SupplierServiceImpl supplierservice = new SupplierServiceImpl();
		int id = Integer.parseInt(request.getParameter("id"));
		Supplier modsupplier = supplierservice.seachByid(id);
		request.setAttribute("proInfo", modsupplier);
		request.getRequestDispatcher("proAMLast.jsp").forward(request, response);
	}
}
