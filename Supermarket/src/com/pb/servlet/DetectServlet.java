package com.pb.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pb.service.impl.BillServiceImpl;

@WebServlet("/DetectServlet")
public class DetectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("=====正在执行删除功能=====");
		int id = Integer.parseInt(request.getParameter("id"));
		BillServiceImpl service = new BillServiceImpl();
		boolean flag=service.delect(id);
		PrintWriter out = response.getWriter();
		if (flag==true) {
			System.out.println("删除成功！");
			out.print("<script>alert('删除成功！');</script>");
			response.sendRedirect("BillStudentServlet");
		}else{
			System.out.println("删除失败！");
			out.print("<script>alert('删除失败！');</script>");
			response.sendRedirect("BillStudentServlet");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
