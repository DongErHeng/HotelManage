package com.software.project.view;

import com.software.project.dao.RoomDao;
import com.software.project.model.Room;
import com.software.project.util.DBUtil;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

public class RoomView extends JFrame {

    private JPanel contentPane;
    private JTextField rid_text;
    private JTable roomTable;
    private JTextField rtype_text;
    private DBUtil dbUtil = new DBUtil();
    private RoomDao roomDao = new RoomDao();

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    RoomView frame = new RoomView();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public RoomView() {
        setTitle("\u623F\u95F4\u67E5\u8BE2");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 669, 558);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        JLabel label = new JLabel("\u623F\u95F4\u7F16\u53F7\uFF1A");
        label.setFont(new Font("华文行楷", Font.PLAIN, 28));

        rid_text = new JTextField();
        rid_text.setColumns(10);

        JLabel lblNewLabel = new JLabel("\u623F\u95F4\u7C7B\u578B\uFF1A");
        lblNewLabel.setFont(new Font("华文行楷", Font.PLAIN, 28));

        JButton btn_search = new JButton("\u67E5\u8BE2");
        btn_search.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btn_searchActionPerformed(evt);
            }

        });
        btn_search.setForeground(new Color(139, 0, 0));
        btn_search.setFont(new Font("华文行楷", Font.PLAIN, 28));

        JScrollPane scrollPane = new JScrollPane();

        JButton btn_return = new JButton("\u8FD4\u56DE");
        btn_return.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                btn_returnMouseClicked(evt);
            }

        });
        btn_return.setFont(new Font("华文行楷", Font.PLAIN, 28));

        rtype_text = new JTextField();
        rtype_text.setColumns(10);
        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        gl_contentPane.setHorizontalGroup(
                gl_contentPane.createParallelGroup(Alignment.TRAILING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(label)
                                                .addPreferredGap(ComponentPlacement.RELATED)
                                                .addComponent(rid_text, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE)
                                                .addGap(18)
                                                .addComponent(lblNewLabel)
                                                .addPreferredGap(ComponentPlacement.RELATED)
                                                .addComponent(rtype_text, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 603, GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(24, Short.MAX_VALUE))
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addContainerGap(459, Short.MAX_VALUE)
                                .addComponent(btn_return, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE)
                                .addGap(38))
                        .addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
                                .addGap(243)
                                .addComponent(btn_search, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(258, Short.MAX_VALUE))
        );
        gl_contentPane.setVerticalGroup(
                gl_contentPane.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(label)
                                        .addComponent(rid_text, GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                                        .addComponent(lblNewLabel)
                                        .addComponent(rtype_text, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addComponent(btn_search)
                                .addGap(19)
                                .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 311, GroupLayout.PREFERRED_SIZE)
                                .addGap(21)
                                .addComponent(btn_return)
                                .addContainerGap())
        );

        roomTable = new JTable();
        roomTable.setModel(new DefaultTableModel(
                new Object[][] {
                },
                new String[] {
                        "\u623F\u95F4\u7F16\u53F7", "\u623F\u95F4\u7C7B\u578B", "\u623F\u95F4\u5355\u4EF7", "\u623F\u95F4\u72B6\u6001"
                }
        ));
        roomTable.setBorder(new LineBorder(new Color(178, 34, 34)));
        scrollPane.setViewportView(roomTable);
        contentPane.setLayout(gl_contentPane);
    }
    /**
     * 返回主页面
     * @param evt
     */
    private void btn_returnMouseClicked(MouseEvent evt) {
        // TODO Auto-generated method stub
        this.setVisible(false);
        new MainView().setVisible(true);
    }
    /**
     * 房间查询
     * @param evt
     */
    private void btn_searchActionPerformed(ActionEvent evt) {
        // TODO Auto-generated method stub
        String  rid = this.rid_text.getText();
        String  rtype = this.rtype_text.getText();
        Room room = new Room(rid,rtype);
        this.fillTable(room);

    }

    /**
     * 初始化表格数据
     * @param room
     */
    private void fillTable(Room room) {
        // TODO Auto-generated method stub
        DefaultTableModel dtm=(DefaultTableModel) roomTable.getModel();
        dtm.setRowCount(0); // 设置成0行
        Connection con=null;
        try{
            con=dbUtil.getCon();
            ResultSet rs=roomDao.list(con, room);
            while(rs.next()){
                Vector v=new Vector();
                v.add(rs.getInt("room_id"));

                if ("0".equals(rs.getString("type"))){
                    v.add("单人间");
                } else if ("1".equals(rs.getString("type"))){
                    v.add("双人间");
                } else if ("2".equals(rs.getString("type"))){
                    v.add("商务房");
                }
                v.add(rs.getString("price"));

                if (rs.getBoolean("state")){
                    v.add("已入住");
                } else {
                    v.add("空闲");
                }
                dtm.addRow(v);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try {
                dbUtil.closeCon(con);
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

    }
}

