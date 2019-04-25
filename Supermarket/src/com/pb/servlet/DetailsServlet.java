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

@WebServlet("/DetailsServlet")
public class DetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("=====正在读取数据详情=====");
		int id = Integer.parseInt(request.getParameter("id"));
		BillServiceImpl service = new BillServiceImpl();
		Bill bill=service.seachByid(id);
		List<Supplier> list=service.seachAllSupplier();
		request.setAttribute("bill", bill);
		request.setAttribute("list", list);
		request.getRequestDispatcher("billAM.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
