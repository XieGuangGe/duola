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
		// 查看所有账单
		return dao.seachAllBill();
	}

	@Override
	public List<Bill> seachByName(String name, int ispay) {
		// 根据商品名称和是否付款查询记录
		return dao.seachByName(name, ispay);
	}

	@Override
	public boolean insertBill(Bill bill) {
		// 添加数据
		return dao.insertBill(bill);
	}

	@Override
	public Bill seachByid(int id) {
		// 根据编号查询一条记录
		return dao.seachByid(id);
	}

	@Override
	public boolean update(Bill bill) {
		// 修改数据（根据编号进行修改）
		return dao.update(bill);
	}

	@Override
	public boolean delect(int id) {
		// 删除数据(根据编号进行删除)
		return dao.delect(id);
	}

	@Override
	public List<Supplier> seachAllSupplier() {
		// 查询所有供应商
		return dao.seachAllSupplier();
	}

}
