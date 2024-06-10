package ch17;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

class MyColorAction implements ActionListener {// ActionListener 인터페이스 구현
	private JFrame f;
	private Color c;
	private Container con;

	public MyColorAction(JFrame f, Color c) {// MyColorAction(프레임, 컬러)
		this.f = f;
		con = f.getContentPane();// 프레임의 내용구분(헤더,바 X)
		this.c = c;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		con.setBackground(c); // 배경색상 변경
	}
}

public class EventEx3 extends JFrame {// JFrame 클래스 상속받음
	// 필드변수, 프로퍼티 변수
	private JButton button1, button2, button3;

	public EventEx3() {// 생성자
		setLayout(new FlowLayout());// FlowLayout으로 레이아웃 변경
		button1 = new JButton("Red");
		button2 = new JButton("Green");
		button3 = new JButton("Blue");
		// 프레임에 버튼 추가
		add(button1);
		add(button2);
		add(button3);
		// 이벤트대상.리스너(처리);
		button1.addActionListener(new MyColorAction(this, Color.red));
		button2.addActionListener(new MyColorAction(this, Color.green));
		button3.addActionListener(new MyColorAction(this, Color.blue));
		setSize(450, 300);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new EventEx3();// 인스턴스 생성, 생성자 호출
	}
}
