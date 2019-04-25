package com.pb.daoimp;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.pb.dao.BaseDao;
import com.pb.dao.UserDao;
import com.pb.entity.User;

public class UserDaoImpl extends BaseDao implements UserDao {

	// 登录
	@Override
	public Object[] login(String name, String pwd) {
		boolean flag = false;
		Session session = new Configuration().configure().buildSessionFactory().openSession();
		String hql = "from User where username=? and password=?";
		Query query = session.createQuery(hql);
		query.setString(0, name);
		query.setString(1, pwd);
		List<User> list = query.list();
		if (list.size() > 0) {
			flag = true;
		}
		System.out.println("+++++++" + list.size());
		User user = list.get(0);

		Object[] fanhui = { flag, user };
		session.close();
		return fanhui;

		/*
		 * boolean flag = false; conn = this.getConnection(); User user = new User();
		 * try { String password = Base64.encode(pwd.getBytes());
		 * System.out.println("登录密码是：+++"+password); String sql =
		 * "select * from users where username=? and password=?"; Object[] params = {
		 * name, password }; rs = this.executeSQL(sql, params); if (rs.next()) {
		 * user.setId(rs.getInt("id")); user.setUsername(rs.getString("username"));
		 * user.setPassword(rs.getString("password")); user.setAge(rs.getInt("age"));
		 * user.setSex(rs.getInt("sex")); user.setMobile(rs.getString("mobile"));
		 * user.setAddress(rs.getString("address"));
		 * user.setCommon(rs.getInt("common")); user.setSupers(rs.getInt("supers"));
		 * flag = true; } } catch (Exception e) { e.printStackTrace(); } Object[] fanhui
		 * = { flag, user }; return fanhui;
		 */

	}

	// 查询所有用户信息
	public List<User> researchAll() {
		Session session = new Configuration().configure().buildSessionFactory().openSession();

		String hql = "from User";
		Query query = session.createQuery(hql);
		List<User> list = query.list();
		return list;

		/*
		 * List<User> list = new ArrayList<User>(); conn = this.getConnection(); String
		 * sql = "select * from users"; try { PreparedStatement ps =
		 * conn.prepareStatement(sql); rs = ps.executeQuery(); while (rs.next()) { User
		 * user = new User(); user.setId(rs.getInt("id"));
		 * user.setUsername(rs.getString("username"));
		 * user.setPassword(rs.getString("password")); user.setSex(rs.getInt("sex"));
		 * user.setAge(rs.getInt("age")); user.setMobile(rs.getString("mobile"));
		 * user.setAddress(rs.getString("address"));
		 * user.setCommon(rs.getInt("common")); user.setSupers(rs.getInt("supers"));
		 * list.add(user); } } catch (Exception e) { e.printStackTrace(); } finally {
		 * this.closeAll(); } return list;
		 */
	}

	// 添加用户
	public int userAdd(User user) {
		Session session = new Configuration().configure().buildSessionFactory().openSession();
		int i = 0;
		Transaction tx = session.beginTransaction();
		if (user.getSupers() == 1) {
			user.setSupers(1);
			user.setCommon(0);
			session.save(user);
			i = 1;
			tx.commit();
		} else if (user.getSupers() == 0) {
			user.setSupers(0);
			user.setCommon(1);
			session.save(user);
			i = 1;
			tx.commit();
		}
		session.close();
		return i;
		/*
		 * String sql = "insert into users values (seq_user.nextval,?,?,?,?,?,?,?,?)";
		 * Object[] params = new Object[8]; if (user.getSupers() == 1) { params[0] =
		 * user.getUsername(); params[1] = user.getPassword(); params[2] =
		 * user.getSex(); params[3] = user.getAge(); params[4] = user.getMobile();
		 * params[5] = user.getAddress(); params[6] = 0; params[7] = 1; } else if
		 * (user.getSupers() == 0) { params[0] = user.getUsername(); params[1] =
		 * user.getPassword(); params[2] = user.getSex(); params[3] = user.getAge();
		 * params[4] = user.getMobile(); params[5] = user.getAddress(); params[6] = 1;
		 * params[7] = 0; } return this.executeUpdate(sql, params);
		 */
	}

	// 修改密码
	public int uppswd(int id, String password) {
		// TODO Auto-generated method stub
		Session session = new Configuration().configure().buildSessionFactory().openSession();
		String hql = "update User set password=? where id=?";
		Transaction tx = session.beginTransaction();
		Query query = session.createQuery(hql);
		query.setInteger(0, id);
		query.setString(1, password);

		int i = query.executeUpdate();

		tx.commit();
		session.close();
		return i;

		/*
		 * String sql = "update users set password=? where id=?"; Object[] params = {
		 * password, id }; return this.executeUpdate(sql, params);
		 */
	}

	public Object[] researchById(int id) {
		Session session = new Configuration().configure().buildSessionFactory().openSession();
		User user = (User) session.get(User.class, id);
		Object[] fanhui = { user };
		session.close();
		return fanhui;

		/*
		 * conn = this.getConnection(); User user = new User(); String sql =
		 * "select * from users where id=?"; Object[] params = { id }; rs =
		 * this.executeSQL(sql, params); try { if (rs.next()) {
		 * user.setId(rs.getInt("id")); user.setUsername(rs.getString("username"));
		 * user.setPassword(rs.getString("password")); user.setAge(rs.getInt("age"));
		 * user.setSex(rs.getInt("sex")); user.setMobile(rs.getString("mobile"));
		 * user.setAddress(rs.getString("address"));
		 * user.setCommon(rs.getInt("common")); user.setSupers(rs.getInt("supers")); } }
		 * catch (SQLException e) { e.printStackTrace(); } finally { this.closeAll(); }
		 * Object[] fanhui = { user }; return fanhui;
		 */
	}

	public int updateUser(User user) {

		Session session = new Configuration().configure().buildSessionFactory().openSession();
		String hql = "update User set username=?,sex=?,age=?,mobile=?,address=?,common=?,supers=? where id=?";
		Transaction tx = session.beginTransaction();
		Query query = session.createQuery(hql);
		query.setString(0, user.getUsername());
		query.setInteger(1, user.getSex());
		query.setInteger(2, user.getAge());
		query.setString(3, user.getMobile());
		query.setString(4, user.getAddress());
		query.setInteger(7, user.getId());
		if (user.getSupers() == 1) {
			query.setInteger(5, 0);
			query.setInteger(6, 1);
		} else if (user.getSupers() == 0) {
			query.setInteger(5, 1);
			query.setInteger(6, 0);
		} else if (user.getSupers() == 2) {
			query.setInteger(5, 1);
			query.setInteger(6, 1);
		}
		int i = query.executeUpdate();

		tx.commit();
		session.close();
		return i;
	}
	/*
	 * String sql =
	 * "update users set username=?,sex=?,age=?,mobile=?,address=?,common=?,supers=? where id=?"
	 * ; Object[] params = new Object[8]; if (user.getSupers() == 1) { params[0] =
	 * user.getUsername(); params[1] = user.getSex(); params[2] = user.getAge();
	 * params[3] = user.getMobile(); params[4] = user.getAddress(); params[5] = 0;
	 * params[6] = 1; params[7] = user.getId(); } else if (user.getSupers() == 0) {
	 * params[0] = user.getUsername(); params[1] = user.getSex(); params[2] =
	 * user.getAge(); params[3] = user.getMobile(); params[4] = user.getAddress();
	 * params[5] = 1; params[6] = 0; params[7] = user.getId(); }else
	 * if(user.getSupers() ==2) { params[0] = user.getUsername(); params[1] =
	 * user.getSex(); params[2] = user.getAge(); params[3] = user.getMobile();
	 * params[4] = user.getAddress(); params[5] = 1; params[6] = 1; params[7] =
	 * user.getId(); } return this.executeUpdate(sql, params);
	 */

	public int deluser(int id) {
		// TODO Auto-generated method stub
		Session session = new Configuration().configure().buildSessionFactory().openSession();
		String hql = "delete from User where id=?";
		Transaction tx = session.beginTransaction();
		Query query = session.createQuery(hql);
		query.setInteger(0, id);
		int i = query.executeUpdate();
		tx.commit();
		session.close();
		return i;
	}
		/*
		 * String sql = "delete from users where id=?"; Object[] params = { id }; return
		 * this.executeUpdate(sql, params);
		 */

	public int getSuperByName(String name) {
		int sup = -1;
		Session session = new Configuration().configure().buildSessionFactory().openSession();
		String hql = " from User where username=?";
		Transaction tx = session.beginTransaction();
		Query query = session.createQuery(hql);
		query.setString(0, name);
		List<User> list = query.list();
		sup = list.get(0).getSupers();
		tx.commit();
		session.close();

		return sup;

		/*
		 * conn = this.getConnection(); int sup = -1; String sql =
		 * "select supers from users where username=?"; try { PreparedStatement ps =
		 * conn.prepareStatement(sql); ps.setString(1, name); rs = ps.executeQuery(); if
		 * (rs.next()) { sup = rs.getInt(1); } } catch (Exception e) {
		 * e.printStackTrace(); } finally { this.closeAll(); } return sup;
		 */
	}

	public List<User> researchPerson(String name) {
		Session session = new Configuration().configure().buildSessionFactory().openSession();
		String hql = "from User where username=?";
		Query query = session.createQuery(hql);
		query.setString(0, name);
		List<User> list = query.list();
		return list;

		/*
		 * List<User> list = new ArrayList<User>(); conn = this.getConnection(); String
		 * sql = "select * from users where username=?"; try { PreparedStatement ps =
		 * conn.prepareStatement(sql); ps.setString(1, name); rs = ps.executeQuery(); if
		 * (rs.next()) { User user = new User(); user.setId(rs.getInt("id"));
		 * user.setUsername(rs.getString("username"));
		 * user.setPassword(rs.getString("password")); user.setSex(rs.getInt("sex"));
		 * user.setAge(rs.getInt("age")); user.setMobile(rs.getString("mobile"));
		 * user.setAddress(rs.getString("address"));
		 * user.setCommon(rs.getInt("common")); user.setSupers(rs.getInt("supers"));
		 * list.add(user); } } catch (Exception e) { e.printStackTrace(); } finally {
		 * this.closeAll(); } return list;
		 */
	}
}
