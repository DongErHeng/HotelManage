package com.software.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.software.project.model.User;

/**
 * 用户Dao类
 * @author dongerheng
 *
 */
public class UserDao {
	/**
	 * 登录验证
	 * @param con
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public User login(Connection con,User user)throws Exception{
		   User resultUser = null;
		   String sql = "select * from tb_login where username = ? and password = ?";
		   PreparedStatement pstmt = con.prepareStatement(sql);
		   pstmt.setString(1, user.getUserName());
		   pstmt.setString(2, user.getPassword());
		   ResultSet rs = pstmt.executeQuery();
		   if(rs.next())
		   {
			   resultUser = new User();
			   resultUser.setUserName(rs.getString("username"));
			   resultUser.setPassword(rs.getString("password"));
		   }
		   return resultUser;
	   }
}
