package ch17;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;

public class KeyMouseEx extends JFrame implements KeyListener, MouseListener, MouseMotionListener {
	private int x, y;// 이미지 좌표값
	private int width, height;// 이미지 사이즈
	private Image img;// 이미지 저장 객체

	public KeyMouseEx() {// 생성자
		// 대상이 앞에 선언되지 않음 → 현재 프레임이 대상
		addKeyListener(this);// 키이벤트
		addMouseListener(this);// 마우스이벤트
		addMouseMotionListener(this);// 마우스동작이벤트

		// getClass() 현재 실행 중인 클래스, getResource() 현재 실행 중인 클래스와 같은 디렉토리
		img = Toolkit.getDefaultToolkit().getImage(getClass().getResource("tomato.png"));

		setFocusable(true);// 포커스 받을 수 있게 설정
		requestFocus();// 커서 입력가능 상태
		setSize(500, 500);// 사이즈 설정
		setVisible(true);// 화면에 출력
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public void paint(Graphics g) {// 그래픽 처리 함수
		super.paint(g);// super → 프레임
		width = img.getWidth(this);// 이미지 가로사이즈
		height = img.getHeight(this);// 이미지 세로사이즈
		g.drawImage(img, x, y, this);// 이미지 그리기
	}

	@Override
	public void keyTyped(KeyEvent e) {// 키 입력
	}

	@Override
	public void keyPressed(KeyEvent e) {// 키 입력한 상태
		switch (e.getKeyCode()) {
		case KeyEvent.VK_UP:
			y = Math.max(50, y - 5);
			break;
		case KeyEvent.VK_DOWN:
			y = Math.min(480 - height, y + 5);
			break;
		case KeyEvent.VK_LEFT:
			x = Math.max(20, x - 5);
			break;
		case KeyEvent.VK_RIGHT:
			x = Math.min(480 - width, x + 5);
			break;
		}
		repaint();
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

	@Override
	public void mouseClicked(MouseEvent e) {// 마우스 클릭 시
		x = e.getX();// 마우스 x 좌표
		y = e.getY();// 마우스 y 좌표
		repaint();// 그래픽 새로 그리기
	}

	@Override
	public void mousePressed(MouseEvent e) {// 마우스 클릭한 상태
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {// 영역 안에 들어갈 때
	}

	@Override
	public void mouseExited(MouseEvent e) {// 영역을 빠져나갈 떄
	}

	@Override
	public void mouseDragged(MouseEvent e) {
	}

	@Override
	public void mouseMoved(MouseEvent e) {// 마우스 이동
		x = e.getX();// 마우스의 x 좌표
		y = e.getY();// 마우스의 y 좌표
		repaint();// 그래픽 새로 그리기
	}

	public static void main(String[] args) {
		new KeyMouseEx();
	}
}
