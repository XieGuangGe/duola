package com.pb.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.pb.entity.Bill;

import com.pb.service.impl.BillServiceImpl;


public class BillDeteteaction  implements RequestAware,SessionAware{
	private Map<String, Object> reuqest;
	private Map<String, Object> session;
	private int id;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String login() {
		
		BillServiceImpl service = new BillServiceImpl();
		boolean flag=service.delect(id);
		if (flag==true) {
			System.out.println("É¾³ý³É¹¦£¡");
			return "success";
		}
		return "error";
		
		
		
		
		
	}

	@Override
	public void setSession(Map<String, Object> session) {
		// TODO Auto-generated method stub
        this.session=session;
	}

	@Override
	public void setRequest(Map<String, Object> reuqest) {
		// TODO Auto-generated method stub
		this.reuqest=reuqest;
		
	}
}
