package ch17;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.Color;

public class ClockEx extends JFrame implements Runnable {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;// private 외부사용금지
	private Calendar cal;
	private String str;
	private JLabel lblTime;// 필드변수로 이동

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {// 내부클래스
			public void run() {
				try {
					ClockEx frame = new ClockEx();// 인스턴스 셍성, 생성자 호출
					frame.setVisible(true);
				} catch (Exception e) {// 예외처리
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ClockEx() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// 닫기동작설정
		setBounds(100, 100, 450, 300);// 범위지정(x, y, width, height)
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));// 테두리 설정
		contentPane.setLayout(new BorderLayout(0, 0));// 레이아웃 설정
		setContentPane(contentPane);// 컨텐트 영역에 패널을 붙임

		JButton btnExit = new JButton("Exit");// "Exit" 텍스트를 가진 버튼 생성
		btnExit.addActionListener(new ActionListener() {// 내부클래스
			public void actionPerformed(ActionEvent e) {
				System.exit(0);// 종료
			}
		});
		contentPane.add(btnExit, BorderLayout.SOUTH);// 패널의 SOUTH 영역에 버튼 추가
		lblTime = new JLabel("New label");// 레이블 생성
		lblTime.setForeground(new Color(100, 149, 237));// foreground 전경색, 글자색
		lblTime.setFont(new Font("나눔고딕", Font.BOLD, 25));// 폰트설정
		lblTime.setHorizontalAlignment(SwingConstants.CENTER);// setHorizontalAlignment : 가로 정렬방식
		contentPane.add(lblTime, BorderLayout.CENTER);// 패널의 가운데에 레이블 추가
		Thread t = new Thread(this);// 시간처리를 위한 스레드
		t.start();// run()실행

	}

	@Override
	public void run() {
		while (true) {
			cal = Calendar.getInstance();
			str = String.format("%4d-%02d-%02d %02d:%02d:%02d", cal.get(Calendar.YEAR), cal.get(Calendar.MONTH) + 1,
					cal.get(Calendar.DATE), cal.get(Calendar.HOUR_OF_DAY), cal.get(Calendar.MINUTE),
					cal.get(Calendar.SECOND));
			lblTime.setText(str);
			try {
				Thread.sleep(1000);// CPU 실행 강제로 멈춤
			} catch (InterruptedException e) {// CPU 간섭 - Thread.sleep()의 예외처리
				e.printStackTrace();
			}
		}
	}
}
