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
		System.out.println("=====正在执行修改操作=====");
		int idd= (int) request.getSession().getAttribute("upid");
		int money = Integer.parseInt(request.getParameter("money"));
		String unit= request.getParameter("unit");
		int counts=Integer.parseInt(request.getParameter("counts"));
		String productName=request.getParameter("productName");
		String productDesc =request.getParameter("productDesc");
		int ispay=Integer.parseInt(request.getParameter("isPay"));
		int provider_id=Integer.parseInt(request.getParameter("provider"));
		Date date = new Date();//获取当前时间
		SimpleDateFormat tempDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String datetime = tempDate.format(date); 
		System.out.println("要修改的ids："+idd+"	要修改的金额："+money+"	要修改的单位："+unit
				+"	要修改的数量："+counts+"	要修改的商品名字："+productName+
				"	要修改的备注："+productDesc+"		要修改的交易状态："+ispay
				+"	要修改的订单商编号"+provider_id);
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
			System.out.println("修改成功");
			out.print("<script>alert('修改成功！');</script>");
			response.sendRedirect("BillStudentServlet");
		}else {
			System.out.println("修改失败");
			out.print("<script>alert('修改失败！');</script>");
			response.sendRedirect("SerachUpdatebillServlet");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
