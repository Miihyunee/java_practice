package ch18;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class FileEx extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfFileName;
	private JTextArea ta;// 필드변수로 전환(모든 곳에서 사용할 수 있는 변수)

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FileEx frame = new FileEx();
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
	public FileEx() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 367, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		tfFileName = new JTextField();
		tfFileName.setBounds(44, 36, 130, 21);
		contentPane.add(tfFileName);
		tfFileName.setColumns(10);

		JButton button1 = new JButton("OK");
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				File file = new File(tfFileName.getText());
				if (!file.exists()) {
					try {
						file.createNewFile();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
				String str = "Name: " + file.getName() + "\n" + "Length: " + file.length() + "\n" + "Parent: " + file.getParent();
				ta.setText(str);
			}
		});
		button1.setBounds(186, 35, 122, 23);
		contentPane.add(button1);

		ta = new JTextArea();
		ta.setBounds(44, 80, 264, 151);
		contentPane.add(ta);
	}
}
