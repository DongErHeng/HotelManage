package com.software.project.dao;

import com.software.project.model.Order;
import com.software.project.util.StringUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ExRoomDao {
    /**
     * 订单信息查询
     * @param con
     * @param exRoom
     * @return
     */
    public ResultSet list(Connection con, Order exRoom) throws Exception{
        // TODO Auto-generated method stub
        StringBuffer sb = new StringBuffer("select * from tb_order");
        if(StringUtil.isNotEmpty(exRoom.getClient_id())) {
            sb.append(" and tb_order.client_id like'%"+exRoom.getClient_id()+"%'");
        }
        if(StringUtil.isNotEmpty(exRoom.getRoom_id()+"")) {
            sb.append(" and tb_order.room_id like'%"+exRoom.getRoom_id()+"%'");
        }
        PreparedStatement pstmt=con.prepareStatement(sb.toString().replaceFirst("and", "where"));
        return pstmt.executeQuery();
    }

    /**
     *订单修改
     * @param con
     * @param exRoom
     * @return
     */
    public int update(Connection con, Order exRoom)throws Exception {
        // TODO Auto-generated method stub
        String sql="update tb_order set room_id=?,comedate=?,days=?,leavedate=? where client_id=?";
        PreparedStatement pstmt=con.prepareStatement(sql);
        pstmt.setInt(1, exRoom.getRoom_id());
        pstmt.setString(2, exRoom.getComedate());
        pstmt.setInt(3, exRoom.getDays());
        pstmt.setString(4, exRoom.getLeavedate());
        pstmt.setString(5, exRoom.getClient_id());
        return pstmt.executeUpdate();
    }

    /**
     * 退房事件处理
     * @param con
     * @param cid
     * @return
     */
    public int delete(Connection con, String cid) throws Exception{
        // TODO Auto-generated method stub
        String sql="delete from tb_order where client_id=?";
        PreparedStatement pstmt=con.prepareStatement(sql);
        pstmt.setString(1, cid);
        return pstmt.executeUpdate();
    }

}

