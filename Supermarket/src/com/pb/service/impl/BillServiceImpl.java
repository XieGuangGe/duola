package com.pb.service.impl;

import java.util.List;

import com.pb.daoimp.BillDaoImpl;
import com.pb.entity.Bill;
import com.pb.entity.Supplier;
import com.pb.service.BillService;

public class BillServiceImpl implements BillService{
	BillDaoImpl dao = new BillDaoImpl();
	@Override
	public List<Bill> seachAllBill() {
		// �鿴�����˵�
		return dao.seachAllBill();
	}

	@Override
	public List<Bill> seachByName(String name, int ispay) {
		// ������Ʒ���ƺ��Ƿ񸶿��ѯ��¼
		return dao.seachByName(name, ispay);
	}

	@Override
	public boolean insertBill(Bill bill) {
		// �������
		return dao.insertBill(bill);
	}

	@Override
	public Bill seachByid(int id) {
		// ���ݱ�Ų�ѯһ����¼
		return dao.seachByid(id);
	}

	@Override
	public boolean update(Bill bill) {
		// �޸����ݣ����ݱ�Ž����޸ģ�
		return dao.update(bill);
	}

	@Override
	public boolean delect(int id) {
		// ɾ������(���ݱ�Ž���ɾ��)
		return dao.delect(id);
	}

	@Override
	public List<Supplier> seachAllSupplier() {
		// ��ѯ���й�Ӧ��
		return dao.seachAllSupplier();
	}

}
