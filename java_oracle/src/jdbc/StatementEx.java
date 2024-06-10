package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class StatementEx {
	public static void main(String[] args) {
		// 자바에서 오라클 호출 → oracle.jdbc.driver(패키지명).OracleDriver(클래스명)
		String driver = "oracle.jdbc.driver.OracleDriver";
		// 연결 문자열 → jdbc:oracle:thin:@호스트:포트/데이터베이스명
		// 호스트 : DB서버, 포트 : 1521(기본), 데이터베이스 xe
		String url = "jdbc:oracle:thin:@localhost:1521/xe";
		String id = "java";
		String pwd = "java1234";
		Connection conn = null; // 접속
		Statement stmt = null; // SQL 명령어 생성 - 완성된 문장
		PreparedStatement pstmt = null; // SQL 명령어 생성 - 미완성
		try {// 시도
			Class.forName(driver);// 오라클 드라이버 로드
			// 오라클에 접속
			conn = DriverManager.getConnection(url, id, pwd);
			// SQL 실행하는 객체 생성
			stmt = conn.createStatement();
			// long - 8byte
			long start = System.currentTimeMillis();// 시스템의 현재시각, 타임스탬프
			for (int i = 1; i <= 10000; i++) {
				String str = "data" + i;
				String sql = "insert into test values(" + i + ",'" + str + "')";
				stmt.executeUpdate(sql); // SQL을 실행하라
			}
			long end = System.currentTimeMillis();
			System.out.println("작업수행시간: " + (end - start));

			start = System.currentTimeMillis();
			String sql = "insert into test values(?, ?)"; // ? - 파라미터 사용, 값이 확정되지 않음
			pstmt = conn.prepareStatement(sql);
			for (int i = 10001; i <= 20000; i++) {
				String str = "data" + i;
				// 정수값 전달 : 1번 물음표에
				pstmt.setInt(1, i);
				pstmt.setString(2, str);
				pstmt.executeUpdate();
			}
			end = System.currentTimeMillis();
			System.out.println("작업수행시간: " + (end - start));
		} catch (Exception e) {
			
			// 예외발생 시
			e.printStackTrace();
		} finally {// 항상 실행
			// close 하지 않아도 에러는 없지만 메모리 절약을 위함
			try {
				if (stmt != null)
					stmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
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
