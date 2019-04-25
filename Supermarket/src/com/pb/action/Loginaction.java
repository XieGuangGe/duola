package com.pb.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.pb.entity.Supplier;
import com.pb.entity.User;
import com.pb.service.impl.BillServiceImpl;
import com.pb.service.impl.UserServiceImpl;

public class Loginaction extends ActionSupport implements RequestAware, SessionAware {

	private Map<String, Object> reuqest;
	private Map<String, Object> session;
	private String username;
	private String password;
	
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String login() {
		UserServiceImpl serviceimpl = new UserServiceImpl();
		
		Object[] flag = serviceimpl.login(username, password);
		
		if (flag[0].equals(true)) {
			session.put("user", flag[1]);
			session.put("name", username);
			return "success";
		}else {
			return "error";
		}
		
	
	}

	@Override
	public void setSession(Map<String, Object> session) {
		// TODO Auto-generated method stub
		this.session = session;
	}

	@Override
	public void setRequest(Map<String, Object> reuqest) {
		// TODO Auto-generated method stub
		this.reuqest = reuqest;

	}

}
