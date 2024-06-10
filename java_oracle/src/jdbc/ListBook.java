package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class ListBook {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521/xe";
		String id = "java";
		String pwd = "java1234";
		// DB 접속
		Connection conn = null;
		// sql 실행
		PreparedStatement pstmt = null;
		// 결과셋(값 가져오기)
		ResultSet rs = null;
		try {
			Class.forName(driver);// 드라이버 로딩

			conn = DriverManager.getConnection(url, id, pwd);// 오라클 접속
			Scanner sc = new Scanner(System.in);
			System.out.println("도서명을 입력하세요: ");
			String book_title = sc.nextLine();// 사용자 입력값 한 라인 가져오기
			String sql = "SELECT * FROM books WHERE title LIKE ? ORDER BY title";
			pstmt = conn.prepareStatement(sql);
			// 1번째 물음표에 book_title 값
			pstmt.setString(1, "%" + book_title + "%");
			rs = pstmt.executeQuery();// 실행
			System.out.println("코드\t도서명\t\t저자\t연도\t단가");
			while (rs.next()) {// rs.next() → 포인터 다음으로 이동(있으면 true, 없으면 false)
				int bool_code = rs.getInt("book_code");
				String title = rs.getString("title");
				String author = rs.getString("author");
				String year = rs.getString("year");
				int price = rs.getInt("price");
				System.out.println(bool_code + "\t" + title + "\t\t" + author + "\t" + year + "\t" + price);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {// 항상 실행
			// close는 역순으로 rs → pstmt → conn
			try {
				if (rs != null)
					rs.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
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
