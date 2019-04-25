package com.pb.daoimp;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

import com.pb.dao.BaseDao;
import com.pb.dao.BillDao;
import com.pb.entity.Bill;
import com.pb.entity.Supplier;


public class BillDaoImpl extends BaseDao implements BillDao {

	@Override
	public List<Bill> seachAllBill() {
		
		Session session=new Configuration().configure().buildSessionFactory().openSession();
		String hql="from Bill";
		Query query = session.createQuery(hql);
		List<Bill> list=query.list();
		session.close();
		return list;
		// TODO Auto-generated method stub
		/*List<Bill> list = new ArrayList<Bill>();
		conn = this.getConnection();
		String sql = "select *from bill";
		try {
			Object[] parm = {};
			rs = this.executeSQL(sql, parm);
			while (rs.next()) {
				Bill bill = new Bill();
				bill.setId(rs.getInt("id"));
				bill.setProduct_name(rs.getString("product_name"));
				bill.setProduct_desc(rs.getString("product_desc"));
				bill.setBill_time(rs.getString("bill_time"));
				bill.setPeovider_id(rs.getInt("peovider_id"));
				bill.setIspay(rs.getInt("ispay"));
				bill.setBill_money(rs.getInt("bill_money"));
				bill.setUnit(rs.getString("unit"));
				bill.setCounts(rs.getInt("counts"));
				list.add(bill);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;*/
	}

	@Override
	public List<Bill> seachByName(String name, int ispay) {
		// TODO Auto-generated method stub
		Session session=new Configuration().configure().buildSessionFactory().openSession();
		String hql="from Bill where product_name=? and ispay=?";
		Query query = session.createQuery(hql);
		query.setString(0, name);
		query.setInteger(1, ispay);
		List<Bill> list=query.list();
		session.close();
		return list;
		
		/*List<Bill> list = new ArrayList<Bill>();
		conn = this.getConnection();
		String sql = "select *from bill where product_name=? and ispay=?";
		Object[] params = { name, ispay };
		rs = this.executeSQL(sql, params);
		try {
			while (rs.next()) {
				Bill bill = new Bill();
				bill.setId(rs.getInt("id"));
				bill.setProduct_name(rs.getString("product_name"));
				bill.setProduct_desc(rs.getString("product_desc"));
				bill.setBill_time(rs.getString("bill_time"));
				bill.setPeovider_id(rs.getInt("peovider_id"));
				bill.setIspay(rs.getInt("ispay"));
				bill.setBill_money(rs.getInt("bill_money"));
				bill.setUnit(rs.getString("unit"));
				bill.setCounts(rs.getInt("counts"));
				list.add(bill);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;*/
	}

	@Override
	public boolean insertBill(Bill bill) {
		// TODO Auto-generated method stub
		boolean flag=false;
		Session session=new Configuration().configure().buildSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		try {
			Serializable ser= session.save(bill);
			System.out.println(ser);
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			tx.rollback();
			
			e.printStackTrace();
		}
        try {
			tx.commit();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			flag=false;
		}finally {
			flag=true;
		}
        
		session.close();

		return flag;
		
		
		/*boolean flag = false;
		try {
			String sql = "insert into bill values(SEQ_ORDER.nextval,?,?,?,?,?,?,?,?)";
			Object[] params = { bill.getProduct_name(), bill.getProduct_desc(),
					bill.getBill_time(), bill.getPeovider_id(),
					bill.getIspay(), bill.getBill_money(), bill.getUnit(),
					bill.getCounts() };

			int i = this.executeUpdate(sql, params);
			// （4）处理执行结果
			if (i > 0) {
				flag = true;
			}

		} finally {
			// 释放资源
			this.closeAll();
		}

		return flag;*/
	}

	@Override
	public Bill seachByid(int id) {
		Session session=new Configuration().configure().buildSessionFactory().openSession();
		Bill bill=(Bill) session.get(Bill.class, id);
		session.close();
		return bill;

		// TODO Auto-generated method stub
	/*	conn = this.getConnection();
		String sql = "select *from bill where id=?";
		Object[] params = { id };
		rs = this.executeSQL(sql, params);
		Bill bill = new Bill();
		try {
			if (rs.next()) {
				bill.setId(rs.getInt("id"));
				bill.setProduct_name(rs.getString("product_name"));
				bill.setProduct_desc(rs.getString("product_desc"));
				bill.setBill_time(rs.getString("bill_time"));
				bill.setPeovider_id(rs.getInt("peovider_id"));
				bill.setIspay(rs.getInt("ispay"));
				bill.setBill_money(rs.getInt("bill_money"));
				bill.setUnit(rs.getString("unit"));
				bill.setCounts(rs.getInt("counts"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bill;*/
	}

	@Override
	public boolean update(Bill bill) {
		boolean flag=false;
		Session session=new Configuration().configure().buildSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(bill);
		tx.commit();
		flag=true;
		session.close();
		return flag;
		

		
		
		/*conn = this.getConnection();
		boolean flag = false;
		String sql = "update bill set BILL_MONEY=?,UNIT=?,COUNTS=?,PRODUCT_NAME=?,PRODUCT_DESC=?,ISPAY=?,PEOVIDER_ID=? where id=?";
		Object[] params = { bill.getBill_money(), bill.getUnit(),
				bill.getCounts(), bill.getProduct_name(),
				bill.getProduct_desc(), bill.getIspay(), bill.getPeovider_id(),
				bill.getId() };
		int rss = this.executeUpdate(sql, params);
		if (rss > 0) {
			flag = true;
		}
		return flag;*/
	}

	@Override
	public boolean delect(int id) {
		// TODO Auto-generated method stub
		boolean flag=false;
		Session session=new Configuration().configure().buildSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
	  Bill bill=(Bill) session.load(Bill.class, id);
	  session.delete(bill);

		tx.commit();
		flag=true;
		session.close();
		return flag;

		
		
		
		/*conn=this.getConnection();
		boolean flag=false;
		String sql="delete from bill where id=?";
		Object[] params={id};
		int rss=this.executeUpdate(sql, params);
		if (rss>0) {
			flag=true;
		}
		return flag;*/
	}

	@Override
	public List<Supplier> seachAllSupplier() {
		// TODO Auto-generated method stub
		
		Session session=new Configuration().configure().buildSessionFactory().openSession();
		String hql="from Supplier";
		Query query = session.createQuery(hql);
		List<Supplier> list=query.list();
		return list;

		
		
		/*List<Supplier> supplierlist = new ArrayList<Supplier>();
		String sql = "select * from supplier";
		conn = this.getConnection();
		try {
			Object[] par= {};	
			rs=this.executeSQL(sql, par);
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
		}
		return supplierlist;
*/
	}

}
