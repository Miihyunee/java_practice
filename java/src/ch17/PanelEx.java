package ch17;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class PanelEx extends JFrame {// JFrame 클래스를 상속받음
	public PanelEx() {// 생성자
		JPanel p = new JPanel();
		p.setBackground(Color.lightGray);// 배경색 설정
		//버튼객체                        텍스트
		JButton button1 = new JButton("Button 1");
		JButton button2 = new JButton("Button 2");
		JButton button3 = new JButton("Button 3");
		//패널.추가(버튼);
		p.add(button1);
		p.add(button2);
		p.add(button3);
		//프레임.추가(패널);
		add(p);
		setSize(300, 300);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new PanelEx();// 생성자 호출
	}
}
