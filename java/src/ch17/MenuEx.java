package ch17;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MenuEx extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuEx frame = new MenuEx();
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
	public MenuEx() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);// 프레임에 메뉴바 붙이기

		JMenu mnNewMenu = new JMenu("파일");
		menuBar.add(mnNewMenu);// 메뉴바.추가(메뉴);

		JMenuItem mntmNewMenuItem = new JMenuItem("새파일");// 메뉴아이템
		mnNewMenu.add(mntmNewMenuItem);// 메뉴.추가(메뉴아이템);

		JMenuItem mntmNewMenuItem_1 = new JMenuItem("열기");
		mnNewMenu.add(mntmNewMenuItem_1);

		JMenuItem mntmNewMenuItem_2 = new JMenuItem("저장");
		mnNewMenu.add(mntmNewMenuItem_2);

		// 메뉴아이템 변수명
		JMenuItem miExit = new JMenuItem("종료");
		miExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(MenuEx.this, "Do you want to exit?", "Exit",
						JOptionPane.YES_NO_OPTION);
				if (result == JOptionPane.YES_OPTION) {// YES 클릭 시
					System.exit(0);// 프로그램 종료
				}
			}
		});
		mnNewMenu.add(miExit);

		JMenu mnNewMenu_1 = new JMenu("색상");
		menuBar.add(mnNewMenu_1);

		JMenuItem miRed = new JMenuItem("red");
		miRed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// ContentPane : 컨텐트 영역
				getContentPane().setBackground(Color.red);
				// getContentPane().setBackground(new Color(255, 0, 0));
			}
		});
		mnNewMenu_1.add(miRed);

		JMenuItem miGreen = new JMenuItem("green");
		miGreen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getContentPane().setBackground(Color.green);
			}
		});
		mnNewMenu_1.add(miGreen);

		JMenuItem miBlue = new JMenuItem("blue");
		miBlue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getContentPane().setBackground(Color.blue);
			}
		});
		mnNewMenu_1.add(miBlue);

		JMenu mnNewMenu_2 = new JMenu("도움말");
		menuBar.add(mnNewMenu_2);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

	}

}
