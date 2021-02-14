package com.itwill.wb.container;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTabbedPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.BoxLayout;

public class JTabbedPaneJFrame extends JFrame {

	private JPanel contentPane;
	private JTabbedPane memberTabbedPane;
	private JPanel mainPanel;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JTabbedPaneJFrame frame = new JTabbedPaneJFrame();
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
	public JTabbedPaneJFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 746, 549);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		mainPanel = new JPanel();
		mainPanel.setBackground(Color.PINK);
		contentPane.add(mainPanel, BorderLayout.CENTER);
		mainPanel.setLayout(new BorderLayout(0, 0));
		
		memberTabbedPane = new JTabbedPane(JTabbedPane.TOP);
		mainPanel.add(memberTabbedPane, BorderLayout.CENTER);
		
		JPanel memberLoginPanel = new JPanel();
		memberLoginPanel.setBackground(Color.GRAY);
		memberTabbedPane.addTab("회원로그인", null, memberLoginPanel, null);
		memberLoginPanel.setLayout(null);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(154, 304, 97, 23);
		memberLoginPanel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setBounds(390, 304, 97, 23);
		memberLoginPanel.add(btnNewButton_1);
		
		textField = new JTextField();
		textField.setBounds(379, 156, 116, 21);
		memberLoginPanel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(379, 232, 116, 21);
		memberLoginPanel.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(154, 147, 57, 15);
		memberLoginPanel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(154, 215, 57, 15);
		memberLoginPanel.add(lblNewLabel_1);
		
		JPanel memberAddPanel = new JPanel();
		memberAddPanel.setBackground(Color.GREEN);
		memberTabbedPane.addTab("회원추가", null, memberAddPanel, null);
		
		JPanel memberListPanel = new JPanel();
		memberListPanel.setBackground(Color.YELLOW);
		memberTabbedPane.addTab("회원리스트", null, memberListPanel, null);
		
		JPanel memberDetailPanel = new JPanel();
		memberDetailPanel.setBackground(Color.ORANGE);
		memberTabbedPane.addTab("회원상세보기", null, memberDetailPanel, null);
		
		MemberDeletePanel memberDeletePanel = new MemberDeletePanel();
		memberTabbedPane.addTab("회원삭제", null, memberDeletePanel, null);
	}
}