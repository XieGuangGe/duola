package com.pb.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.pb.entity.Bill;
import com.pb.entity.Supplier;
import com.pb.service.impl.BillServiceImpl;

public class SerachUpdatebillaction extends ActionSupport implements RequestAware, SessionAware {
	private Map<String, Object> reuqest;
	private Map<String, Object> session;
	private int id;
	private Bill bill;
	private List<Supplier> list;

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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String login() {

		System.out.println("要修改的订单id是：" + id);
		session.put("upid", id);

		// 要根据要修改的订单id查询原始数据
		BillServiceImpl service = new BillServiceImpl();
		bill = service.seachByid(id);
		reuqest.put("bill", bill);

		// 要查找到所有的供应商
		list = service.seachAllSupplier();

		reuqest.put("list", list);
		return "success";

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
