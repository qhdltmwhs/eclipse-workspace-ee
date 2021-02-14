package com.itwill.wb.container;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JSplitPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JSplitPaneJFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JSplitPaneJFrame frame = new JSplitPaneJFrame();
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
	public JSplitPaneJFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 980, 655);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel mainPanel = new JPanel();
		mainPanel.setBackground(Color.ORANGE);
		contentPane.add(mainPanel, BorderLayout.CENTER);
		mainPanel.setLayout(new BorderLayout(0, 0));
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setOneTouchExpandable(true);
		splitPane.setResizeWeight(0.2);
		mainPanel.add(splitPane, BorderLayout.CENTER);
		
		JPanel leftMenuPanel = new JPanel();
		leftMenuPanel.setBackground(new Color(30, 144, 255));
		leftMenuPanel.setForeground(new Color(173, 216, 230));
		splitPane.setLeftComponent(leftMenuPanel);
		leftMenuPanel.setLayout(null);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(41, 74, 97, 23);
		leftMenuPanel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setBounds(41, 133, 97, 23);
		leftMenuPanel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("New button");
		btnNewButton_2.setBounds(41, 184, 97, 23);
		leftMenuPanel.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("New button");
		btnNewButton_3.setBounds(41, 244, 97, 23);
		leftMenuPanel.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("New button");
		btnNewButton_4.setBounds(41, 301, 97, 23);
		leftMenuPanel.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("New button");
		btnNewButton_5.setBounds(41, 359, 97, 23);
		leftMenuPanel.add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("New button");
		btnNewButton_6.setBounds(41, 427, 97, 23);
		leftMenuPanel.add(btnNewButton_6);
		
		JPanel rightContentPanel = new JPanel();
		rightContentPanel.setBackground(new Color(189, 183, 107));
		rightContentPanel.setForeground(new Color(255, 182, 193));
		splitPane.setRightComponent(rightContentPanel);
	}

}