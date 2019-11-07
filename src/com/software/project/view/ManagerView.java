package com.software.project.view;

import com.software.project.dao.AccountDao;
import com.software.project.dao.ExRoomDao;
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

public class ManagerView extends JFrame {

    private JPanel contentPane;
    private JTable roomTable;
    private JTextField account_text;
    private DBUtil dbUtil = new DBUtil();
    private ExRoomDao exRoomDao = new ExRoomDao();
    private AccountDao accountDao = new AccountDao();

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ManagerView frame = new ManagerView();
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
    public ManagerView() {
        setTitle("\u67E5\u8BE2");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 778, 558);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        JButton btn_search = new JButton("\u67E5\u8BE2");
        btn_search.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btn_searchActionPerformed(evt);
            }

        });
        btn_search.setForeground(new Color(139, 0, 0));
        btn_search.setFont(new Font("华文行楷", Font.PLAIN, 28));

        JButton btn_account = new JButton("\u5408\u8ba1");
        btn_account.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btn_accountActionPerformed(evt);
            }

        });
        btn_account.setForeground(new Color(139, 0, 0));
        btn_account.setFont(new Font("华文行楷", Font.PLAIN, 28));

        JScrollPane scrollPane = new JScrollPane();

        account_text = new JTextField();
        account_text.setEnabled(false);
        account_text.setBackground(new Color(139, 0, 0));
        account_text.setFont(new Font("华文行楷", Font.PLAIN, 28));
        account_text.setColumns(10);

        JButton btn_return = new JButton(" \u9000\u51fa");
        btn_return.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                btn_returnMouseClicked(evt);
            }

        });
        btn_return.setFont(new Font("华文行楷", Font.PLAIN, 28));

        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        gl_contentPane.setHorizontalGroup(
                gl_contentPane.createParallelGroup(Alignment.TRAILING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 730, GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(24, Short.MAX_VALUE))
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addContainerGap(459, Short.MAX_VALUE)
                                .addComponent(btn_return, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
                                .addGap(38))
                        .addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
                                .addContainerGap(459, Short.MAX_VALUE)
                                .addComponent(btn_search, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
                                .addGap(38))
                        .addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(account_text, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
                                .addGap(20)
                                .addComponent(btn_account, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(258, Short.MAX_VALUE))
        );
        gl_contentPane.setVerticalGroup(
                gl_contentPane.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 311, GroupLayout.PREFERRED_SIZE)
                                .addGap(21)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(account_text, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btn_account)
                                        .addComponent(btn_search))
                                .addGap(21)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(btn_return))
                        )
        );

        roomTable = new JTable();
        roomTable.setModel(new DefaultTableModel(
                new Object[][] {
                },
                new String[] {
                        "\u8BA2\u5355\u7F16\u53F7",
                        "\u8EAB\u4EFD\u8BC1\u53F7\u7801",
                        "\u623F\u95F4\u7F16\u53F7",
                        "\u5165\u4F4F\u65F6\u95F4",
                        "\u5165\u4F4F\u5929\u6570",
                        "\u79BB\u5F00\u65F6\u95F4"
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
        new LoginView().setVisible(true);
    }
    /**
     * 订单查询
     * @param evt
     */
    private void btn_searchActionPerformed(ActionEvent evt) {
        // TODO Auto-generated method stub
        fillTable();
    }

    /**
     * 合计
     * @param evt
     */
    private void btn_accountActionPerformed(ActionEvent evt) {
        // TODO Auto-generated method stub
        int account = 0;
        Connection con=null;
        try{
            con=dbUtil.getCon();
            ResultSet rs=accountDao.getAllAccount(con);
            while(rs.next()){
                account = account + rs.getInt("days") * rs.getInt("price");
            }
            this.account_text.setText(account+"");
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
     * 初始化表格数据
     */
    private void fillTable() {
        // TODO Auto-generated method stub
        DefaultTableModel dtm=(DefaultTableModel) roomTable.getModel();
        dtm.setRowCount(0); // 设置成0行
        Connection con=null;
        try{
            con=dbUtil.getCon();
            ResultSet rs=exRoomDao.getAllList(con);
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
}

