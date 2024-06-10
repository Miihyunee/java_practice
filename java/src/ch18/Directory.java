package ch18;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Directory extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfDirectory;
	private JTextArea ta;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Directory frame = new Directory();
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
	public Directory() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		tfDirectory = new JTextField();
		tfDirectory.setBounds(59, 26, 134, 27);
		contentPane.add(tfDirectory);
		tfDirectory.setColumns(10);

		JButton button1 = new JButton("OK");
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String directory = tfDirectory.getText();// 입력값 가져오기
				File file = new File(directory);
				String[] list = file.list();// 디렉토리의 파일목록
				ta.setText("");// 내용 교체
				for (int i = 0; i < list.length; i++) {// 배열참조변수의 데이터 수만큼 반복
					File f = new File(directory, list[i]);// (디렉토리, 파일명)
					String str = f.isDirectory() ? "Directory" : "File";
					ta.append(str + ":" + list[i] + "\n");
				}
			}
		});
		button1.setBounds(223, 25, 134, 28);
		contentPane.add(button1);

		ta = new JTextArea();
		ta.setBounds(59, 71, 298, 157);
		contentPane.add(ta);
	}

}
