package com.pb.service;

import java.util.List;

import com.pb.entity.User;

public interface UserService {
	/// ��½��ѯ��¼
	public Object[] login(String name, String pwd);
	//��ѯ�����û��ķ���
	public List<User> researchAll();
	//����û��ķ���
	public int userAdd(User user);
}
