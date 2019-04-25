package com.pb.dao;

import java.sql.Connection;


import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.pb.util.ConfigManager;


//���ࣺ���ݿ����ͨ����
public class BaseDao {
	protected Connection conn;
	protected PreparedStatement ps;
	protected Statement stmt;
	protected ResultSet rs;
	//ͨ�������ļ��������ݿ�
	public Connection getConnection(){
		String driver=ConfigManager.getInstance()
				.getString("jdbc.driver_class");
		String url=ConfigManager.getInstance()
				.getString("jdbc.connection.url");
		String username=ConfigManager.getInstance()
				.getString("jdbc.connection.username");
		String password=ConfigManager.getInstance()
				.getString("jdbc.connection.password");
		try {
			Class.forName(driver);//oracle.jdbc.driver.OracleDriver
			// �����ݿ⽨������
			conn = DriverManager
					.getConnection(url, username, password);
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	// ��ɾ�ĵ�ͨ�÷��� 
			public int executeUpdate(String sql, Object[] params) {
				int updateRows = 0;
				getConnection();
				try {
					ps=conn.prepareStatement(sql);
			
					//���ռλ��
					for(int i=0;i<params.length;i++){
						ps.setObject(i+1, params[i]);
						System.out.println(i+1+"---"+params[i]);
					}
					System.out.println(sql);
					updateRows=ps.executeUpdate();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				return updateRows;
			}

			// ��ѯ
			public ResultSet executeSQL(String sql,Object[] params) {
				getConnection();
				try {
					ps=conn.prepareStatement(sql);
					//���ռλ��
					for(int i=0;i<params.length;i++){
						ps.setObject(i+1, params[i]);
					}
					rs=ps.executeQuery();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				return rs;
			}

	//�ر����ݿ���Դ
	public void closeAll(){
		try {
			if(rs!=null){
				rs.close();
			}
			if(ps!=null){
				ps.close();
			}
			if(stmt!=null){
				stmt.close();
			}
			if(conn!=null){
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
