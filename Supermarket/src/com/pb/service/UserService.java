package com.pb.service;

import java.util.List;

import com.pb.entity.User;

public interface UserService {
	/// 登陆查询记录
	public Object[] login(String name, String pwd);
	//查询所有用户的方法
	public List<User> researchAll();
	//添加用户的方法
	public int userAdd(User user);
}
