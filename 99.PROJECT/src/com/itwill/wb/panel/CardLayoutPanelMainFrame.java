package com.itwill.wb.panel;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.CardLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CardLayoutPanelMainFrame extends JFrame {

	private JPanel contentPane;
	private JPanel cardLayoutPanel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CardLayoutPanelMainFrame frame = new CardLayoutPanelMainFrame();
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
	public CardLayoutPanelMainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		cardLayoutPanel = new JPanel();
		cardLayoutPanel.setBackground(new Color(173, 255, 47));
		contentPane.add(cardLayoutPanel, BorderLayout.CENTER);
		cardLayoutPanel.setLayout(new CardLayout(0, 0));
		
		FirstPanel firstPanel = new FirstPanel();
		cardLayoutPanel.add(firstPanel, "first");
		
		SecondPanel secondPanel = new SecondPanel();
		cardLayoutPanel.add(secondPanel, "second");
		
		ThirdPanel thirdPanel = new ThirdPanel();
		cardLayoutPanel.add(thirdPanel, "third");
		
		FourthPanel fourthPanel = new FourthPanel();
		cardLayoutPanel.add(fourthPanel, "fourth");
		
		JPanel menupanel = new JPanel();
		menupanel.setBackground(new Color(46, 139, 87));
		contentPane.add(menupanel, BorderLayout.SOUTH);
		
		JButton firstBtn = new JButton("First");
		firstBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cl =(CardLayout)cardLayoutPanel.getLayout();
				cl.show(cardLayoutPanel, "first");
			}
		});
		menupanel.add(firstBtn);
		
		JButton secondBtn = new JButton("Second");
		secondBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cl =(CardLayout)cardLayoutPanel.getLayout();
				cl.show(cardLayoutPanel, "second");
			}
		});
		menupanel.add(secondBtn);
		
		JButton thirdBtn = new JButton("Third");
		thirdBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cl =(CardLayout)cardLayoutPanel.getLayout();
				cl.show(cardLayoutPanel, "third");
			}
		});
		menupanel.add(thirdBtn);
		
		JButton fourthBtn = new JButton("Fourth");
		fourthBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cl =(CardLayout)cardLayoutPanel.getLayout();
				cl.show(cardLayoutPanel, "fourth");
			}
		});
		menupanel.add(fourthBtn);
	}

}
