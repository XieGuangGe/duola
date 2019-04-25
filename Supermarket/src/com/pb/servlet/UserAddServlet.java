package com.pb.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pb.entity.User;
import com.pb.service.impl.UserServiceImpl;

/**
 * Servlet implementation class UserAdd
 */
@WebServlet("/UserAddServlet")
public class UserAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserAddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserServiceImpl impl=new UserServiceImpl();
		System.out.println("---------------------被执行");
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String strSex=request.getParameter("sex");
		int sex=Integer.parseInt(strSex);
		String strAge=request.getParameter("age");
		int age=Integer.parseInt(strAge);
		String mobile=request.getParameter("mobile");
		String address=request.getParameter("address");
		String strAuth=request.getParameter("auth");
		int auth=Integer.parseInt(strAuth);
		
		User user=new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setSex(sex);
		user.setAge(age);
		user.setMobile(mobile);
		user.setAddress(address);
		user.setSupers(auth);
		
		int i=impl.userAdd(user);
		if(i>0){
			request.getRequestDispatcher("UserStudentServlet").forward(request, response);
		}else{
			request.getRequestDispatcher("userAdd.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("---------------------被调用");
		doGet(request, response);
	}

}
