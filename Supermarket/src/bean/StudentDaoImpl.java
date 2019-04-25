package bean;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

import com.pb.dao.BaseDao;
import com.pb.entity.Supplier;

public class StudentDaoImpl extends BaseDao implements StudentDao {

	@Override
	public int getTotalRecord(String name, String desc) {
		// TODO Auto-generated method stub
		Session session=new Configuration().configure().buildSessionFactory().openSession();
		String hql="";
		Query query;
		
		int as;
		if ((name == null && desc == null)||(name.equals("")&& desc.equals(""))) {
			hql = "select count(*) from Supplier";
			query=session.createQuery(hql);
		   as=((Long)query.iterate().next()).intValue();
		} else {
			hql = "select count(*) from Supplier where pro_desc like ? and pro_name=?";
			query=session.createQuery(hql);
			query.setString(0,  "%" + desc + "%");
			query.setString(1, name);
		   as=((Long)query.iterate().next()).intValue();
		}
		return as;
		
		/*int as = 0;
		String sql;
		if ((name == null && desc == null)||(name.equals("")&& desc.equals(""))) {
			sql = "select count(*) from supplier";
			Object[] params = {};
			rs = this.executeSQL(sql, params);
		} else {
			sql = "select count(*) from supplier where pro_desc like ? and pro_name=?";
			Object[] params = { "%" + desc + "%", name };
			rs = this.executeSQL(sql, params);
			
			 * ps=conn.prepareStatement(sql); ps.setString(1, "%" + desc + "%");
			 * ps.setString(2, name); rs=ps.executeQuery();
			 

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
	public List<Supplier> getStudentList(int pc, int ps, String name,
			String desc) {
		Session session=new Configuration().configure().buildSessionFactory().openSession();
        String hql="";
        Query query;
        List<Supplier> list;
        if ((name == null && desc == null)||(name.equals("")&& desc.equals(""))) {
        	hql="from Supplier";
        	query=session.createQuery(hql);
        	query.setFirstResult((pc-1)*ps);
        	query.setMaxResults(ps);
        	list=query.list();
        	
        }else {
        	hql="from Supplier where pro_desc like ? and pro_name=?";
        	query=session.createQuery(hql);
        	query.setString(0, "%" + desc + "%");
        	query.setString(1, name);
        	query.setFirstResult((pc-1)*ps);
        	query.setMaxResults(ps);
        	list=query.list();
        }
        return list;
		
		/*List<Supplier> list = new ArrayList<Supplier>();
		String sql;

		if ((name == null && desc == null)||(name.equals("")&& desc.equals(""))) {
			sql = "select * from(select e1.*,rownum rn from supplier e1)e2 where e2.rn>=? and e2.rn<=?";
			Object[] params = { (pc - 1) * ps + 1, pc * ps };
			rs = this.executeSQL(sql, params);
		} else {
			sql = "select * from(select e1.*,rownum rn from supplier e1 where pro_desc like ? and pro_name=?)e2 where e2.rn>=? and e2.rn<=?";
			Object[] params = {  "%" + desc + "%",
					name,(pc - 1) * ps + 1, pc * ps };
			rs = this.executeSQL(sql, params);
		}

		try {

			while (rs.next()) {
				Supplier supplier = new Supplier();
				supplier.setId(rs.getInt("id"));
				supplier.setPro_name(rs.getString("pro_name"));
				supplier.setPro_desc(rs.getString("pro_desc"));
				supplier.setPro_contact(rs.getString("pro_contact"));
				supplier.setPro_phone(rs.getString("pro_phone"));
				supplier.setPro_address(rs.getString("pro_address"));
				supplier.setPro_fax(rs.getString("pro_fax"));
				list.add(supplier);

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
