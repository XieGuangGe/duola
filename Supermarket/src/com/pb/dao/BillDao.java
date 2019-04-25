package com.pb.dao;

import java.util.List;

import com.pb.entity.Bill;
import com.pb.entity.Supplier;

//账单
public interface BillDao {
	//查看所有账单
	public List<Bill> seachAllBill();
	//根据商品名称和是否付款查询记录
	public List<Bill> seachByName(String name,int ispay);
	//添加数据
	public boolean insertBill(Bill bill);
	//根据编号查询一条记录
	public Bill seachByid(int id);
	//修改数据（根据编号进行修改）
	public boolean update(Bill bill);
	//删除数据(根据编号进行删除)
	public boolean delect(int id);
	//查询所有供应商
	public List<Supplier> seachAllSupplier();
	
}
