package com.pb.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pb.entity.Supplier;
import com.pb.service.impl.SupplierServiceImpl;

/**
 * Servlet implementation class ProAddServlet
 */
@WebServlet("/ProAddServlet")
public class ProAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ProAddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String pro_name = request.getParameter("proName");
		String pro_desc = request.getParameter("proDesc");
		String pro_contact = request.getParameter("contact");
	
		String pro_phone = request.getParameter("phone");
		String pro_fax = request.getParameter("fax");
		String pro_address = request.getParameter("address");
		System.out.println(pro_name+"	"+pro_desc+"	"+pro_contact 	);
		SupplierServiceImpl serviceimpl = new SupplierServiceImpl();
		//实例化一个对象
		Supplier supplier = new Supplier();
		
		//给对象赋值
		supplier.setPro_name(pro_name);		
		supplier.setPro_contact(pro_contact);
		supplier.setPro_desc(pro_desc);
		supplier.setPro_fax(pro_fax);
		supplier.setPro_phone(pro_phone);
		supplier.setPro_address(pro_address);
		
		boolean flag = serviceimpl.insertSupplier(supplier);
		if(flag){
			//添加成功
			System.out.println("添加成功");
			response.sendRedirect("StudentServlet");
		}else{
			//添加失败
			System.out.println("添加失败");
			response.sendRedirect("proAdd.jsp");
		}
	}

}
