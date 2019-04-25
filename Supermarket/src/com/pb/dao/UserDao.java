package com.pb.dao;

import java.util.List;

import com.pb.entity.User;

public interface UserDao {
	// 登陆查询记录
	public Object[] login(String name, String pwd);

	// 查询所有用户信息
	public List<User> researchAll();

	// 添加用户
	public int userAdd(User user);

	// 修改密码
	public int uppswd(int id, String password);

}
