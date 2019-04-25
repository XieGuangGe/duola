package com.pb.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.pb.entity.Bill;

import com.pb.service.impl.BillServiceImpl;


public class Billstudentaction  implements RequestAware,SessionAware{
	private Map<String, Object> reuqest;
	private Map<String, Object> session;
	private List<Bill> list;
	
	

	public List<Bill> getList() {
		return list;
	}

	public void setList(List<Bill> list) {
		this.list = list;
	}

	public String login() {
		BillServiceImpl service = new BillServiceImpl();
		List<Bill> list=service.seachAllBill();//查询到所有账单
		
		reuqest.put("list", list);
		
		return "success";
		
		
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
