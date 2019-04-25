package com.pb.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pb.service.impl.UserServiceImpl;


/**
 * Servlet implementation class ChangePswd
 */
@WebServlet("/ChangePswd")
public class ChangePswd extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ChangePswd() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserServiceImpl impl=new UserServiceImpl();
		PrintWriter out = response.getWriter();
		String StrId=request.getParameter("id");
		int id=Integer.parseInt(StrId);
		String repswd=request.getParameter("repswd");
		String oldpwd=request.getParameter("oldpassword");
		//String oldpassword = Base64.encode(oldpwd.getBytes());
		
		String password=request.getParameter("password");
		/*if(repswd.equals(oldpassword)){
			int i=impl.uppswd(id,password);
			if(i>0){
				out.print("<script>alert('修改成功');window.location.href='UserStudentServlet';</script>");
			}else{
				out.print("<script>alert('修改失败');window.location.href='userChangePWD.jsp';</script>");

			}
		}else{
			out.print("<script>alert('密码不正确');window.location.href='userChangePWD.jsp';</script>");

		}*/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
