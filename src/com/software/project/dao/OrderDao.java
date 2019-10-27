package com.software.project.dao;

import com.software.project.model.Order;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class OrderDao {
    private int order_id = 0;
    public int add(Connection con, Order order)throws Exception {
        // TODO Auto-generated method stub
        String sql = "insert into tb_order values(?,?,?,?,?,?)";
        PreparedStatement pstmt=con.prepareStatement(sql);
        pstmt.setInt(1, order_id++);
        pstmt.setString(2, order.getClient_id());
        pstmt.setInt(3, order.getRoom_id());
        pstmt.setString(4, order.getComedate());
        pstmt.setInt(5, order.getDays());
        pstmt.setString(6, order.getLeavedate());
        return pstmt.executeUpdate();
    }
}
