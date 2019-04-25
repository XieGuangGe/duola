package com.pb.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pb.service.impl.SupplierServiceImpl;

@WebServlet("/ProDeleteServlet")
public class ProDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ProDeleteServlet() {
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
		boolean flag = supplierservice.delect(id);
		if (flag == true) {// 删除成功重定向到显示servlet
			PrintWriter out = response.getWriter();
			out.print("<script>alert('删除成功');window.location.href='StudentServlet';</script>");
		}else{
			PrintWriter out = response.getWriter();
			out.print("<script>alert('删除失败，还有订单');window.location.href='StudentServlet';</script>");
		}
	}

}
