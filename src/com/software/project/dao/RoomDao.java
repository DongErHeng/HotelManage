package com.software.project.dao;

import com.software.project.model.Room;
import com.software.project.util.StringUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RoomDao {
    /**
     * 房间信息查询
     * @param connection
     * @param room
     * @return
     */
    public ResultSet list(Connection connection, Room room) throws SQLException {
        StringBuffer sb = new StringBuffer("select *from tb_room");

        if(StringUtil.isNotEmpty(String.valueOf(room.getRoom_id()))){
            sb.append(" and tb_room.room_id like '%"+room.getRoom_id()+"%'");
        }
        if(StringUtil.isNotEmpty(String.valueOf(room.getType()))){
            sb.append(" and tb_room.type like '%"+room.getType()+"%'");
        }
        PreparedStatement pstmt=connection.prepareStatement(sb.toString().replaceFirst("and", "where"));
        return pstmt.executeQuery();
    }

    /**
     * 修改房间状态
     * @param connection
     * @param roomId
     * @param state
     * @return
     */
    public int update(Connection connection,String roomId,boolean state)throws Exception {
        // TODO Auto-generated method stub
        String sql="update tb_room set state=? where room_id=?";
        PreparedStatement pstmt=connection.prepareStatement(sql);
        pstmt.setBoolean(1, state);
        pstmt.setString(2, roomId);
        return pstmt.executeUpdate();
    }
}
