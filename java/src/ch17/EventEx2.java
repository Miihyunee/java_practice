package ch17;

import java.awt.Frame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class EventEx2 extends Frame implements WindowListener {
//Frame 클래스 상속받고, WindowListener 인터페이스 구현

	public EventEx2() {// 생성자
		//이벤트소스.리스너(핸들러); = 대상.감시자(처리기);
		addWindowListener(this);
		setSize(300, 300);
		setVisible(true);
	}

	public static void main(String[] args) {
		new EventEx2();// 인스턴스 생성, 생성자 호출
	}

	@Override
	public void windowOpened(WindowEvent e) {

	}

	@Override
	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}

	@Override
	public void windowClosed(WindowEvent e) {

	}

	@Override
	public void windowIconified(WindowEvent e) {

	}

	@Override
	public void windowDeiconified(WindowEvent e) {

	}

	@Override
	public void windowActivated(WindowEvent e) {// 윈도우 활성화

	}

	@Override
	public void windowDeactivated(WindowEvent e) {// 윈도우 비활성화

	}

}
