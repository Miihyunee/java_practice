package ch17;

import java.awt.Color;
import java.awt.EventQueue;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginEx extends JFrame {

	private static final long serialVersionUID = 1L;// 현재클래스의 버전코드(실행에 영향없음)
	// 필드변수(프로퍼티 변수)
	private JPanel contentPane;
	private JTextField userId;
	private JPasswordField pwd;
	private JLabel lblResult;
	Map<String, String> map;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginEx frame = new LoginEx();
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
	public LoginEx() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);// 프레임의 좌표와 사이즈 설정
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);// 절대좌표 레이아웃

		userId = new JTextField();
		userId.setBounds(146, 53, 170, 21);// userId의 좌표와 사이즈 설정
		contentPane.add(userId);
		userId.setColumns(10);

		pwd = new JPasswordField();
		pwd.setBounds(146, 98, 170, 21);
		contentPane.add(pwd);

		map = new HashMap<String, String>();
		map.put("kim", "1234");// key, value
		map.put("park", "2222");
		map.put("hong", "3333");

		JButton btnLogin = new JButton("로그인");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = userId.getText();// 텍스트필드에 입력한 값
				String pw = String.valueOf(pwd.getPassword());
				if (map.get(id) == null) {
					lblResult.setForeground(Color.red);
					lblResult.setText("ID is incorrect.");
				} else {
					if (map.get(id).equals(pw)) {// a.equals(b) → a와 b의 내용 비교
						lblResult.setForeground(Color.blue);
						lblResult.setText("Welcome " + id);
					} else {
						lblResult.setForeground(Color.red);
						lblResult.setText("ID or Password is incorrect. ");
					}
				}

			}
		});
		btnLogin.setBounds(186, 142, 97, 23);
		contentPane.add(btnLogin);

		lblResult = new JLabel("");
		lblResult.setBounds(151, 192, 194, 47);
		contentPane.add(lblResult);

		JLabel lblId = new JLabel("아이디");
		lblId.setBounds(44, 56, 57, 15);
		contentPane.add(lblId);

		JLabel lblPwd = new JLabel("비밀번호");
		lblPwd.setBounds(44, 101, 57, 15);
		contentPane.add(lblPwd);
	}
}
