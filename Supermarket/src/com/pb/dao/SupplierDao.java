package com.pb.dao;

import java.util.List;
import com.pb.entity.Supplier;

//��Ӧ�̽ӿ�
public interface SupplierDao {
	// �鿴���й�Ӧ��
	public List<Supplier> seachAllSupplier();

	// ��ӹ�Ӧ��
	public boolean insertSupplier(Supplier supplier);

	// ���ݱ�Ų�ѯһ����¼
	public Supplier seachByid(int id);

	// �޸����ݣ���
	public boolean update(Supplier supplier);

	// ɾ������(���ݱ�Ž���ɾ��)
	public boolean delect(int id);
}
