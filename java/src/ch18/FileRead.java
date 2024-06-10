package ch18;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class FileRead extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tf;
	private JTextArea ta;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FileRead frame = new FileRead();
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
	public FileRead() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		tf = new JTextField();
		tf.setBounds(51, 27, 151, 28);
		contentPane.add(tf);
		tf.setColumns(10);

		JButton button1 = new JButton("OK");
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String file = tf.getText();// 텍스트필드 입력 내용
				String str = "";
				BufferedReader reader = null;
				try {
					// FileInputStream(파일경로) → 파일의 내용을 읽는 클래스
					reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
					ta.setText("");// 텍스트 지우기
					while ((str = reader.readLine()) != null) {// 한 줄을 읽고 str에 대입 후 null인지 확인
						ta.append(str + "\n");// 기존 내용에 추가
					}
				} catch (Exception e2) {
					e2.printStackTrace();
				} finally {// 항상 실행
					try {
						if (reader != null)
							reader.close();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		button1.setBounds(214, 26, 151, 29);
		contentPane.add(button1);

		ta = new JTextArea();
		ta.setBounds(51, 73, 315, 166);
		contentPane.add(ta);
	}

}
