package com.software.project.view;

import com.software.project.dao.OrderDao;
import com.software.project.model.Order;
import com.software.project.util.DBUtil;
import com.software.project.util.StringUtil;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;

public class OrderAddView extends JFrame {

    private JPanel contentPane;
    private JTextField cid_text;
    private JTextField rid_text;
    private JTextField cdate_text;
    private JTextField day_text;
    private JTextField ldate_text;
    private DBUtil dbUtil = new DBUtil();
    private OrderDao orderDao = new OrderDao();

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    OrderAddView frame = new OrderAddView();
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
    public OrderAddView() {
        setTitle("\u8BA2\u5355\u8BE6\u60C5");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 656, 543);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        JLabel lblNewlabel = new JLabel("\u8EAB\u4EFD\u8BC1\u53F7\u7801\uFF1A");
        lblNewlabel.setFont(new Font("华文行楷", Font.PLAIN, 16));

        cid_text = new JTextField();
        cid_text.setColumns(10);

        JLabel label = new JLabel("\u623F\u95F4\u7F16\u53F7\uFF1A");
        label.setFont(new Font("华文行楷", Font.PLAIN, 16));

        rid_text = new JTextField();
        rid_text.setColumns(10);

        JLabel label_1 = new JLabel("\u5165\u4F4F\u65F6\u95F4\uFF1A");
        label_1.setFont(new Font("华文行楷", Font.PLAIN, 16));

        cdate_text = new JTextField();
        cdate_text.setColumns(10);

        JLabel label_2 = new JLabel("\u5165\u4F4F\u5929\u6570\uFF1A");
        label_2.setFont(new Font("华文行楷", Font.PLAIN, 16));

        day_text = new JTextField();
        day_text.setColumns(10);

        JLabel label_3 = new JLabel("\u79BB\u5F00\u65F6\u95F4\uFF1A");
        label_3.setFont(new Font("华文行楷", Font.PLAIN, 16));

        ldate_text = new JTextField();
        ldate_text.setColumns(10);

        JButton btn_add = new JButton("\u63D0\u4EA4");
        btn_add.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btn_addActionPerformed(evt);
            }
        });
        btn_add.setFont(new Font("华文行楷", Font.PLAIN, 22));

        JButton btn_return = new JButton("\u8FD4\u56DE");
        btn_return.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                btn_returnMouseClicked(evt);
            }
        });
        btn_return.setFont(new Font("华文行楷", Font.PLAIN, 22));

        JLabel label_5 = new JLabel("\u8BA2\u5355\u8BE6\u60C5");
        label_5.setForeground(Color.CYAN);
        label_5.setFont(new Font("华文行楷", Font.PLAIN, 32));
        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        gl_contentPane.setHorizontalGroup(
                gl_contentPane.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addGap(95)
                                .addComponent(btn_add)
                                .addPreferredGap(ComponentPlacement.RELATED, 238, Short.MAX_VALUE)
                                .addComponent(btn_return)
                                .addGap(141))
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addGap(51)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
                                        .addComponent(label_3)
                                        .addComponent(label_2)
                                        .addComponent(label_1))
                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                        .addComponent(cdate_text, 469, 469, 469)
                                        .addComponent(day_text, 469, 469, 469)
                                        .addComponent(ldate_text, 248, 469, Short.MAX_VALUE))
                                .addContainerGap())
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addGap(31)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
                                        .addComponent(label)
                                        .addComponent(lblNewlabel))
                                .addGap(18)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                        .addComponent(cid_text, GroupLayout.DEFAULT_SIZE, 469, Short.MAX_VALUE)
                                        .addComponent(rid_text, 469, 469, 469))
                                .addContainerGap())
                        .addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
                                .addContainerGap(263, Short.MAX_VALUE)
                                .addComponent(label_5)
                                .addGap(237))
        );
        gl_contentPane.setVerticalGroup(
                gl_contentPane.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addGap(90)
                                .addComponent(label_5)
                                .addGap(42)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(cid_text, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblNewlabel))
                                .addGap(18)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(rid_text, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(label))
                                .addGap(26)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(cdate_text, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(label_1))
                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                        .addComponent(day_text, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(label_2))
                                .addGap(18)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
                                        .addComponent(label_3, Alignment.LEADING)
                                        .addComponent(ldate_text, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(btn_add)
                                        .addComponent(btn_return))
                                .addGap(38))
        );
        contentPane.setLayout(gl_contentPane);
    }

    /**
     * 界面切换
     * @param evt
     */
    private void btn_returnMouseClicked(MouseEvent evt) {
        // TODO Auto-generated method stub
        this.setVisible(false);
        new ClientAddView().setVisible(true);
    }

    /**
     * 订单信息添加
     * @param evt
     */
    private void btn_addActionPerformed(ActionEvent evt) {
        // TODO Auto-generated method stub

        String cid = this.cid_text.getText();
        String rid = this.rid_text.getText();
        String ocomedate = this.cdate_text.getText();
        String oleavedate = this.ldate_text.getText();
        int odays = Integer.parseInt(day_text.getText());
        if(StringUtil.isEmpty(cid)){
            JOptionPane.showMessageDialog(null, "\u8eab\u4efd\u8bc1\u53f7\u7801\u4e0d\u80fd\u4e3a\u7a7a\uff01");
            return;
        }

        if(StringUtil.isEmpty(rid)){
            JOptionPane.showMessageDialog(null, "\u623f\u95f4\u53f7\u4e0d\u80fd\u4e3a\u7a7a\uff01");
            return;
        }
        Order order = new Order(cid,Integer.parseInt(rid),ocomedate,odays,oleavedate);
        Connection con = null;
        try{
            con=dbUtil.getCon();
            int addNum=orderDao.add(con, order);
            if(addNum==1){
                JOptionPane.showMessageDialog(null, "\u8ba2\u5355\u6dfb\u52a0\u6210\u529f\uff01");
                resetValue();
            }else{
                JOptionPane.showMessageDialog(null, "\u8ba2\u5355\u6dfb\u52a0\u5931\u8d25\uff01");
            }
        }catch(Exception e1){
            e1.printStackTrace();
            JOptionPane.showMessageDialog(null, "\u8ba2\u5355\u6dfb\u52a0\u5931\u8d25\uff01");
        }finally{
            try {
                dbUtil.closeCon(con);
            } catch (Exception e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
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
        this.cdate_text.setText("");
        this.day_text.setText("");
        this.ldate_text.setText("");

    }
}
