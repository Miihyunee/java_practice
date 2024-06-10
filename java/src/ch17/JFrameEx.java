package ch17;

import javax.swing.JFrame;

public class JFrameEx {
	public static void main(String[] args) {
		JFrame f = new JFrame();
		f.setSize(500, 500);// 화면사이즈
		f.setVisible(true);// 화면에 표시
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// 닫기동작설정
	}
}
