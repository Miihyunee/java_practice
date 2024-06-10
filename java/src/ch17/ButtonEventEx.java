package ch17;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ButtonEventEx extends JFrame {// JFrame 클래스 상속받음

	private static final long serialVersionUID = 1L;// 없어도 실행 가능
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {// 메인함수
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ButtonEventEx frame = new ButtonEventEx();
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
	public ButtonEventEx() {// 생성자
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// x버튼 클릭 시 프로그램 종료
		setBounds(100, 100, 450, 300);// (x, y, width, height) 프레임의 위치와 사이즈 설정
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));// 테두리 설정

		setContentPane(contentPane);// 내용영역

		// 버튼 생성
		JButton btnRed = new JButton("Red");
		// 대상.리스터(처리기)
		btnRed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.setBackground(Color.red);
			}
		});
		contentPane.add(btnRed);

		JButton btnBlue = new JButton("Blue");
		btnBlue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.setBackground(Color.blue);
			}
		});
		contentPane.add(btnBlue);

		JButton btnGreen = new JButton("Green");
		btnGreen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.setBackground(Color.green);
			}
		});
		contentPane.add(btnGreen);

		JButton btnYellow = new JButton("Yellow");
		btnYellow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.setBackground(Color.yellow);
			}
		});
		contentPane.add(btnYellow);
	}

}
