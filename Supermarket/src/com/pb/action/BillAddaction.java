package com.pb.action;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
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

public class BillAddaction extends ActionSupport implements RequestAware,SessionAware{
	
	private Map<String, Object> reuqest;
	private Map<String, Object> session;
	private Bill bill;
	

	
	public Bill getBill() {
		return bill;
	}

	public void setBill(Bill bill) {
		this.bill = bill;
	}

	public String login() {
		System.out.println("========+++");
		Date date = new Date();//获取当前时间
		SimpleDateFormat tempDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String datetime = tempDate.format(date); 
		bill.setBill_time(datetime);
		BillServiceImpl service = new BillServiceImpl();
		boolean flag=service.insertBill(bill);
		
		
		if (flag==true) {
			System.out.println("添加成功");
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
