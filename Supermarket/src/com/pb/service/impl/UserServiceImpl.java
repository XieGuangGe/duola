package com.pb.service.impl;

import java.util.List;

import com.pb.daoimp.UserDaoImpl;
import com.pb.entity.User;
import com.pb.service.UserService;

public class UserServiceImpl implements UserService {
	UserDaoImpl udpl = new UserDaoImpl();

	// ��¼
	@Override
	public Object[] login(String name, String pwd) {
		return udpl.login(name, pwd);
	}
	//��ѯ�����û�
	public List<User> researchAll() {
		return udpl.researchAll();
	}
	//����û�
	public int userAdd(User user) {
		// TODO Auto-generated method stub
		return udpl.userAdd(user);
		
	}
	//�޸�����
	public int uppswd(int id, String password) {
		return udpl.uppswd(id,password);
		
	}
	//����ID�����������
	public Object[] researchById(int id) {
		return udpl.researchById(id);
		
	}
	//�����û���Ϣ
	public int updateUser(User user) {
		// TODO Auto-generated method stub
		return udpl.updateUser(user);
	}
	//ɾ���û�
	public int deluser(int id) {
		// TODO Auto-generated method stub
		return udpl.deluser(id);
	}
	public int getSuperByName(String name) {
		return udpl.getSuperByName(name);
		
	}
	//����Ϊ����Աʱ�����Ľ���
	public List<User> researchPerson(String name) {
		// TODO Auto-generated method stub
		return udpl.researchPerson(name);
	}
}
