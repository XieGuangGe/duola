package com.pb.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pb.entity.Bill;
import com.pb.service.impl.BillServiceImpl;

@WebServlet("/UpateServlet")
public class UpateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("=====����ִ���޸Ĳ���=====");
		int idd= (int) request.getSession().getAttribute("upid");
		int money = Integer.parseInt(request.getParameter("money"));
		String unit= request.getParameter("unit");
		int counts=Integer.parseInt(request.getParameter("counts"));
		String productName=request.getParameter("productName");
		String productDesc =request.getParameter("productDesc");
		int ispay=Integer.parseInt(request.getParameter("isPay"));
		int provider_id=Integer.parseInt(request.getParameter("provider"));
		Date date = new Date();//��ȡ��ǰʱ��
		SimpleDateFormat tempDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String datetime = tempDate.format(date); 
		System.out.println("Ҫ�޸ĵ�ids��"+idd+"	Ҫ�޸ĵĽ�"+money+"	Ҫ�޸ĵĵ�λ��"+unit
				+"	Ҫ�޸ĵ�������"+counts+"	Ҫ�޸ĵ���Ʒ���֣�"+productName+
				"	Ҫ�޸ĵı�ע��"+productDesc+"		Ҫ�޸ĵĽ���״̬��"+ispay
				+"	Ҫ�޸ĵĶ����̱��"+provider_id);
		Bill bill = new Bill();
		bill.setBill_money(money); bill.setBill_time(datetime);
		bill.setCounts(counts); bill.setId(idd);
		bill.setIspay(ispay); bill.setPeovider_id(provider_id);
		bill.setProduct_desc(productDesc); bill.setProduct_name(productName);
		bill.setUnit(unit); 
		BillServiceImpl service = new BillServiceImpl();
		boolean flag=service.update(bill);
		PrintWriter out = response.getWriter();
		if (flag==true) {
			System.out.println("�޸ĳɹ�");
			out.print("<script>alert('�޸ĳɹ���');</script>");
			response.sendRedirect("BillStudentServlet");
		}else {
			System.out.println("�޸�ʧ��");
			out.print("<script>alert('�޸�ʧ�ܣ�');</script>");
			response.sendRedirect("SerachUpdatebillServlet");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
