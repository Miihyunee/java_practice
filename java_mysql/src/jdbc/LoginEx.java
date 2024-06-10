package jdbc;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class LoginEx extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField userid;
	private JPasswordField pwd;
	private JLabel lblResult;

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
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		userid = new JTextField();
		userid.setBounds(157, 42, 116, 21);
		contentPane.add(userid);
		userid.setColumns(10);

		pwd = new JPasswordField();
		pwd.setBounds(157, 93, 116, 21);
		contentPane.add(pwd);

		JButton btnLogin = new JButton("로그인");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {// 클릭할 때 함수 호출
				// 텍스트필드.getText() : 입력한 값 가져오기
				String strUserid = userid.getText();
				// 비밀번호는 getText()로 가져올 수 없음
				String strPwd = String.valueOf(pwd.getPassword());
				Connection conn = null;
				PreparedStatement pstmt = null;
				ResultSet rs = null;
				try {// DB 작업은 예외처리 필수
						// FileInputStream : 파일의 내용을 1byte씩 읽어옴
					FileInputStream fis = new FileInputStream("c:/work/db.prop");
					Properties prop = new Properties();
					prop.load(fis);
					String url = prop.getProperty("url");
					String id = prop.getProperty("id");
					String password = prop.getProperty("password");
					conn = DriverManager.getConnection(url, id, password);
					String sql = "SELECT * FROM member WHERE userid = ? AND pwd = ?";
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, strUserid);
					pstmt.setString(2, strPwd);
					rs = pstmt.executeQuery();// 완성된 명령문 실행
					if (rs.next()) {// 레코드 한개 읽어오기(내용 있으면 true)
						lblResult.setText(rs.getString("name") + "님 환영합니다.");
					} else {
						lblResult.setText("아이디 또는 비밀번호가 일치하지 않습니다.");
					}
				} catch (Exception e2) {
					e2.printStackTrace();
				} finally {
					try {
						if (rs != null)
							rs.close();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
					try {
						if (pstmt != null)
							pstmt.close();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
					try {
						if (conn != null)
							conn.close();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		btnLogin.setBounds(304, 92, 97, 23);
		contentPane.add(btnLogin);

		lblResult = new JLabel("");
		lblResult.setBounds(48, 132, 353, 97);
		contentPane.add(lblResult);

		JLabel lblNewLabel = new JLabel("아이디");
		lblNewLabel.setBounds(56, 45, 57, 15);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("비밀번호");
		lblNewLabel_1.setBounds(56, 96, 57, 15);
		contentPane.add(lblNewLabel_1);

	}
}
