package com.pb.entity;
//供应商
public class Supplier {
	private int id;//id
	private String pro_name;//供应商名称
	private String pro_desc;//供应商简介
	private String pro_contact;//供应商联系人
	private String pro_phone;//供应商电话
	private String pro_address;//供应商地址
	private String pro_fax;//供应商传真
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPro_name() {
		return pro_name;
	}
	public void setPro_name(String pro_name) {
		this.pro_name = pro_name;
	}
	public String getPro_desc() {
		return pro_desc;
	}
	public void setPro_desc(String pro_desc) {
		this.pro_desc = pro_desc;
	}
	public String getPro_contact() {
		return pro_contact;
	}
	public void setPro_contact(String pro_contact) {
		this.pro_contact = pro_contact;
	}
	public String getPro_phone() {
		return pro_phone;
	}
	public void setPro_phone(String pro_phone) {
		this.pro_phone = pro_phone;
	}
	public String getPro_address() {
		return pro_address;
	}
	public void setPro_address(String pro_address) {
		this.pro_address = pro_address;
	}
	public String getPro_fax() {
		return pro_fax;
	}
	public void setPro_fax(String pro_fax) {
		this.pro_fax = pro_fax;
	}
	public Supplier(int id, String pro_name, String pro_desc,
			String pro_contact, String pro_phone, String pro_address,
			String pro_fax) {
		super();
		this.id = id;
		this.pro_name = pro_name;
		this.pro_desc = pro_desc;
		this.pro_contact = pro_contact;
		this.pro_phone = pro_phone;
		this.pro_address = pro_address;
		this.pro_fax = pro_fax;
	}
	public Supplier() {
		super();
	}
	
	
	
	

}
