package com.itwill.shop.ui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.itwill.shop.service.MemberService;
import com.itwill.shop.vo.Member;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class MemberListPanel extends JPanel {
	private JTable memberListTable;
	
	
	/*************Service객체선언*************/
	MemberService memberService;
	private JList memberListList;
	private JTextField idTF;
	private JTextField passTF;
	private JTextField nameTF;
	private JTextField addressTF;
	private JTextField ageTF;
	private JTextField regDateTF;
	private JCheckBox marriedCHB;
	private JButton memberDeleteBtn;
	/*****************************************/
	/**
	 * Create the panel.
	 */
	public MemberListPanel() {
		setBackground(new Color(240, 230, 140));
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(195, 10, 497, 309);
		add(scrollPane);
		
		memberListTable = new JTable();
		memberListTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				/*******************Member 1명보여주기********************/
				try {
					int selectedRow = memberListTable.getSelectedRow();
					int selectedColumn=memberListTable.getSelectedColumn();
					//System.out.println(selectedRow+","+selectedColumn);
					String selectedId = (String)memberListTable.getValueAt(selectedRow, 0);
					//System.out.println("selected id:"+selectedId);
					
					Member member=memberService.findById(selectedId);
					idTF.setText(member.getM_id());
					passTF.setText(member.getM_password());
					nameTF.setText(member.getM_name());
					addressTF.setText(member.getM_address());
					ageTF.setText(member.getM_age()+"");
					if(member.getM_married().equals("T")) {
						marriedCHB.setSelected(true);
					}else {
						marriedCHB.setSelected(false);
					}
					regDateTF.setText(member.getM_regdate().toLocaleString().substring(0,10));
					memberDeleteBtn.setEnabled(true);
				}catch (Exception e1) {
					e1.printStackTrace();
				}
				/***********************************************/
				
			}
		});
		memberListTable.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
			},
			new String[] {
				"\uC544\uC774\uB514", "\uD328\uC4F0\uC6CC\uB4DC", "\uC774\uB984", "\uC8FC\uC18C", "\uB098\uC774", "\uACB0\uD63C\uC5EC\uBD80", "\uAC00\uC785\uC77C"
			}
		));
		scrollPane.setViewportView(memberListTable);
		
		JButton memberListJTableBtn = new JButton("회원리스트[JTable]");
		memberListJTableBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				memberListJTable();
				
			}
		});
		memberListJTableBtn.setBounds(353, 329, 180, 23);
		add(memberListJTableBtn);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(31, 10, 152, 172);
		add(scrollPane_1);
		
		memberListList = new JList();
		memberListList.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				try {
					if(e.getValueIsAdjusting()) {
						String selectedId = (String)memberListList.getSelectedValue();
						System.out.println(selectedId);
						/*********************아이디의회원보여주기*************************/
						Member member=memberService.findById(selectedId);
						idTF.setText(member.getM_id());
						passTF.setText(member.getM_password());
						nameTF.setText(member.getM_name());
						addressTF.setText(member.getM_address());
						ageTF.setText(member.getM_age()+"");
						if(member.getM_married().equals("T")) {
							marriedCHB.setSelected(true);
						}else {
							marriedCHB.setSelected(false);
						}
						regDateTF.setText(member.getM_regdate().toLocaleString().substring(0,10));
						memberDeleteBtn.setEnabled(true);
						/************************************************************/
					}
				}catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		scrollPane_1.setViewportView(memberListList);
		
		JButton memberListJListBtn = new JButton("회원리스트[JList]");
		memberListJListBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*******************회원리스트[JList]**********************/
				try {
					List<Member> memberList = memberService.findByAll();
					DefaultListModel defaultListModel=new  DefaultListModel();
					for (Member member : memberList) {
						defaultListModel.addElement(member.getM_id());
					}
					memberListList.setModel(defaultListModel);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				/**************************************************/
			}
		});
		memberListJListBtn.setBounds(31, 192, 152, 23);
		add(memberListJListBtn);
		
		JComboBox memberListComboBox = new JComboBox();
		memberListComboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				int state = e.getStateChange();
				if(state==ItemEvent.SELECTED) {
					String selectedName=(String)memberListComboBox.getSelectedItem();
					System.out.println(selectedName);
				}
			}
		});
		memberListComboBox.setBounds(31, 225, 152, 23);
		add(memberListComboBox);
		
		JButton memberListComboBoxBtn = new JButton("회원리스트[JComboBox]");
		memberListComboBoxBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*******************회원리스트[JComboBox]**********************/
				try {
					List<Member> memberList=memberService.findByAll();
					DefaultComboBoxModel defaultComboBoxModel=new DefaultComboBoxModel();
					for (Member member : memberList) {
						defaultComboBoxModel.addElement(member.getM_name());
					}
					memberListComboBox.setModel(defaultComboBoxModel);
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				/**************************************************************/
			}
		});
		memberListComboBoxBtn.setBounds(30, 258, 153, 23);
		add(memberListComboBoxBtn);
		
		JLabel idL = new JLabel("아이디");
		idL.setBounds(704, 32, 57, 15);
		add(idL);
		
		JLabel passwordL = new JLabel("패쓰워드");
		passwordL.setBounds(704, 69, 57, 15);
		add(passwordL);
		
		JLabel nameL = new JLabel("이름");
		nameL.setBounds(704, 111, 57, 15);
		add(nameL);
		
		JLabel addressL = new JLabel("주소");
		addressL.setBounds(704, 150, 57, 15);
		add(addressL);
		
		JLabel ageL = new JLabel("나이");
		ageL.setBounds(704, 196, 57, 15);
		add(ageL);
		
		JLabel marriedL = new JLabel("결혼여부");
		marriedL.setBounds(704, 242, 57, 15);
		add(marriedL);
		
		JLabel regDateL = new JLabel("가입일");
		regDateL.setBounds(704, 283, 57, 15);
		add(regDateL);
		
		idTF = new JTextField();
		idTF.setEditable(false);
		idTF.setBounds(772, 29, 116, 21);
		add(idTF);
		idTF.setColumns(10);
		
		passTF = new JTextField();
		passTF.setEditable(false);
		passTF.setBounds(773, 66, 116, 21);
		add(passTF);
		passTF.setColumns(10);
		
		nameTF = new JTextField();
		nameTF.setEditable(false);
		nameTF.setBounds(773, 108, 116, 21);
		add(nameTF);
		nameTF.setColumns(10);
		
		addressTF = new JTextField();
		addressTF.setEditable(false);
		addressTF.setBounds(772, 147, 116, 21);
		add(addressTF);
		addressTF.setColumns(10);
		
		ageTF = new JTextField();
		ageTF.setEditable(false);
		ageTF.setBounds(773, 193, 116, 21);
		add(ageTF);
		ageTF.setColumns(10);
		
		marriedCHB = new JCheckBox("");
		marriedCHB.setEnabled(false);
		marriedCHB.setBounds(773, 238, 115, 23);
		add(marriedCHB);
		
		regDateTF = new JTextField();
		regDateTF.setEditable(false);
		regDateTF.setBounds(773, 280, 116, 21);
		add(regDateTF);
		regDateTF.setColumns(10);
		
		memberDeleteBtn = new JButton("삭제");
		memberDeleteBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/****************회원삭제*****************/
				try {
					String idStr = idTF.getText();
					if(idStr.equals("")) {
						return;
					}
					int rowCount = memberService.memberUnRegister(idStr);
					idTF.setText("");
					passTF.setText("");
					nameTF.setText("");
					addressTF.setText("");
					ageTF.setText("");
					marriedCHB.setSelected(false);
					regDateTF.setText("");
					memberDeleteBtn.setEnabled(false);
					
					memberListJTable();
					
				}catch(Exception e1) {
					
				}
				/***************************************/
			}
		});
		memberDeleteBtn.setEnabled(false);
		memberDeleteBtn.setBounds(761, 329, 97, 23);
		add(memberDeleteBtn);
		
		/*************Service객체생성*************/
		memberService=new MemberService();
		/*****************************************/
	}
	
	
	private void memberListJTable() {
		/*******************회원리스트[JTable]**********************/
		try {
			List<Member> memberList = memberService.findByAll();
			
			Vector memberListVector=new Vector();
			for (Member member : memberList) {
				Vector memberVector=new Vector();
				memberVector.add(member.getM_id());
				memberVector.add(member.getM_password());
				memberVector.add(member.getM_name());
				memberVector.add(member.getM_address());
				memberVector.add(member.getM_age());
				memberVector.add(member.getM_married());
				memberVector.add(member.getM_regdate());
				memberListVector.add(memberVector);
			}
			
			Vector columnNames=new Vector();
			columnNames.add("아이디");
			columnNames.add("비밀번호");
			columnNames.add("이름");
			columnNames.add("주소");
			columnNames.add("나이");
			columnNames.add("결혼여부");
			columnNames.add("가입일");
			
			DefaultTableModel defaultTableModel=
					new DefaultTableModel(memberListVector,columnNames);
			memberListTable.setModel(defaultTableModel);
		} catch (Exception e1) {
			e1.printStackTrace();
			
		}
		/*************************************************/
	}
	
	
	
	
	
	
	
}