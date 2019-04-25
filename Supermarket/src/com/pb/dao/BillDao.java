package com.pb.dao;

import java.util.List;

import com.pb.entity.Bill;
import com.pb.entity.Supplier;

//�˵�
public interface BillDao {
	//�鿴�����˵�
	public List<Bill> seachAllBill();
	//������Ʒ���ƺ��Ƿ񸶿��ѯ��¼
	public List<Bill> seachByName(String name,int ispay);
	//�������
	public boolean insertBill(Bill bill);
	//���ݱ�Ų�ѯһ����¼
	public Bill seachByid(int id);
	//�޸����ݣ����ݱ�Ž����޸ģ�
	public boolean update(Bill bill);
	//ɾ������(���ݱ�Ž���ɾ��)
	public boolean delect(int id);
	//��ѯ���й�Ӧ��
	public List<Supplier> seachAllSupplier();
	
}
