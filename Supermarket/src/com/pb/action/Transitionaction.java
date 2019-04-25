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

public class Transitionaction extends ActionSupport implements RequestAware,SessionAware{
	
	private Map<String, Object> reuqest;
	private Map<String, Object> session;
	private List<Supplier> supplierlist;
	
	

	public List<Supplier> getSupplierlist() {
		return supplierlist;
	}

	public void setSupplierlist(List<Supplier> supplierlist) {
		this.supplierlist = supplierlist;
	}

	public String login() {
		System.out.println("=====正在查询所有供货商=====");
		BillServiceImpl service = new BillServiceImpl();
		supplierlist = service.seachAllSupplier();
		session.put("supplierlist", supplierlist);
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
