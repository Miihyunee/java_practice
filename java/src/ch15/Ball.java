package ch15;

import java.awt.Color;
import java.awt.Dimension; //윈도우창 조절
import java.awt.Graphics;//그림을 그리기 위한 도구
import java.awt.Image;

import javax.swing.JFrame; //GUI 제공

class MyFrame extends JFrame implements Runnable {
	// 필드변수, 프로퍼티 변수
	private int x, y = 50; // 좌표값
	private int moveX = 2, moveY = 3;// 이동값
	private Graphics bg; // 그래픽처리
	private Image offScreen;
	private Dimension dim;// 가로*세로 사이즈 지정

	public MyFrame() { // 생성자
		setSize(500, 500);// 화면 사이즈 500*500(Jframe 에서 상속받은 함수)
		setResizable(false); // 프레임의 크기를 사용자가 지정
		setVisible(true);// 화면에 표시할 것인지
		setDefaultCloseOperation(EXIT_ON_CLOSE);// 윈도우창 종료 시 프로세스까지 닫기

		dim = getSize();// 화면사이즈 계산하는 함수
		offScreen = createImage(dim.width, dim.height);// 이미지생성(가로, 세로)
		bg = offScreen.getGraphics();// 그래픽 처리 객체 생성
		Thread t = new Thread(this);// 멀티스레드 생성
		t.start(); // run()함수가 실행됨
	}

	@Override // 매서드 재정의
	public void update(Graphics g) {// 화면 출력 준비 작업
		bg.setColor(Color.black);
		// fillRect(기준좌표, 가로길이, 세로길이) : 사각형 채우기
		bg.fillRect(0, 0, getWidth(), getHeight());
		bg.setColor(Color.green);
		// fillOval(기준좌표, 가로길이, 세로길이) : 원 채우기
		bg.fillOval(x, y, 30, 30);
	}

	@Override
	public void paint(Graphics g) {// 화면 출력
		super.paint(g);
		// 이미지 화면에 출력(이미지, 기준좌표, 이미지관찰자)
		g.drawImage(offScreen, 0, 0, this);
		update(g); // 출력 준비
	}

	@Override
	public void run() {
		while (true) {// 무한반복
			if (x > (dim.width - 30) || x < 0) { // 원의 이동을 위한 조건
				moveX = -moveX;
			}
			x = x + moveX;
			if (y > (dim.height - 30) || y < 30) {
				moveY = -moveY;
			}
			y = y + moveY;
			// System.out.println(x + "," +y);
			repaint();// 그래픽 새로 그리기
			try {
				Thread.sleep(10); // CPU 실행 멈춤
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

public class Ball {
	public static void main(String[] args) {
		new MyFrame(); // 생성자 호출
	}
}
