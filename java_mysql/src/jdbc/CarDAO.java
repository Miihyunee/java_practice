package jdbc;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class CarDAO {
	// DB 접속
	public Connection dbConn() {
		Connection conn = null;// DB 접속
		try {// DB작업은 예외처리 필수
				// 파일에 있는 정보 읽어오기
			FileInputStream fis = new FileInputStream("c:/work/db.prop");
			// 파일 내용을 key=value 한세트로 읽기
			Properties prop = new Properties();
			prop.load(fis);
			String url = prop.getProperty("url");
			String id = prop.getProperty("id");
			String password = prop.getProperty("password");
			// url, id, password 확인하여 일치하면 접속
			conn = DriverManager.getConnection(url, id, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

	// 목록 보기
	public List<CarDTO> list_car() {
		List<CarDTO> items = new ArrayList<>();
		Connection conn = null;// DB 접속
		PreparedStatement pstmt = null;// SQL 실행
		ResultSet rs = null;// 결과값 가져오기
		try {
			conn = dbConn();// DB접속
			String sql = "SELECT * FROM car";// 완성된 명령어
			pstmt = conn.prepareStatement(sql);// SQL 실행준비, 실행객체 생성
			rs = pstmt.executeQuery();// SQL 실행
			while (rs.next()) {// 한개의 레코드 읽어오기
				String car_no = rs.getString("car_no");// 필드값 읽어오기
				String company = rs.getString("company");
				String type = rs.getString("type");
				int year = rs.getInt("year");
				int efficiency = rs.getInt("efficiency");
				CarDTO dto = new CarDTO(car_no, company, type, year, efficiency);
				// 전체자료.추가(레코드1개)
				items.add(dto);
			} // 반복문종료
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
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
		// 전체자료 return
		return items;
	}

	// 데이터 추가
	public void insert_car(CarDTO dto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = dbConn();
			// 미완성 명령어
			String sql = "INSERT INTO car(car_no, company, type, year, efficiency) VALUES(?, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			// 물음표의 값 채우기
			pstmt.setString(1, dto.getCar_no());
			pstmt.setString(2, dto.getCompany());
			pstmt.setString(3, dto.getType());
			pstmt.setInt(4, dto.getYear());
			pstmt.setInt(5, dto.getEfficiency());
			// 명령어 실행
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
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

	// 데이터 삭제
	public int delete_car(String car_no) {
		int result = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = dbConn();
			String sql = "DELETE FROM car WHERE car_no = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, car_no);
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
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
		return result;
	}
}
