package com.itwill.wb.container;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JButton;

public class MemberDeletePanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public MemberDeletePanel() {
		setBackground(new Color(0, 206, 209));
		setLayout(null);
		
		JButton deleteBtn = new JButton("삭제");
		deleteBtn.setBounds(101, 224, 97, 23);
		add(deleteBtn);
		
		JButton cancleBtn = new JButton("취소");
		cancleBtn.setBounds(257, 224, 97, 23);
		add(cancleBtn);

	}
}