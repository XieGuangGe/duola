package com.pb.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.pb.entity.User;
import com.pb.service.impl.UserServiceImpl;

public class UserStudentaction extends ActionSupport implements RequestAware,SessionAware{
	private Map<String, Object> request;
	private Map<String, Object> session;
	List<User> list;
	
	
	public List<User> getList() {
		return list;
	}






	public void setList(List<User> list) {
		this.list = list;
	}






	public String login() {
		UserServiceImpl impl=new UserServiceImpl();
		System.out.println("____________________");
	String name=(String) ActionContext.getContext().getSession().get("name");
		System.out.println("++++++_____________________"+ActionContext.getContext().getSession().get("name"));
		int supers=impl.getSuperByName(name);
		
		if(supers==1){
			 list=impl.researchAll();
			 System.out.println("______"+list.get(0).getUsername());
			
		
		}else{
		 list=impl.researchPerson(name);
		
		}
		
		request.put("list", list);
	
	
		return "success";
		
	}
	
	
	@Override
	public void setSession(Map<String, Object> session) {
		// TODO Auto-generated method stub
		this.session=session;
	}

	@Override
	public void setRequest(Map<String, Object> request) {
		// TODO Auto-generated method stub
		this.request=request;
	}

}
