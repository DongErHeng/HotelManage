package com.software.project.view;

import com.software.project.dao.ExRoomDao;
import com.software.project.dao.RoomDao;
import com.software.project.model.Order;
import com.software.project.util.DBUtil;
import com.software.project.util.StringUtil;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class OrderView extends JFrame {

    private JPanel contentPane;
    private JTextField id_text;
    private JTextField rid_text;
    private JTable exTable;
    private JTextField cid_text;
    private JTextField rid_text1;
    private JTextField ocdate_text;
    private JTextField exday_text;
    private DBUtil dbUtil = new DBUtil();
    private ExRoomDao exRoomDao = new ExRoomDao();
    private RoomDao roomDao = new RoomDao();
    private JTextField exdate_text;
    private JScrollPane scrollPane;
    private JTextField leave_text;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    OrderView frame = new OrderView();
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
    public OrderView() {
        setTitle("\u9000\u6362\u623F\u95F4\u5904\u7406");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 808, 637);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        JLabel label = new JLabel("\u6362\u623F\u5904\u7406");
        label.setForeground(new Color(138, 43, 226));
        label.setFont(new Font("华文行楷", Font.PLAIN, 28));

        JLabel lblNewLabel = new JLabel("\u8EAB\u4EFD\u8BC1\u53F7\uFF1A");
        lblNewLabel.setFont(new Font("华文行楷", Font.PLAIN, 18));

        id_text = new JTextField();
        id_text.setColumns(10);

        JLabel label_1 = new JLabel("\u623F\u95F4\u7F16\u53F7\uFF1A");
        label_1.setFont(new Font("华文行楷", Font.PLAIN, 18));

        rid_text = new JTextField();
        rid_text.setColumns(10);

        JButton btn_search = new JButton("\u67E5\u8BE2");
        btn_search.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btn_searchActionPerformed(evt);
            }

        });
        btn_search.setFont(new Font("华文行楷", Font.PLAIN, 18));

        scrollPane = new JScrollPane();

        JLabel label_2 = new JLabel("\u8EAB\u4EFD\u8BC1\u53F7\u7801\uFF1A");
        label_2.setFont(new Font("华文行楷", Font.PLAIN, 18));

        cid_text = new JTextField();
        cid_text.setColumns(10);

        JLabel label_3 = new JLabel("\u66F4\u6362\u623F\u95F4\u7F16\u53F7\uFF1A");
        label_3.setFont(new Font("华文行楷", Font.PLAIN, 18));

        rid_text1 = new JTextField();
        rid_text1.setColumns(10);

        JLabel label_4 = new JLabel("\u5165\u4F4F\u65F6\u95F4\uFF1A");
        label_4.setFont(new Font("华文行楷", Font.PLAIN, 18));

        ocdate_text = new JTextField();
        ocdate_text.setEnabled(false);
        ocdate_text.setColumns(10);

        JLabel label_5 = new JLabel("\u66F4\u6362\u5929\u6570\uFF1A");
        label_5.setFont(new Font("华文行楷", Font.PLAIN, 18));

        exday_text = new JTextField();
        exday_text.setColumns(10);

        JButton btn_update = new JButton("\u6362\u623F");
        btn_update.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btn_updateActionPerformed(evt);
            }

        });
        btn_update.setForeground(new Color(30, 144, 255));
        btn_update.setFont(new Font("华文行楷", Font.PLAIN, 20));

        JButton btn_return = new JButton("\u8FD4\u56DE");
        btn_return.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                btn_returnMouseClicked(evt);
            }

        });
        btn_return.setFont(new Font("华文行楷", Font.PLAIN, 18));

        JButton btn_delete = new JButton("\u9000\u623F");
        btn_delete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btn_deleteActionPerformed(evt);
            }
        });

        btn_delete.setForeground(new Color(255, 20, 147));
        btn_delete.setFont(new Font("华文行楷", Font.PLAIN, 22));
        exdate_text = new JTextField();
        exdate_text.setColumns(10);

        JLabel label_6 = new JLabel("\u79BB\u5F00\u65F6\u95F4\uFF1A");
        label_6.setFont(new Font("华文行楷", Font.PLAIN, 18));

        leave_text = new JTextField();
        leave_text.setColumns(10);
        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        gl_contentPane.setHorizontalGroup(
                gl_contentPane.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lblNewLabel)
                                .addGap(6)
                                .addComponent(id_text, GroupLayout.PREFERRED_SIZE, 215, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                                .addComponent(label_1)
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addComponent(rid_text, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                                .addComponent(btn_search)
                                .addGap(24))
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addGap(31)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                        .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 678, GroupLayout.PREFERRED_SIZE)
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                                .addGap(17)
                                                                .addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
                                                                        .addComponent(label_2)
                                                                        .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                                                                .addComponent(label_6)
                                                                                .addComponent(label_4)))
                                                                .addPreferredGap(ComponentPlacement.RELATED)
                                                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
                                                                        .addComponent(leave_text)
                                                                        .addComponent(ocdate_text)
                                                                        .addComponent(cid_text, GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)))
                                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                                .addGap(72)
                                                                .addComponent(btn_delete)))
                                                .addPreferredGap(ComponentPlacement.RELATED, 115, Short.MAX_VALUE)
                                                .addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
                                                        .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
                                                                .addGroup(gl_contentPane.createSequentialGroup()
                                                                        .addComponent(label_5)
                                                                        .addPreferredGap(ComponentPlacement.RELATED)
                                                                        .addComponent(exday_text))
                                                                .addGroup(gl_contentPane.createSequentialGroup()
                                                                        .addComponent(label_3)
                                                                        .addPreferredGap(ComponentPlacement.RELATED)
                                                                        .addComponent(rid_text1, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)))
                                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                                .addComponent(btn_return)
                                                                .addGap(69))
                                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                                .addComponent(btn_update, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE)
                                                                .addGap(119)))))
                                .addContainerGap(43, Short.MAX_VALUE))
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addGap(289)
                                .addComponent(label)
                                .addContainerGap(379, Short.MAX_VALUE))
        );
        gl_contentPane.setVerticalGroup(
                gl_contentPane.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addComponent(label)
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                        .addComponent(btn_search)
                                        .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                                .addComponent(label_1)
                                                .addComponent(id_text, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(lblNewLabel)
                                                .addComponent(rid_text, GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)))
                                .addGap(15)
                                .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 176, GroupLayout.PREFERRED_SIZE)
                                .addGap(34)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(cid_text, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(label_3)
                                        .addComponent(rid_text1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(label_2))
                                .addGap(37)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
                                        .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                                .addComponent(ocdate_text, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(label_4))
                                        .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                                .addComponent(label_5)
                                                .addComponent(exday_text, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                                .addGap(37)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                        .addComponent(btn_update, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
                                        .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                                .addComponent(label_6)
                                                .addComponent(leave_text, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                        .addComponent(btn_return)
                                        .addComponent(btn_delete, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
                                .addGap(26))
        );

        exTable = new JTable();
        exTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent evt) {
                exTableMousePressed(evt);
            }

        });
        exTable.setModel(new DefaultTableModel(
                new Object[][] {
                },
                new String[] {
                        "\u8BA2\u5355\u7F16\u53F7", "\u8EAB\u4EFD\u8BC1\u53F7\u7801", "\u623F\u95F4\u7F16\u53F7", "\u5165\u4F4F\u65F6\u95F4", "\u5165\u4F4F\u5929\u6570", "\u79BB\u5F00\u65F6\u95F4"
                }
        ));
        scrollPane.setViewportView(exTable);
        contentPane.setLayout(gl_contentPane);
    }

    /**
     * 界面跳转
     * @param evt
     */
    private void btn_returnMouseClicked(MouseEvent evt) {
        // TODO Auto-generated method stub
        this.setVisible(false);
        new MainView().setVisible(true);
    }

    /**
     * 查询订单
     * @param evt
     */
    private void btn_searchActionPerformed(ActionEvent evt) {
        // TODO Auto-generated method stub
        String cid= this.id_text.getText();
        String rid = this.rid_text.getText();
        if(StringUtil.isEmpty(cid)) {
            JOptionPane.showMessageDialog(null, "请输入身份证号码");
            return;
        }
        if(StringUtil.isEmpty(rid)) {
            JOptionPane.showMessageDialog(null, "请输入房间号");
            return;
        }
        Order exRoom = new Order(cid,Integer.parseInt(rid));
        this.fillTable(exRoom);

    }
    /**
     * 初始化表格数据
     * @param exRoom
     */
    private void fillTable(Order exRoom) {
        // TODO Auto-generated method stub
        DefaultTableModel dtm=(DefaultTableModel) exTable.getModel();
        dtm.setRowCount(0); // 设置成0行
        Connection con=null;
        try{
            con=dbUtil.getCon();
            ResultSet rs=exRoomDao.list(con, exRoom);
            while(rs.next()){
                Vector v=new Vector();
                v.add(rs.getInt("order_id"));
                v.add(rs.getString("client_id"));
                v.add(rs.getString("room_id"));
                v.add(rs.getString("comedate"));
                v.add(rs.getString("days"));
                v.add(rs.getString("leavedate"));
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
    /**
     * 表格行点击事件
     * @param evt
     */

    private void exTableMousePressed(MouseEvent evt) {
        // TODO Auto-generated method stub
        int row=this.exTable.getSelectedRow();
        this.cid_text.setText((String)exTable.getValueAt(row, 1));
        this.rid_text1.setText((String)exTable.getValueAt(row, 2));
        this.ocdate_text.setText((String)exTable.getValueAt(row, 3));
        this.exday_text.setText((String)exTable.getValueAt(row, 4));
        this.leave_text.setText((String)exTable.getValueAt(row, 5));
    }
    /**
     * 换房事件处理
     * @param evt
     */
    private void btn_updateActionPerformed(ActionEvent evt) {
        // TODO Auto-generated method stub
        String cid = this.cid_text.getText();
        String newRid = this.rid_text1.getText();
        String oldRid = this.rid_text.getText();
        String ocomedate = this.ocdate_text.getText();
        int odays = Integer.parseInt(this.exday_text.getText());
        String oleavedate = this.leave_text.getText();
        if(StringUtil.isEmpty(cid)){
            JOptionPane.showMessageDialog(null, "请输入身份证号");
            return;
        }
        if(StringUtil.isEmpty(newRid)){
            JOptionPane.showMessageDialog(null, "请输入要更换的房间号");
            return;
        }
        Order exRoom = new Order(cid,Integer.parseInt(newRid),ocomedate,odays,oleavedate);
        Connection con=null;
        try{
            con=dbUtil.getCon();
            roomDao.update(con,oldRid,false);
            roomDao.update(con,newRid,true);
            int modifyNum=exRoomDao.update(con, exRoom);
            if(modifyNum==1){
                JOptionPane.showMessageDialog(null, "换房成功");
                this.resetValue();
                this.fillTable(new Order());
            }else{
                JOptionPane.showMessageDialog(null, "换房失败");
            }
        }catch(Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "连接数据库失败");
        }finally{
            try {
                dbUtil.closeCon(con);
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

    }
    /**
     * 重置表单
     */
    private void resetValue() {
        // TODO Auto-generated method stub
        this.cid_text.setText("");
        this.rid_text.setText("");
        this.ocdate_text.setText("");
        this.exday_text.setText("");
        this.leave_text.setText("");
    }
    /**
     * 退房事件处理
     * @param evt
     */
    private void btn_deleteActionPerformed(ActionEvent evt) {
        // TODO Auto-generated method stub
        String cid=cid_text.getText();
        String oldRid = this.rid_text1.getText();
        if(StringUtil.isEmpty(cid)){
            JOptionPane.showMessageDialog(null, "请输入身份证号");
            return;
        }
        if(StringUtil.isEmpty(oldRid)){
            JOptionPane.showMessageDialog(null, "请输入房间号");
            return;
        }

        int n=JOptionPane.showConfirmDialog(null, "确定退房");
        if(n==0){
            Connection con=null;
            try{
                con=dbUtil.getCon();
                roomDao.update(con,oldRid,false);
                int deleteNum=exRoomDao.delete(con, cid);
                if(deleteNum==1){
                    JOptionPane.showMessageDialog(null, "已退房");
                    this.resetValue();
                    this.fillTable(new Order());
                }else{
                    JOptionPane.showMessageDialog(null, "退房失败");
                }
            }catch(Exception e){
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "未连接到数据库");
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
}

