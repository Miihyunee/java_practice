package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class InsertMember {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521/xe";
		String id = "java";
		String pw = "java1234";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, id, pw);
			Scanner scan = new Scanner(System.in);
			System.out.print("아이디: ");
			String userid = scan.next();// hello world → next() : hello, naxtLine() : hello world
			System.out.print("비밀번호: ");
			String passwd = scan.next();
			System.out.print("이름: ");
			String name = scan.next();
			String sql = "INSERT INTO member(userid, passwd, name) VALUES(?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);// 1번쨰 물음표
			pstmt.setString(2, passwd);// 2번쨰 물음표
			pstmt.setString(3, name);// 3번쨰 물음표
			pstmt.executeUpdate();// 쿼리 실행
			System.out.println("레코드가 추가되었습니다.");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {// 항상 실행
			try {
				if (pstmt != null)
					pstmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
