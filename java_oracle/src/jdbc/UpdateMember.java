package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class UpdateMember {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521/xe";
		String id = "java";
		String pwd = "java1234";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, id, pwd);
			Scanner sc = new Scanner(System.in);
			System.out.println("아이디를 입력하세요:");
			String userid = sc.next();
			System.out.println("변경할 비밀번호를 입력하세요:");
			String passwd = sc.next();
			String sql = "UPDATE member SET passwd = ? WHERE userid = ? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, passwd);
			pstmt.setString(2, userid);
			int rows = pstmt.executeUpdate();
			if (rows > 0) {
				System.out.println("비밀번호가 수정되었습니다.");
			} else {
				System.out.println("아이디를 확인하세요");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			try {
				if (conn != null)
					conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
}
