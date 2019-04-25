package com.pb.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.pb.entity.Bill;
import com.pb.entity.Supplier;
import com.pb.entity.User;
import com.pb.service.impl.BillServiceImpl;
import com.pb.service.impl.UserServiceImpl;

public class Billidaction extends ActionSupport implements RequestAware,SessionAware{
	
	private Map<String, Object> reuqest;
	private Map<String, Object> session;
	private List<Supplier> list;
	private Bill bill;
	private int id;
	
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Supplier> getList() {
		return list;
	}

	public void setList(List<Supplier> list) {
		this.list = list;
	}

	public Bill getBill() {
		return bill;
	}

	public void setBill(Bill bill) {
		this.bill = bill;
	}

	public String login() {
	
    
		 System.out.println("====="+id);
		BillServiceImpl service = new BillServiceImpl();
	    bill=service.seachByid(id);
		 list=service.seachAllSupplier();
		reuqest.put("bill", bill);
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
