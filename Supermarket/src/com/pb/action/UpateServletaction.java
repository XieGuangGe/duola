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

public class UpateServletaction extends ActionSupport implements RequestAware,SessionAware{
	
	private Map<String, Object> reuqest;
	private Map<String, Object> session;
	private Bill bill;
	
	
	private String product_name;// 商品名称
	private String product_desc;// 商品描述

	private int peovider_id;// 供应商编号
	private int ispay;// 是否付款1付0没付
	private int bill_money;// 账单报价
	private String unit;// 单位
	private int counts;// 数量
	

	public Bill getBill() {
		return bill;
	}

	public void setBill(Bill bill) {
		this.bill = bill;
	}



	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public String getProduct_desc() {
		return product_desc;
	}

	public void setProduct_desc(String product_desc) {
		this.product_desc = product_desc;
	}

	public int getPeovider_id() {
		return peovider_id;
	}

	public void setPeovider_id(int peovider_id) {
		this.peovider_id = peovider_id;
	}

	public int getIspay() {
		return ispay;
	}

	public void setIspay(int ispay) {
		this.ispay = ispay;
	}

	public int getBill_money() {
		return bill_money;
	}

	public void setBill_money(int bill_money) {
		this.bill_money = bill_money;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public int getCounts() {
		return counts;
	}

	public void setCounts(int counts) {
		this.counts = counts;
	}

	/**
	 * @return
	 */
	public String login() {
		System.out.println("==========+");
		
		//int idd=Integer.parseInt(ServletActionContext.getRequest().getSession().getAttribute("upid").toString());
		System.out.println("-----"+bill.getId()+"++++");
		bill.setId(bill.getId());
		
		
		BillServiceImpl service = new BillServiceImpl();
		Date date = new Date();//获取当前时间
		SimpleDateFormat tempDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String datetime = tempDate.format(date); 
		
		
		
		
		System.out.println("+++++"+bill.getId());
		bill.setProduct_name(product_name);
		bill.setProduct_desc(product_desc);
		bill.setPeovider_id(peovider_id);
		bill.setIspay(ispay);
		bill.setBill_money(bill_money);
		bill.setUnit(unit);
		bill.setCounts(counts);
		bill.setBill_time(datetime);
		boolean flag=service.update(bill);
		
		if (flag==true) {
			System.out.println("修改成功");
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
