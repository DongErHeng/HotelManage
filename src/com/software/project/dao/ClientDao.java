package com.software.project.dao;

import com.software.project.model.Client;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class ClientDao {
    /**
     * 客户信息增加
     * @param con
     * @param client
     * @return
     * @throws Exception
     */

    public int add(Connection con, Client client) throws Exception{
        // TODO Auto-generated method stub
        String sql = "insert into tb_client values(?,?,?,?,?)";
        PreparedStatement pstmt=con.prepareStatement(sql);
        pstmt.setString(1, client.getClient_id());
        pstmt.setString(2, client.getName());
        pstmt.setBoolean(3, client.isSex());
        pstmt.setInt(4, client.getAge());
        pstmt.setString(5, client.getTell());
        return pstmt.executeUpdate();
    }
}
