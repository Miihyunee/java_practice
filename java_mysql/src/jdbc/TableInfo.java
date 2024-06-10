package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class TableInfo {
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;// 실행 결과 레코드 1개씩 읽기
		ResultSetMetaData meta = null;// metaData : 부가설명, ResultSet 의 추가적인 데이터
		try {
			conn = DB.dbConn();// DB 접속
			String sql = "SELECT * FROM scores";
			// 완성된 SQL
			pstmt = conn.prepareStatement(sql);
			// SQL 실행
			rs = pstmt.executeQuery();
			meta = rs.getMetaData();// rs의 메타데이터 가져오기
			int cols = meta.getColumnCount();// 컬럼 개수 가져오기
			System.out.println("필드명\t\t자료형\tNull여부");
			for (int i = 1; i <= cols; i++) {
				String colName = meta.getColumnName(i);
				String colType = meta.getColumnTypeName(i);
				int isNull = meta.isNullable(i);
				System.out.println(colName + "\t\t" + colType + "\t" + isNull);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {// 항상 실행(주로 메모리 정리작업)
			try {
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (pstmt != null)
					pstmt.close();
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
