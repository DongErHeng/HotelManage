package com.software.project.view;

import com.software.project.dao.ClientDao;
import com.software.project.model.Client;
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

public class ClientAddView extends JFrame{

    private JPanel contentPane;
    private JTextField id_text;
    private JTextField name_text;
    private JTextField age_text;
    private JTextField sex_text;
    private JTextField tel_text;
    private DBUtil dbUtil = new DBUtil();
    private ClientDao clientDao = new ClientDao();

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ClientAddView frame = new ClientAddView();
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
    public ClientAddView() {
        setTitle("\u9152\u5E97\u7BA1\u7406\u7CFB\u7EDF");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 580, 450);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        JLabel label = new JLabel("\u8EAB\u4EFD\u8BC1\u53F7\u7801\uFF1A");
        label.setFont(new Font("华文行楷", Font.PLAIN, 18));

        JLabel label_1 = new JLabel("\u59D3           \u540D\uFF1A");
        label_1.setFont(new Font("华文行楷", Font.PLAIN, 18));

        JLabel label_2 = new JLabel("\u6027           \u522B\uFF1A");
        label_2.setFont(new Font("华文行楷", Font.PLAIN, 18));

        JLabel label_3 = new JLabel("\u5E74           \u9F84\uFF1A");
        label_3.setFont(new Font("华文行楷", Font.PLAIN, 18));

        id_text = new JTextField();
        id_text.setColumns(10);

        name_text = new JTextField();
        name_text.setColumns(10);

        age_text = new JTextField();
        age_text.setColumns(10);

        JButton btn_add = new JButton("\u6DFB\u52A0");
        btn_add.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btn_addActionPerformed(evt);
            }

        });
        btn_add.setFont(new Font("华文行楷", Font.PLAIN, 18));

        JButton btn_return = new JButton("\u8FD4\u56DE");
        btn_return.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                btn_returnMouseClicked(evt);
            }

        });
        btn_return.setFont(new Font("华文行楷", Font.PLAIN, 18));

        sex_text = new JTextField();
        sex_text.setColumns(10);

        JLabel label_4 = new JLabel("\u8054 \u7CFB \u65B9 \u5F0F \uFF1A");
        label_4.setFont(new Font("华文行楷", Font.PLAIN, 18));

        tel_text = new JTextField();
        tel_text.setColumns(10);

        JButton btn_order = new JButton("\u8BA2\u623F\u5904\u7406");
        btn_order.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                btn_orderMouseClicked(evt);
            }

        });
        btn_order.setFont(new Font("华文行楷", Font.PLAIN, 18));

        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        gl_contentPane.setHorizontalGroup(
                gl_contentPane.createParallelGroup(Alignment.TRAILING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addGap(50)
                                .addComponent(btn_add, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 192, Short.MAX_VALUE)
                                .addComponent(btn_order)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 192, Short.MAX_VALUE)
                                .addComponent(btn_return, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
                                .addGap(109))
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addGap(50)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                                                        .addComponent(label)
                                                                        .addComponent(label_1)
                                                                        .addComponent(label_2)
                                                                        .addComponent(label_3)
                                                                        .addComponent(label_4))
                                                                .addPreferredGap(ComponentPlacement.RELATED)
                                                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
                                                                        .addComponent(name_text)
                                                                        .addComponent(id_text, GroupLayout.DEFAULT_SIZE, 308, Short.MAX_VALUE)
                                                                        .addComponent(sex_text, GroupLayout.PREFERRED_SIZE, 310, GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(age_text, GroupLayout.DEFAULT_SIZE, 310, Short.MAX_VALUE)
                                                                        .addComponent(tel_text, GroupLayout.PREFERRED_SIZE, 310, GroupLayout.PREFERRED_SIZE))
                                                        )
                                                )
                                                .addGap(126)
                                        )
                                )
                        )
        );
        gl_contentPane.setVerticalGroup(
                gl_contentPane.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addGap(26)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(label)
                                        .addComponent(id_text, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(31)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(label_1)
                                        .addComponent(name_text, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(31)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                        .addComponent(label_2)
                                        .addComponent(sex_text, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(31)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(label_3)
                                        .addComponent(age_text, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(31)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(label_4)
                                        .addComponent(tel_text, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(50)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(btn_add, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btn_order, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btn_return, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
                        )
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
        new MainView().setVisible(true);
    }

    private void btn_orderMouseClicked(MouseEvent evt) {
        // TODO Auto-generated method stub
        this.setVisible(false);
        new OrderAddView().setVisible(true);
    }

    /**
     * 客户信息增加
     * @param evt
     */
    private void btn_addActionPerformed(ActionEvent evt) {
        // TODO Auto-generated method stub
        String cid = this.id_text.getText();
        String cname = this.name_text.getText();
        String csex = this.sex_text.getText();
        String ctel = this.tel_text.getText();
        int cage = Integer.parseInt(age_text.getText());
        if(StringUtil.isEmpty(cid)){
            JOptionPane.showMessageDialog(null, "\u8eab\u4efd\u8bc1\u53f7\u7801\u4e0d\u80fd\u4e3a\u7a7a\uff01");
            return;
        }

        if(StringUtil.isEmpty(cname)){
            JOptionPane.showMessageDialog(null, "\u59d3\u540d\u4e0d\u80fd\u4e3a\u7a7a\uff01");
            return;
        }

        Boolean sex = false;
        if ("\u7537".equals(csex.trim())){
            sex = false;
        }else if ("\u5973".equals(csex.trim())){
            sex = true;
        }else {
            JOptionPane.showMessageDialog(null, "\u6027\u522b\u5fc5\u987b\u4e3a\u7537\u6216\u5973\uff01");
            return;
        }

        Client client = new Client(cid,cname,sex,cage,ctel);
        Connection con = null;
        try{
            con=dbUtil.getCon();
            int addNum=clientDao.add(con, client);
            if(addNum==1){
                JOptionPane.showMessageDialog(null, "\u5ba2\u6237\u6dfb\u52a0\u6210\u529f\uff01");
                resetValue();
            }else{
                JOptionPane.showMessageDialog(null, "\u5ba2\u6237\u6dfb\u52a0\u5931\u8d25\uff01");
            }
        }catch(Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "\u5ba2\u6237\u6dfb\u52a0\u5931\u8d25\uff01");
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
        this.id_text.setText("");
        this.name_text.setText("");
        this.sex_text.setText("");
        this.age_text.setText("");
        this.tel_text.setText("");
    }
}