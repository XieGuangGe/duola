package com.pb.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pb.entity.Supplier;
import com.pb.service.impl.SupplierServiceImpl;

@WebServlet("/ModifyServlet")
public class ModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ModifyServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Supplier supplier = new Supplier();
		supplier.setId(Integer.parseInt(request.getParameter("proId")));
		supplier.setPro_name(request.getParameter("proName"));
		supplier.setPro_desc(request.getParameter("proDesc"));
		supplier.setPro_contact(request.getParameter("contact"));
		supplier.setPro_phone(request.getParameter("phone"));
		supplier.setPro_address(request.getParameter("address"));
		supplier.setPro_fax(request.getParameter("fax"));
		SupplierServiceImpl serviceimpl = new SupplierServiceImpl();
		boolean flag = serviceimpl.update(supplier);
		if(flag==true){//更新成功
			PrintWriter out = response.getWriter();
			out.print("<script>alert('更新成功');window.location.href='StudentServlet';</script>");
		}else{
			PrintWriter out = response.getWriter();
			out.print("<script>alert('更新失败');window.location.href='StudentServlet';</script>");
		}
	}
}
