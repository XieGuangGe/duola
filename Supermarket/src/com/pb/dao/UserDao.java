package com.pb.dao;

import java.util.List;

import com.pb.entity.User;

public interface UserDao {
	// ��½��ѯ��¼
	public Object[] login(String name, String pwd);

	// ��ѯ�����û���Ϣ
	public List<User> researchAll();

	// ����û�
	public int userAdd(User user);

	// �޸�����
	public int uppswd(int id, String password);

}
