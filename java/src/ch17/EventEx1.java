package ch17;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class EventEx1 extends Frame {// Frame 클래스를 상속받음
	public EventEx1() {// 생성자 실행
		addWindowListener(new WindowAdapter() {// 이벤트 처리
			public void windowClosing(WindowEvent e) {
				System.exit(0); // 0 : 정상 종료, 1: 비정상 종료
			}
		});
		setSize(300, 300);
		setVisible(true);
	}

	public static void main(String[] args) {
		new EventEx1();// 인스턴스 생성, 생성자 호출
	}
}
