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

@WebServlet("/billViewServlect")
public class billViewServlect extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("=====�˵���ѯ��������ִ��======");
		BillServiceImpl service = new BillServiceImpl();
		List<Bill> list=service.seachAllBill();//��ѯ�������˵�
		request.setAttribute("list", list);//�Բ�ѯ�����˵���װ
		request.getRequestDispatcher("billView.jsp").forward(request, response);//ת�����˵�jspҳ��
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
