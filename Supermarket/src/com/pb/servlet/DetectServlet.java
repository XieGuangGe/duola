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
		System.out.println("=====����ִ��ɾ������=====");
		int id = Integer.parseInt(request.getParameter("id"));
		BillServiceImpl service = new BillServiceImpl();
		boolean flag=service.delect(id);
		PrintWriter out = response.getWriter();
		if (flag==true) {
			System.out.println("ɾ���ɹ���");
			out.print("<script>alert('ɾ���ɹ���');</script>");
			response.sendRedirect("BillStudentServlet");
		}else{
			System.out.println("ɾ��ʧ�ܣ�");
			out.print("<script>alert('ɾ��ʧ�ܣ�');</script>");
			response.sendRedirect("BillStudentServlet");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
