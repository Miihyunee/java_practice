package ch17;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MessageEx extends JFrame {// JFrame 상속받음

	private static final long serialVersionUID = 1L;// 클래스의 버전 관리(실행에 영향없음)
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MessageEx frame = new MessageEx();// 인스턴스 생성, 생성자 호출
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MessageEx() {// 생성자
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();// 여러개를 넣어서 쓰고 싶을 때
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);

		JButton button1 = new JButton("Message");
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(MessageEx.this, "Message");
			}
		});
		contentPane.add(button1);

		JButton button2 = new JButton("Confirm");
		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Dialog : 대화상자
				// showConfirmDialog(화면, 메시지, 타이틀, 옵션);
				int result = JOptionPane.showConfirmDialog(MessageEx.this, "Do you want to exit?", "EXIT",
						JOptionPane.YES_OPTION);
				if (result == JOptionPane.YES_OPTION) {// YES 클릭했을 때
					System.exit(0);
				}
			}
		});
		contentPane.add(button2);

		JButton button3 = new JButton("Input");
		button3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// showInputDialog(화면, 메시지);
				String name = JOptionPane.showInputDialog(MessageEx.this, "Input name");
				// 사용자가 입력한 값이 name 으로 저장됨
				JOptionPane.showMessageDialog(MessageEx.this, "Welcome " + name);
			}
		});
		contentPane.add(button3);

		JButton button4 = new JButton("Option");
		button4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 사용자 정의 버튼
				// 배열을 참조하는 자료형 { "YES" "NO" "CANCLE" } 을 변경함
				String[] str = { "ADD", "UPDATE", "DELETE" };
				// showOptionDialog(화면, 안내문, 타이틀, 옵션, 아이콘의 종류, 내가만든 아이콘, 대체할 텍스트, '' );
				JOptionPane.showOptionDialog(MessageEx.this, "SELECT MENU", "OPTION", JOptionPane.YES_NO_CANCEL_OPTION,
						JOptionPane.INFORMATION_MESSAGE, null, str, str[0]);
			}
		});
		contentPane.add(button4);
	}

}
