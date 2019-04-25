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

@WebServlet("/BillAddServlet")
public class BillAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean flag=false;
		int bill_money=Integer.parseInt(request.getParameter("money"));//��ȡ���׽�ת��Ϊint����
		String unit=request.getParameter("unit");//��ȡ���׵�λ
		int counts=Integer.parseInt(request.getParameter("counts"));//��ȡ��������
		String product_name=request.getParameter("productName");//��ȡ��Ʒ����
		String product_desc=request.getParameter("productDesc"); //��ȡ��Ʒ����
		int ispay = Integer.parseInt(request.getParameter("isPay"));//��ȡ������Ϣ
		int pro_name = Integer.parseInt(request.getParameter("provider"));//��ȡ��˾����
		Date date = new Date();//��ȡ��ǰʱ��
		SimpleDateFormat tempDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String datetime = tempDate.format(date); 
		//����ȡ������Ʒ��Ϣ��װ��Bill��
		Bill bill = new Bill();
		bill.setBill_money(bill_money);
		bill.setUnit(unit);
		bill.setCounts(counts);
		bill.setProduct_name(product_name);
		bill.setProduct_desc(product_desc);
		bill.setBill_time(datetime);
		bill.setIspay(ispay);
		bill.setPeovider_id(pro_name);
		BillServiceImpl service = new BillServiceImpl();
		flag=service.insertBill(bill);
		PrintWriter out = response.getWriter();
		if (flag) {
			System.out.println("��ӳɹ���");
			out.print("<script>alert('��ӳɹ���');</script>");
			response.sendRedirect("BillStudentServlet");
		}else {
			System.out.println("���ʧ�ܣ�");
			out.print("<script>alert('���ʧ�ܣ�')</script>");
			response.sendRedirect("Transition");
		}
		System.out.println("+++++��˾���ƣ�"+pro_name);
		System.out.println("��Ʒ���ƣ�"+product_name);
		System.out.println("��Ʒ����:"+product_desc);
		System.out.println("���׵�λ:"+unit);
		System.out.println("��������:"+counts);
		System.out.println("���׽�"+bill_money);
		System.out.println("��ǰʱ�䣺"+datetime);
		System.out.println("�Ƿ񸶿"+ispay);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
