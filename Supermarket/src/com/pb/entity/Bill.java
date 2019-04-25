package com.pb.entity;

import java.io.Serializable;

//账单
public class Bill implements Serializable{
	private int id;
	private String product_name;// 商品名称
	private String product_desc;// 商品描述
	private String bill_time;// 账单时间
	private int peovider_id;// 供应商编号
	private int ispay;// 是否付款1付0没付
	private int bill_money;// 账单报价
	private String unit;// 单位
	private int counts;// 数量
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getBill_time() {
		return bill_time;
	}
	public void setBill_time(String bill_time) {
		this.bill_time = bill_time;
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
	public Bill(int id, String product_name, String product_desc,
			String bill_time, int peovider_id, int ispay, int bill_money,
			String unit, int counts) {
		super();
		this.id = id;
		this.product_name = product_name;
		this.product_desc = product_desc;
		this.bill_time = bill_time;
		this.peovider_id = peovider_id;
		this.ispay = ispay;
		this.bill_money = bill_money;
		this.unit = unit;
		this.counts = counts;
	}
	public Bill() {
		super();
	}

	
}
