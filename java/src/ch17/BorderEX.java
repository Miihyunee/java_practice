package ch17;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class BorderEX extends JFrame {// JFraem 클래스 상속받음
	public BorderEX() {// 생성자
		JButton button1 = new JButton("Button 1");
		JButton button2 = new JButton("Button 2");
		JButton button3 = new JButton("Button 3");
		JButton button4 = new JButton("Button 4");
		JButton button5 = new JButton("Button 5");
		JButton button6 = new JButton("Button 6");
		// 프레임에 추가
		add(button1);
		add(button2, "North");// add(컴포넌트, 위치) *위치는 대문자로 써야함
		add(button3, "South");
		add(button4, "East");
		JPanel p = new JPanel(); // p 패널을 생성
		p.add(button5);// P패널에 버튼5,6 담기
		p.add(button6);
		add(p, "West");// p를 West로 배치

		setSize(500, 500);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new BorderEX();// 생성자 호출
	}
}
