package ch17;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class FlowEx extends JFrame {
	public FlowEx() {
		setLayout(new FlowLayout()); // 레이아웃 변경, JFrame : BorderLayout이 기본
		JButton button1 = new JButton("Button1");
		JButton button2 = new JButton("Button2");
		JButton button3 = new JButton("Button3");
		add(button1);
		add(button2);
		add(button3);
		setSize(400, 200);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new FlowEx();// 인스턴스 생성(메모리에 올라감), 생성자 호출
	}
}
