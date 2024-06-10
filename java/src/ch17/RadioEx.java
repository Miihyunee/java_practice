package ch17;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class RadioEx extends JFrame {// JFrame 상속받음

	private static final long serialVersionUID = 1L;// 클래스의 버전(실행에는 영향없음)
	private JPanel contentPane; // JFrame - JPanel - 라디오버튼 3개의 구조
	private final ButtonGroup buttonGroup = new ButtonGroup();// final : 변경불가

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RadioEx frame = new RadioEx();// 프레임 인스턴스 생성, 생성자 호출
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
	public RadioEx() {// 생성자 실행
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);

		JRadioButton rdoRed = new JRadioButton("Red");// "Red" 텍스트를 가진 라디오 버튼 생성
		rdoRed.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {// 아이템 상태가 바뀔 때 : selected, deselected
				contentPane.setBackground(Color.RED);// 배경색을 RED로 변경
			}
		});
		buttonGroup.add(rdoRed);// 버튼그룹에 rdoRed 라디오 버튼 추가
		contentPane.add(rdoRed);// 패널에 rdoRed 라디오 버튼 추가

		JRadioButton rdoGreen = new JRadioButton("Green");
		rdoGreen.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				contentPane.setBackground(Color.GREEN);
			}
		});
		buttonGroup.add(rdoGreen);
		contentPane.add(rdoGreen);

		JRadioButton rdoBlue = new JRadioButton("Blue");
		rdoBlue.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				contentPane.setBackground(Color.BLUE);
			}
		});
		buttonGroup.add(rdoBlue);
		contentPane.add(rdoBlue);
	}

}
