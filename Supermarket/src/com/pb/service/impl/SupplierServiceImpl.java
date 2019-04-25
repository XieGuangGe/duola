package com.pb.service.impl;

import java.util.List;

import com.pb.daoimp.SupplierDaoImpl;
import com.pb.entity.Supplier;
import com.pb.service.SupplierService;

public class SupplierServiceImpl implements SupplierService {
	SupplierDaoImpl sd = new SupplierDaoImpl();

	@Override
	public List<Supplier> seachAllSupplier() {
		return sd.seachAllSupplier();
	}

	@Override
	public boolean insertSupplier(Supplier supplier) {
		return sd.insertSupplier(supplier);
	}

	@Override
	public Supplier seachByid(int id) {
		return sd.seachByid(id);
	}

	@Override
	public boolean update(Supplier supplier) {
		return sd.update(supplier);
	}

	@Override
	public boolean delect(int id) {
		return sd.delect(id);
	}
}
