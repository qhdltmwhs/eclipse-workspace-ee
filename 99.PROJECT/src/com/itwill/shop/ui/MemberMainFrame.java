package com.itwill.shop.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.itwill.shop.vo.Member;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.CardLayout;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JTabbedPane;

public class MemberMainFrame extends JFrame {

	private JPanel contentPane;
	private JMenuItem loginMenuItem;
	private JMenuItem logoutMenuItem;
	private JMenuItem joinMenuItem;
	private JMenuItem exitMenuItem;
    //로그인멤버 변수선언
	Member loginMember;
	private JPanel baseCardLayoutPanel;
	private JPanel mainImagePanel;
	private JPanel memberPanel;
	private JLabel imageL;
	private JTabbedPane memberTabbedPane;
	private MemberListPanel memberListPanel;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MemberMainFrame frame = new MemberMainFrame();
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
	public MemberMainFrame() {
		setTitle("회원관리");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 956, 591);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu memberMenu = new JMenu("회원");
		menuBar.add(memberMenu);
		
		loginMenuItem = new JMenuItem("로그인");
		loginMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*
				 * 로그인 다이알로그 띄우기
				 */
				/*
				 모달 윈도(Modal Window)는 사용자 인터페이스 디자인 개념에서 
				 자식 윈도에서 부모 윈도로 돌아가기 전에 사용자의 상호동작을 요구하는 창을 말한다. 
				 그래서 응용 프로그램의 주 창의 작업 흐름을 방해한다. 
				 일반적으로 모달 대화상자로 불리는데, 그 이유는 대화상자를 부를 때 흔히 사용되기 때문이다. 
				 우리가 자주 사용하는 파일 열기/저장 대화상자를 생각하면 이해하기 쉽다
				 */
				MemberLoginDialog loginDialog=new MemberLoginDialog();
				//익명의 inner 클래스여서 클래스이름.this적용
				loginDialog.setMemberMainFrame(MemberMainFrame.this);
				loginDialog.setModal(true);
				loginDialog.setVisible(true);
			}
		});
		memberMenu.add(loginMenuItem);
		
		logoutMenuItem = new JMenuItem("로그아웃");
		logoutMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				logoutProcess();
			}
			
		});
		memberMenu.add(logoutMenuItem);
		
		joinMenuItem = new JMenuItem("가입");
		joinMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MemberJoinDialog memberJoinDialog=new MemberJoinDialog();
				memberJoinDialog.setModal(true);
				memberJoinDialog.setVisible(true);
				
			}
		});
		memberMenu.add(joinMenuItem);
		
		JSeparator separator = new JSeparator();
		memberMenu.add(separator);
		
		exitMenuItem = new JMenuItem("종료");
		exitMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				System.exit(0);
				/*
				Terminates the currently running Java Virtual Machine.
				*/
			}
		});
		memberMenu.add(exitMenuItem);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		baseCardLayoutPanel = new JPanel();
		contentPane.add(baseCardLayoutPanel, BorderLayout.CENTER);
		baseCardLayoutPanel.setLayout(new CardLayout(0, 0));
		
		mainImagePanel = new JPanel();
		baseCardLayoutPanel.add(mainImagePanel, "imagePanel");
		mainImagePanel.setLayout(new BorderLayout(0, 0));
		
		imageL = new JLabel("");
		imageL.setHorizontalAlignment(SwingConstants.CENTER);
		imageL.setIcon(new ImageIcon("C:\\JAVA_BACKEND\\image.jpg"));
		mainImagePanel.add(imageL, BorderLayout.CENTER);
		
		memberPanel = new JPanel();
		memberPanel.setBackground(new Color(102, 205, 170));
		baseCardLayoutPanel.add(memberPanel, "memberPanel");
		memberPanel.setLayout(new BorderLayout(0, 0));
		
		memberTabbedPane = new JTabbedPane(JTabbedPane.TOP);
		memberPanel.add(memberTabbedPane, BorderLayout.CENTER);
		
		memberListPanel = new MemberListPanel();
		memberTabbedPane.addTab("회원리스트", null, memberListPanel, null);
		
		logoutProcess();
	}
	/********************************************/
	public void loginProcess(Member loginMember) {
		/*
		 * 0.로그인멤버 저장
		 * 1.MemberMainFrame타이틀변경
		 * 2.로그인,회원가입메뉴아이템 불활성화
		 * 3.로그아웃메뉴아이템 활성화
		 */
		this.loginMember=loginMember;
		setTitle(loginMember.getM_name()+" 님 로그인");
		loginMenuItem.setEnabled(false);
		logoutMenuItem.setEnabled(true);
		joinMenuItem.setEnabled(false);
		CardLayout cl=(CardLayout)baseCardLayoutPanel.getLayout();
		cl.show(baseCardLayoutPanel, "memberPanel");
	}
	public void logoutProcess() {
		this.loginMember=null;
		setTitle("");
		loginMenuItem.setEnabled(true);
		logoutMenuItem.setEnabled(false);
		joinMenuItem.setEnabled(true);
		CardLayout cl=(CardLayout)baseCardLayoutPanel.getLayout();
		cl.show(baseCardLayoutPanel, "imagePanel");
	}
	
}