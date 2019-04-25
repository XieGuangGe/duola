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

@WebServlet("/ConditionalQueryServlet")
//������Ʒ���ƺ��Ƿ񸶿������������ҵ�Servlet
public class ConditionalQueryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("=====���ڰ���������=====");
		BillServiceImpl service = new BillServiceImpl();
		String name = request.getParameter("productName");
		int ispay = Integer.parseInt(request.getParameter("query_isPay"));
		
		List<Bill> list=service.seachByName(name, ispay);//����������ѯ
		request.setAttribute("list", list);
		request.getRequestDispatcher("billView.jsp").forward(request, response);//ת�����˵�jspҳ��
		System.out.println("��ѯ��������������"+name);
		System.out.println("�Ƿ񸶿"+ispay);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
