package jdbc;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

public class ListScore {
	public static void main(String[] args) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Connection conn = null;
		try {
			FileInputStream fis = new FileInputStream("c:/work/db.prop");
			Properties prop = new Properties();
			prop.load(fis);
			String url = prop.getProperty("url");
			String id = prop.getProperty("id");
			String password = prop.getProperty("password");
			conn = DriverManager.getConnection(url, id, password);

			String sql = "SELECT NAME, kor, eng, mat FROM score where name = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "kim");
			rs = pstmt.executeQuery();
			System.out.println("이름\t국어\t영어\t수학\t총점\t평균\t등급");
			while (rs.next()) {
				String name = rs.getString("name");
				int kor = rs.getInt("kor");
				int eng = rs.getInt("eng");
				int mat = rs.getInt("mat");
				int total = kor + eng + mat;
				Double avg = total / 3.0;
				String grade = "";
				if (avg >= 90) {
					grade = "A";
				} else if (avg >= 80) {
					grade = "B";
				} else if (avg >= 70) {
					grade = "C";
				} else if (avg >= 60) {
					grade = "D";
				} else {
					grade = "F";
				}
//				int total = rs.getInt("총점");
//				Double avg = rs.getDouble("평균");
//				String grade = rs.getString("등급");
				System.out.println(name + "\t" + kor + "\t" + eng + "\t" + mat + "\t" + total + "\t"
						+ String.format("%.2f", avg) + "\t" + grade);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
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