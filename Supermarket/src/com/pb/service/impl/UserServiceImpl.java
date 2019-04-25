package com.pb.service.impl;

import java.util.List;

import com.pb.daoimp.UserDaoImpl;
import com.pb.entity.User;
import com.pb.service.UserService;

public class UserServiceImpl implements UserService {
	UserDaoImpl udpl = new UserDaoImpl();

	// 登录
	@Override
	public Object[] login(String name, String pwd) {
		return udpl.login(name, pwd);
	}
	//查询所有用户
	public List<User> researchAll() {
		return udpl.researchAll();
	}
	//添加用户
	public int userAdd(User user) {
		// TODO Auto-generated method stub
		return udpl.userAdd(user);
		
	}
	//修改密码
	public int uppswd(int id, String password) {
		return udpl.uppswd(id,password);
		
	}
	//根据ID获得其余内容
	public Object[] researchById(int id) {
		return udpl.researchById(id);
		
	}
	//更新用户信息
	public int updateUser(User user) {
		// TODO Auto-generated method stub
		return udpl.updateUser(user);
	}
	//删除用户
	public int deluser(int id) {
		// TODO Auto-generated method stub
		return udpl.deluser(id);
	}
	public int getSuperByName(String name) {
		return udpl.getSuperByName(name);
		
	}
	//当不为管理员时看到的界面
	public List<User> researchPerson(String name) {
		// TODO Auto-generated method stub
		return udpl.researchPerson(name);
	}
}
