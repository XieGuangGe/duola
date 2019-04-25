package com.pb.service;

import java.util.List;


import com.pb.entity.Supplier;

public interface SupplierService {

	// 查看所有供应商
		public List<Supplier> seachAllSupplier();

		// 添加供应商
		public boolean insertSupplier(Supplier supplier);

		// 根据编号查询一条记录
		public Supplier seachByid(int id);

		// 修改数据（）
		public boolean update(Supplier supplier);

		// 删除数据(根据编号进行删除)
		public boolean delect(int id);

}
