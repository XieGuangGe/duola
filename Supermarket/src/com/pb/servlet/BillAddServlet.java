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
		int bill_money=Integer.parseInt(request.getParameter("money"));//获取交易金额并转换为int类型
		String unit=request.getParameter("unit");//获取交易单位
		int counts=Integer.parseInt(request.getParameter("counts"));//获取交易数量
		String product_name=request.getParameter("productName");//获取商品名称
		String product_desc=request.getParameter("productDesc"); //获取商品描述
		int ispay = Integer.parseInt(request.getParameter("isPay"));//获取付款信息
		int pro_name = Integer.parseInt(request.getParameter("provider"));//获取公司名称
		Date date = new Date();//获取当前时间
		SimpleDateFormat tempDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String datetime = tempDate.format(date); 
		//将获取到的商品信息封装到Bill中
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
			System.out.println("添加成功！");
			out.print("<script>alert('添加成功！');</script>");
			response.sendRedirect("BillStudentServlet");
		}else {
			System.out.println("添加失败！");
			out.print("<script>alert('添加失败！')</script>");
			response.sendRedirect("Transition");
		}
		System.out.println("+++++公司名称："+pro_name);
		System.out.println("商品名称："+product_name);
		System.out.println("商品描述:"+product_desc);
		System.out.println("交易单位:"+unit);
		System.out.println("交易数量:"+counts);
		System.out.println("交易金额："+bill_money);
		System.out.println("当前时间："+datetime);
		System.out.println("是否付款："+ispay);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
