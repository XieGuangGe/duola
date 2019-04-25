package com.pb.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pb.entity.User;
import com.pb.service.impl.UserServiceImpl;

/**
 * Servlet implementation class UpdateSucServlet
 */
@WebServlet("/UpdateSucServlet")
public class UpdateSucServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateSucServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserServiceImpl impl=new UserServiceImpl();
		PrintWriter out = response.getWriter();
		String strId=request.getParameter("userId");
		int id=Integer.parseInt(strId);
		String username=request.getParameter("username");
		String strSex=request.getParameter("sex");
		int sex=Integer.parseInt(strSex);
		String strAge=request.getParameter("age");
		int age=Integer.parseInt(strAge);
		String mobile=request.getParameter("mobile");
		String address=request.getParameter("address");
		String strAuth=request.getParameter("auth");
		int auth=Integer.parseInt(strAuth);
		
		User user=new User();
		user.setId(id);
		user.setUsername(username);
		user.setSex(sex);
		user.setAge(age);
		user.setMobile(mobile);
		user.setAddress(address);
		user.setSupers(auth);
		
		int i=impl.updateUser(user);
		if(i>0){
			out.print("<script>alert('修改成功');window.location.href='UserStudentServlet';</script>");
		}else{
			out.print("<script>alert('修改失败');window.location.href='UserStudentServlet';</script>");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
