package com.pb.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




import com.pb.service.impl.UserServiceImpl;

import bean.PageBean;
import bean.UserStudentServiceImpl;

/**
 * Servlet implementation class UserStudentServlet
 */
@WebServlet("/UserStudentServlet")
public class UserStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserStudentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	UserStudentServiceImpl impl=new UserStudentServiceImpl();
		// 1.������������
				/*request.setCharacterEncoding("utf-8");
				response.setCharacterEncoding("utf-8");*/
				// 2.��ȡǰ̨���ݹ�����ǰҳ��pc��
				String pcstr = request.getParameter("pc");
				int pc;
				// 3.��pc�����ж�
				if (pcstr == null || pcstr.trim().isEmpty()) {
					pc = 1;
				} else {
					
					pc = Integer.parseInt(pcstr);
				}
				int ps = 3;
				String name = request.getParameter("userName");
               
				request.setAttribute("namess", name);
				
				String loginname=(String) request.getSession().getAttribute("name");
				UserServiceImpl impl1=new UserServiceImpl();
				int supers=impl1.getSuperByName(loginname);

				// 4.��ȡpagebean
				PageBean pb = impl.getPageBean(pc, ps, name,supers,loginname);

				// 5.��pagebean����request����
				request.setAttribute("pb", pb);

				// 6.����ת����ǰ̨ҳ��
				request.getRequestDispatcher("userView.jsp").forward(request, response);
		
		
				
		
		
	}

}
