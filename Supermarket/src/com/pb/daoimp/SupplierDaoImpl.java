package com.pb.daoimp;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;

import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

import com.pb.dao.BaseDao;
import com.pb.dao.SupplierDao;
import com.pb.entity.Supplier;

public class SupplierDaoImpl extends BaseDao implements SupplierDao {

	// 查询所有的供应商
	@Override
	public List<Supplier> seachAllSupplier() {
		
		
		Session session=new Configuration().configure().buildSessionFactory().openSession();
		String hql="from Supplier";
		
		Query query = session.createQuery(hql);
		List<Supplier> list=query.list();
		session.close();
		return list;
		
		
		/*List<Supplier> supplierlist = new ArrayList<Supplier>();
		String sql = "select * from supplier";
		Object[] params = {};
		try {
			rs = this.executeSQL(sql, params);
			while (rs.next()) {
				Supplier supplier = new Supplier();
				supplier.setId(rs.getInt("id"));
				supplier.setPro_name(rs.getString("pro_name"));
				supplier.setPro_desc(rs.getString("pro_desc"));
				supplier.setPro_contact(rs.getString("pro_contact"));
				supplier.setPro_phone(rs.getString("pro_phone"));
				supplier.setPro_address(rs.getString("pro_address"));
				supplier.setPro_fax(rs.getString("pro_fax"));
				supplierlist.add(supplier);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.closeAll();
		}
		return supplierlist;*/
	}

	// 添加供应商
	@Override
	public boolean insertSupplier(Supplier supplier) {
		boolean flag = false;
		Session session=new Configuration().configure().buildSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		session.save(supplier);
		tx.commit();
		flag=true;
		session.close();
		return flag;
	}
		
		/*boolean flag = false;
		String sql = "insert into supplier values(SEQ_ORDER.nextval,?,?,?,?,?,?)";
		Object[] params = { supplier.getPro_name(), supplier.getPro_desc(), supplier.getPro_contact(),
				supplier.getPro_phone(), supplier.getPro_address(), supplier.getPro_fax() };
		try {
			int i = this.executeUpdate(sql, params);
			if (i > 0) {
				flag = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} finally {
			this.closeAll();
		}
		return flag;*/

	// 根据Id查询供应商

	@Override
	public Supplier seachByid(int id) {
		Session session=new Configuration().configure().buildSessionFactory().openSession();
		Supplier supplier=(Supplier) session.get(Supplier.class, id);
		session.close();
		return supplier;
		

		
		
		
		/*Supplier supplier = new Supplier();
		String sql = "select * from supplier where id=?";
		Object[] params = { id };
		rs = this.executeSQL(sql, params);
		try {
			if (rs.next()) {
				supplier.setId(rs.getInt("id"));
				supplier.setPro_name(rs.getString("pro_name"));
				supplier.setPro_desc(rs.getString("pro_desc"));
				supplier.setPro_contact(rs.getString("pro_contact"));
				supplier.setPro_phone(rs.getString("pro_phone"));
				supplier.setPro_address(rs.getString("pro_address"));
				supplier.setPro_fax(rs.getString("pro_fax"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return supplier;*/
	}

	// 修改
	@Override
	public boolean update(Supplier supplier) {
		boolean flag = false;
		Session session=new Configuration().configure().buildSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(supplier);
		
		tx.commit();
		flag=true;
		session.close();
		return flag;
	}
		
		
		
		/*boolean flag = false;
		String sql = "update supplier set pro_name=?,pro_desc=?,pro_contact=?,pro_phone=?,pro_address=?,pro_fax=? where id=?";
		Object[] params = { supplier.getPro_name(), supplier.getPro_desc(), supplier.getPro_contact(),
				supplier.getPro_phone(), supplier.getPro_address(), supplier.getPro_fax(), supplier.getId() };
		try {
			int i = this.executeUpdate(sql, params);
			if (i > 0) {
				flag = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.closeAll();
		}
		return flag;*/

	// 删除
	@Override
	public boolean delect(int id) {
		boolean flag = false;
		Session session=new Configuration().configure().buildSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		Supplier supplier=(Supplier) session.get(Supplier.class, id);
		session.delete(supplier);
		tx.commit();
		flag=true;
		session.close();
		return flag;
	}

		/*boolean flag = false;
		String sql = "delete from supplier where id=?";
		Object[] params = { id };
		try {
			int i = this.executeUpdate(sql, params);
			if (i > 0) {// 删除成功
				flag = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.closeAll();
		}
		return flag;*/
}
