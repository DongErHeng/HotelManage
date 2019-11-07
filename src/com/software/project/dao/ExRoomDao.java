package com.software.project.dao;

import com.software.project.model.Order;
import com.software.project.util.StringUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ExRoomDao {

    /**
     * 全部订单信息查询
     * @param con
     * @return
     */
    public ResultSet getAllList(Connection con) throws Exception{
        // TODO Auto-generated method stub
        String sql = "select * from tb_order";
        PreparedStatement pstmt=con.prepareStatement(sql);
        return pstmt.executeQuery();
    }

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
        sb.append(" and tb_order.housing = 1");
        PreparedStatement pstmt=con.prepareStatement(sb.toString().replaceFirst("and", "where"));
        return pstmt.executeQuery();
    }

    /**
     *订单修改
     * @param con
     * @param exRoom
     * @return
     */
    public int update(Connection con, Order exRoom ,int order_id)throws Exception {
        // TODO Auto-generated method stub
        String sql="update tb_order set room_id=?,comedate=?,days=?,leavedate=? where order_id=?";
        PreparedStatement pstmt=con.prepareStatement(sql);
        pstmt.setInt(1, exRoom.getRoom_id());
        pstmt.setString(2, exRoom.getComedate());
        pstmt.setInt(3, exRoom.getDays());
        pstmt.setString(4, exRoom.getLeavedate());
        pstmt.setInt(5, order_id);
        return pstmt.executeUpdate();
    }

    /**
     * 退房事件处理
     * @param con
     * @param order_id
     * @return
     */
    public int delete(Connection con, int order_id) throws Exception{
        // TODO Auto-generated method stub
        String sql="update tb_order set housing=0 where order_id=?";
        //String sql1="update tb_order set housing=? where client_id=?";
        PreparedStatement pstmt=con.prepareStatement(sql);
        //pstmt.setBoolean(1, false);
        pstmt.setInt(1, order_id);
        return pstmt.executeUpdate();
    }

}

