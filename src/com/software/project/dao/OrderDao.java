package com.software.project.dao;

import com.software.project.model.Order;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class OrderDao {
    public int add(Connection con, Order order)throws Exception {
        // TODO Auto-generated method stub
        String sql = "insert into tb_order values(null,?,?,?,?,?,1)";
        RoomDao roomDao = new RoomDao();
        PreparedStatement pstmt=con.prepareStatement(sql);
        pstmt.setString(1, order.getClient_id());
        pstmt.setInt(2, order.getRoom_id());
        pstmt.setString(3, order.getComedate());
        pstmt.setInt(4, order.getDays());
        pstmt.setString(5, order.getLeavedate());
        roomDao.update(con, String.valueOf(order.getRoom_id()),true);
        return pstmt.executeUpdate();
    }
}
