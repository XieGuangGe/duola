package bean;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

import com.pb.dao.BaseDao;
import com.pb.entity.Bill;


public class BillStudentDaoImpl extends BaseDao implements BillStudentDao {

	@Override
	public int getTotalRecord(String name, int ispay) {
		Session session=new Configuration().configure().buildSessionFactory().openSession();
		String hql="";
		Query query;
		int as;
		
		if ((name == null && ispay == -1) || (name.equals("") && ispay == -1)) {
			hql = "select count(*) from Bill";
			query=session.createQuery(hql);
			as=((Long)query.iterate().next()).intValue();
		}else {
			hql = "select count(*) from Bill where product_name=? and ispay=?";
			query=session.createQuery(hql);
			query.setString(0, name);
			query.setInteger(1, ispay);
			as=((Long)query.iterate().next()).intValue();
		}
		session.close();
		return as;
		
		
		
		/*int as = 0;
		String sql;
		if ((name == null && ispay == -1) || (name.equals("") && ispay == -1)) {
			sql = "select count(*) from bill";
			Object[] params = {};
			rs = this.executeSQL(sql, params);
		} else {
			sql = "select count(*) from bill where product_name=? and ispay=?";
			Object[] params = { name, ispay };
			rs = this.executeSQL(sql, params);

		}
		try {
			if (rs.next()) {
				as = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			this.closeAll();
		}

		return as;*/
	}

	@Override
	public List<Bill> getStudentList(int pc, int ps, String name, int ispay) {
		
		Session session=new Configuration().configure().buildSessionFactory().openSession();
		String hql="";
		Query query;
		List<Bill> list;
		if ((name == null && ispay == -1) || (name.equals("") && ispay == -1)) {
			hql="from Bill";
			query=session.createQuery(hql);
			query.setFirstResult((pc-1)*ps);
			query.setMaxResults(ps);
			list=query.list();
		}else {
			hql="from Bill where product_name=? and ispay=?";
			query=session.createQuery(hql);
			query.setFirstResult((pc-1)*ps);
			query.setMaxResults(ps);
			list=query.list();
		}
		session.close();
		return list;
		
		
		
		// TODO Auto-generated method stub
		/*List<Bill> list = new ArrayList<Bill>();
		String sql;

		if ((name == null && ispay == -1) || (name.equals("") && ispay == -1)) {
			sql = "select * from(select e1.*,rownum rn from bill e1)e2 where e2.rn>=? and e2.rn<=?";
			Object[] params = { (pc - 1) * ps + 1, pc * ps };
			rs = this.executeSQL(sql, params);
		} else {
			sql = "select * from(select e1.*,rownum rn from bill e1 where product_name=? and ispay=?)e2 where e2.rn>=? and e2.rn<=?";
			Object[] params = { name, ispay, (pc - 1) * ps + 1, pc * ps };
			rs = this.executeSQL(sql, params);
		}

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
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			this.closeAll();
		}

		return list;*/
	}

}
