package com.itwill.wb.file;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;

public class ImageFileJFrame extends JFrame {

	private JPanel contentPane;
	private JLabel imageL;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ImageFileJFrame frame = new ImageFileJFrame();
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
	public ImageFileJFrame() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\JAVA_BACKEND\\image.jpg"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 335);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel mainPanel = new JPanel();
		contentPane.add(mainPanel, BorderLayout.CENTER);
		mainPanel.setLayout(null);
		
		imageL = new JLabel("");
		imageL.setIcon(new ImageIcon("C:\\JAVA_BACKEND\\image.jpg"));
		imageL.setBounds(12, 10, 400, 231);
		mainPanel.add(imageL);
		
		JButton imageSelectBtn = new JButton("이미지선택");
		imageSelectBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser jfc = new JFileChooser("C:\\JAVA_BACKEND\\image");
				/*
				 * 파일선택기가뜨고 스레드 대기
				 */
				int openOrCancel = jfc.showOpenDialog(ImageFileJFrame.this);
				if(openOrCancel == JFileChooser.APPROVE_OPTION) {
					//열기
					File selectedFile = jfc.getSelectedFile();
					imageL.setIcon(new ImageIcon(selectedFile.getAbsolutePath()));
				}
			}
		});
		imageSelectBtn.setBounds(180, 251, 97, 23);
		mainPanel.add(imageSelectBtn);
	}
}
