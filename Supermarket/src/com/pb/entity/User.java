package com.pb.entity;

//用户
public class User {
	private int id;// 用户id
	private String username;// 用户名称
	private String password;// 用户密码
	private int sex;// 性别1男0女
	private int age;// 年龄
	private String mobile;// 手机
	private String address;// 地址
	private int common;// 是否是普通员工（1是0不是）
	private int supers;// 是否是经理（1是0不是）数据库中是super

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getCommon() {
		return common;
	}

	public void setCommon(int common) {
		this.common = common;
	}

	public int getSupers() {
		return supers;
	}

	public void setSupers(int supers) {
		this.supers = supers;
	}

	public User() {
		super();
	}

	public User(int id, String username, String password, int sex, int age, String mobile, String address, int common,
			int supers) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.sex = sex;
		this.age = age;
		this.mobile = mobile;
		this.address = address;
		this.common = common;
		this.supers = supers;
	}

}
