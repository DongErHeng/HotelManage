package com.software.project.util;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *数据库工具类
 * @author dongerheng
 * 
 */
public class DBUtil {
	
	private String dbUrl="jdbc:mysql://localhost:3306/hotel_manage?"
			+ "useUnicode=true&characterEncoding=utf8&serverTimezone=GMT";//数据库连接地址
	private String dbUserName="root";  //数据库的用户名
	private String dbPassword="12345678";  //数据库的密码
	private String jdbcName="com.mysql.cj.jdbc.Driver";  //驱动名称

	/**
	 * 获取数据库连接
	 */
	public Connection getCon()throws Exception{
		Class.forName(jdbcName);
		Connection con = DriverManager.getConnection(dbUrl, dbUserName, dbPassword);
		return con;
	}
	/**
	 * 关闭数据库连接
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
			System.out.println("数据库连接成功！");
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("数据库连接失败！");
		}
	}
	
}
