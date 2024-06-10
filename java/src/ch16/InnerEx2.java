package ch16;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class InnerEx2 extends Frame {
	public InnerEx2() {// 생성자
		setSize(300, 400);// 화면사이즈
		setVisible(true);// 화면에 출력되도록
	}

	public static void main(String[] args) {
		InnerEx2 e = new InnerEx2();// 인스턴스 생성
		e.addWindowListener(new WindowAdapter() {// 무명클래스
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);// 프로그램 종료
			}
		});
	}
}
