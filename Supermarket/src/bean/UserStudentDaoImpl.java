package bean;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.pb.dao.BaseDao;
import com.pb.entity.User;

public class UserStudentDaoImpl extends BaseDao implements UserStudentDao {

	@Override
	public int getTotalRecord(String name,int supers, String loginname) {
		// TODO Auto-generated method stub
		Session session=new Configuration().configure().buildSessionFactory().openSession();
		
		String hql="";
		Query query;
		 int as;
		if ((name == null  || name.equals("")) && supers==1) {
			 hql="select count(*) from User";
			 query = session.createQuery(hql);
			 as=((Long)query.iterate().next()).intValue();
		} else if((name == null  || name.equals("")) && supers==0) {
			hql="select count(*) from User where username=?";
			 query = session.createQuery(hql);
			 query.setString(0, loginname);
			 as=((Long)query.iterate().next()).intValue();
			
		}else {
			hql="select count(*) from User where username=?";
			 query = session.createQuery(hql);
			 query.setString(0, name);
			 as=((Long)query.iterate().next()).intValue();
		}
		session.close();
		return as;

	/*	int as = 0;
		String sql;
		
		if ((name == null  || name.equals("")) && supers==1) {
			sql = "select count(*) from users";
			Object[] params = {};
			rs = this.executeSQL(sql, params);
		} else if((name == null  || name.equals("")) && supers==0) {
			sql = "select count(*) from users where username=?";
			Object[] params = { loginname };
			rs = this.executeSQL(sql, params);
		} else {
			sql = "select count(*) from users where username=? ";
			Object[] params = { name };
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
	public List<User> getStudentList(int pc, int ps, String name,int supers, String loginname) {
		// TODO Auto-generated method stub
		Session session=new Configuration().configure().buildSessionFactory().openSession();
		String hql;
		Query query;
		List<User> list;
		if ((name == null || name.equals("")) && supers==1) {
			hql = "from User";
			query=session.createQuery(hql);
			query.setFirstResult((pc - 1) * ps);
			query.setMaxResults(ps);
			 list=query.list();
			
		}else if((name == null || name.equals("")) && supers==0) {
			hql = "from User where username=?";
			query=session.createQuery(hql);
			query.setString(0, loginname);
			query.setFirstResult((pc - 1) * ps);
			query.setMaxResults(ps);
			 list=query.list();
		}else {
			hql = "from User where username=?";
			query=session.createQuery(hql);
			query.setString(0, name);
			query.setFirstResult((pc - 1) * ps);
			query.setMaxResults(ps);
			 list=query.list();
		}
		session.close();
		return list;

		/*List<User> list = new ArrayList<User>();
		String sql;
		
		
		if ((name == null || name.equals("")) && supers==1) {
			sql = "select * from(select e1.*,rownum rn from users e1)e2 where e2.rn>=? and e2.rn<=?";
			Object[] params = { (pc - 1) * ps + 1, pc * ps };
			rs = this.executeSQL(sql, params);
		}else if((name == null || name.equals("")) && supers==0) {
			sql = "select * from(select e1.*,rownum rn from users e1 where username=?)e2 where e2.rn>=? and e2.rn<=?";
			Object[] params = {loginname, (pc - 1) * ps + 1, pc * ps };
			rs = this.executeSQL(sql, params);
		}else {
			sql = "select * from(select e1.*,rownum rn from users e1 where username=? )e2 where e2.rn>=? and e2.rn<=?";
			Object[] params = { name, (pc - 1) * ps + 1, pc * ps };
			rs = this.executeSQL(sql, params);
		}

		try {

			while (rs.next()) {
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setSex(rs.getInt("sex"));
				user.setAge(rs.getInt("age"));
				user.setMobile(rs.getString("mobile"));
				user.setAddress(rs.getString("address"));
				user.setCommon(rs.getInt("common"));
				user.setSupers(rs.getInt("supers"));
				list.add(user);

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
