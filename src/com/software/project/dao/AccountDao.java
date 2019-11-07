package com.software.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AccountDao {

    /**
     * 全部订单信息查询
     * @param con
     * @return
     */
    public ResultSet getAllAccount(Connection con) throws Exception{
        // TODO Auto-generated method stub
        String sql = "SELECT tb_order.days,tb_room.price " +
                "FROM tb_order,tb_room WHERE tb_order.room_id = tb_room.room_id";
        PreparedStatement pstmt=con.prepareStatement(sql);
        return pstmt.executeQuery();
    }
}
