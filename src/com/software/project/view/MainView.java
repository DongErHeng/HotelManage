package com.software.project.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

public class MainView extends JFrame{

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainView frame = new MainView();
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
	public MainView() {
		setTitle("\u9152\u5E97\u7BA1\u7406\u7CFB\u7EDF");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(MainView.class.getResource("/image/Hotel.png")));
		
		JButton btn_client = new JButton("\u987E\u5BA2\u4FE1\u606F");
		btn_client.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent evt) {
				//btn_clientMouseClicked(evt);
			}

		});
		btn_client.setFont(new Font("华文行楷", Font.PLAIN, 24));
		
		JButton btn_search = new JButton("\u623F\u95F4\u67E5\u8BE2");
		btn_search.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent evt) {
				//btn_searchMouseClicked(evt);
			}

		});
		btn_search.setFont(new Font("华文行楷", Font.PLAIN, 24));
		
		JButton btn_order = new JButton("\u9000\u6362\u623F\u95F4");
		btn_order.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent evt) {
				//btn_orderMouseClicked(evt);
			}

		});
		btn_order.setFont(new Font("华文行楷", Font.PLAIN, 24));

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(210)
					.addComponent(lblNewLabel)
					.addContainerGap(268, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(218)
					.addComponent(btn_search))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(218)
					.addComponent(btn_order))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(218)
					.addComponent(btn_client))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel)
					.addGap(50)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btn_client))
					//.addPreferredGap(ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
					.addGap(25)
					.addGroup(gl_contentPane.createParallelGroup()
						.addComponent(btn_search))
					.addGap(25)
					.addGroup(gl_contentPane.createParallelGroup()
						.addComponent(btn_order))
				)
		);
		contentPane.setLayout(gl_contentPane);
	}
}
