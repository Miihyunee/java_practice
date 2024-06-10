package jdbc;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Member extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfUserid;
	private JTextField pass;
	private JTextField tfName;
	private JButton btnCheck;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Member frame = new Member();
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
	public Member() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		tfUserid = new JTextField();
		tfUserid.setBounds(167, 49, 150, 21);
		contentPane.add(tfUserid);
		tfUserid.setColumns(10);

		pass = new JTextField();
		pass.setBounds(167, 100, 150, 21);
		contentPane.add(pass);
		pass.setColumns(10);

		tfName = new JTextField();
		tfName.setBounds(167, 153, 150, 21);
		contentPane.add(tfName);
		tfName.setColumns(10);

		JButton btnSave = new JButton("확인");
		btnSave.setEnabled(false);
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection conn = null;
				PreparedStatement pstmt = null;

				try {
					FileInputStream fis = new FileInputStream("c:/work/db.prop");
					Properties prop = new Properties();
					prop.load(fis);
					String driver = prop.getProperty("driver");
					String url = prop.getProperty("url");
					String id = prop.getProperty("id");
					String password = prop.getProperty("password");

					Class.forName(driver);
					conn = DriverManager.getConnection(url, id, password);

					String sql = "INSERT INTO member VALUES(?, ?, ?)";
					pstmt = conn.prepareStatement(sql);

					String userid = tfUserid.getText();
					String pwd = pass.getText();
					String name = tfName.getText();
					pstmt.setString(1, userid);
					pstmt.setString(2, pwd);
					pstmt.setString(3, name);

//					String userid = tfUserid.getText();
//					if (userid.equals("")) {
//						JOptionPane.showMessageDialog(Member.this, "아이디를 입력하세요.");
//						tfUserid.requestFocus();
//						return;
//					}
//					String pwd = String.valueOf(pass.getPassword());
//					if (pwd.equals("")) {
//						JOptionPane.showMessageDialog(Member.this, "비밀번호를 입력하세요.");
//						pass.requestFocus();
//						return;
//					}
//					String name = tfName.getText();
//					if (name.equals("")) {
//						JOptionPane.showMessageDialog(Member.this, "이름을 입력하세요.");
//						tfName.requestFocus();
//						return;
//					}
					if (userid == null || userid.isEmpty()) {
						JOptionPane.showMessageDialog(Member.this, "아이디를 입력해주세요.");
						pass.requestFocus();
						return;
					} else if (pwd == null || pwd.isEmpty()) {
						JOptionPane.showMessageDialog(Member.this, "비밀번호를 입력해주세요.");
						pass.requestFocus();
						return;
					} else if (name == null || name.isEmpty()) {
						JOptionPane.showMessageDialog(Member.this, "이름을 입력해주세요.");
						pass.requestFocus();
						return;
					} else {
						pstmt.executeUpdate();
						JOptionPane.showMessageDialog(Member.this, "등록되었습니다.");
					}

				} catch (Exception e2) {
					e2.printStackTrace();
				} finally {
					try {
						if (pstmt != null) {
							pstmt.close();
						}
					} catch (Exception e2) {
						e2.printStackTrace();
					}
					try {
						if (conn != null) {
							conn.close();
						}
					} catch (Exception e2) {
						e2.printStackTrace();
					}
				}

			}
		});
		btnSave.setBounds(167, 207, 97, 23);
		contentPane.add(btnSave);

		JLabel lblNewLabel = new JLabel("아이디");
		lblNewLabel.setBounds(90, 52, 57, 15);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("비밀번호");
		lblNewLabel_1.setBounds(90, 103, 57, 15);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("이름");
		lblNewLabel_2.setBounds(90, 156, 57, 15);
		contentPane.add(lblNewLabel_2);

		btnCheck = new JButton("중복확인");
		btnCheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection conn = null;
				PreparedStatement pstmt = null;
				ResultSet rs = null;
				try {
					FileInputStream fis = new FileInputStream("c:/work/db.prop");
					Properties prop = new Properties();
					prop.load(fis);
					String driver = prop.getProperty("driver");
					String url = prop.getProperty("url");
					String id = prop.getProperty("id");
					String password = prop.getProperty("password");

					Class.forName(driver);
					conn = DriverManager.getConnection(url, id, password);

					String sql = "SELECT count(*) cnt FROM member WHERE userid = ?";
					pstmt = conn.prepareStatement(sql);
					String userId = tfUserid.getText();
					pstmt.setString(1, userId);
					rs = pstmt.executeQuery();

					if (rs.next()) {
						if (rs.getInt("cnt") > 0) {//0보다 크면 이미 등록된 아이디
							JOptionPane.showMessageDialog(Member.this, "이미 사용중인 아이디 입니다.");
							btnSave.setEnabled(false);
						} else {
							JOptionPane.showMessageDialog(Member.this, "사용가능한 아이디입니다.");
							btnSave.setEnabled(true);
						}
					}
				} catch (Exception e2) {
					e2.printStackTrace();
				} finally {
					try {
						if (rs != null) {
							rs.close();
						}
					} catch (Exception e3) {
						e3.printStackTrace();
					}
					try {
						if (pstmt != null) {
							pstmt.close();
						}
					} catch (Exception e3) {
						e3.printStackTrace();
					}
					try {
						if (conn != null) {
							conn.close();
						}
					} catch (Exception e3) {
						e3.printStackTrace();
					}
				}
			}
		});
		btnCheck.setBounds(325, 48, 97, 23);
		contentPane.add(btnCheck);
	}
}
