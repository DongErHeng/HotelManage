package com.software.project.util;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * ���ݿ⹤����
 * @author dongerheng
 * 
 */
public class DBUtil {
	
	private String dbUrl="jdbc:mysql://localhost:3306/hotel_manage?"
			+ "useUnicode=true&characterEncoding=utf8&serverTimezone=GMT";//���ݿ����ӵ�ַ
	private String dbUserName="root";  //���ݿ���û���
	private String dbPassword="12345678";  //���ݿ������
	private String jdbcName="com.mysql.cj.jdbc.Driver";  //��������

	/**
	 * ��ȡ���ݿ�����
	 */
	public Connection getCon()throws Exception{
		Class.forName(jdbcName);
		Connection con = DriverManager.getConnection(dbUrl, dbUserName, dbPassword);
		return con;
	}
	/**
	 * �ر����ݿ�����
	 */
	public void closeCon(Connection con)throws Exception{
		if(con!=null) {
			con.close();
		}
	}
	
	public static void main(String[] args) {
		DBUtil dbUtil = new DBUtil();
		try {
			dbUtil.getCon();
			System.out.println("���ݿ����ӳɹ���");
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("���ݿ�����ʧ�ܣ�");
		}
	}
	
}
