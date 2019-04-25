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

//�޸Ĺ��ܵ�Servlet
@WebServlet("/SerachUpdatebillServlet")
public class SerachUpdatebillServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("=====���ڲ�ѯ�޸ĵ�ԭʼ����=====");
		int id = Integer.parseInt(request.getParameter("id"));
		System.out.println("Ҫ�޸ĵĶ���id�ǣ�"+id);
		request.getSession().setAttribute("upid", id);
		//Ҫ����Ҫ�޸ĵĶ���id��ѯԭʼ����
		BillServiceImpl service = new BillServiceImpl();
		Bill bill = service.seachByid(id);
		request.setAttribute("bill", bill);
		//Ҫ���ҵ����еĹ�Ӧ��
		List<Supplier> list=service.seachAllSupplier();
		request.setAttribute("list", list);
		request.getRequestDispatcher("billAMLast.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
