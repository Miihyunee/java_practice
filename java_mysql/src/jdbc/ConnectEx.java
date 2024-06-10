package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectEx {
	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/web?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=Asia/Seoul";
		String id = "user";
		String password = "1234";
		Connection conn = null;// DB 접속
		Statement stmt = null;// SQL 실행(완성된 SQL)
		ResultSet rs = null;// 실행결과
		try {// DB 작업은 예외처리 필수
				// MySQL 드라이버를 불러옴
			Class.forName("com.mysql.cj.jdbc.Driver");
			// MySQL 접속
			conn = DriverManager.getConnection(url, id, password);
			String sql = "SELECT * FROM books";
			stmt = conn.createStatement();// SQL을 실행하는 객체 생성
			rs = stmt.executeQuery(sql);// 완성된 SQL 실행
			while (rs.next()) {// 다음 행 있으면(true) 반복
				int book_code = rs.getInt("book_code");
				String title = rs.getString("title");
				String author = rs.getString("author");
				String year = rs.getString("year");
				int price = rs.getInt("price");
				System.out.println(book_code + "\t" + title + "\t" + author + "\t" + year + "\t" + price);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {// 항상 실행(주로 Resource 정리 작업)
			try {
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}
}
