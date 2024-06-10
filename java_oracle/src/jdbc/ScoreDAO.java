package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

public class ScoreDAO {// DAO (Data Access Object) : 데이터 접근 객체
	public int deleteScore(String student_no) {
		int result = 0;// 삭제된 행수
		Connection conn = null;// DB 접속
		PreparedStatement pstmt = null;// sql 실행
		try {
			conn = DB.oraConn();// DB 접속
			String sql = "DELETE FROM score WHERE student_no = ?";
			pstmt = conn.prepareStatement(sql);// 실행 준비
			pstmt.setString(1, student_no);// 1번물음표에 전달된 학번값 셋팅
			result = pstmt.executeUpdate();// sql 실행
		} catch (Exception e) {
			e.printStackTrace();
		} finally {// 항상 실행
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
		return result;// 삭제된 레코드 수 전달
	}

	public int updateScore(ScoreDTO dto) {
		int result = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DB.oraConn();
			String sql = "UPDATE score SET name = ?, kor = ?, eng = ?, mat = ? WHERE student_no = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getName());
			pstmt.setInt(2, dto.getKor());
			pstmt.setInt(3, dto.getEng());
			pstmt.setInt(4, dto.getMat());
			pstmt.setString(5, dto.getStudent_no());
			result = pstmt.executeUpdate();
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
		return result;
	}

	public int insertScore(ScoreDTO dto) {// DTO 안에 변수들 담아놓음
		int result = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DB.oraConn();// DB 접속
			// 미완성 코드 → ? : 변수 채워넣어야 함
			String sql = "INSERT INTO score VALUES(?, ?, ?, ?, ?)";
			// 명령어 준비
			pstmt = conn.prepareStatement(sql);
			// 변수 5개 채우기
			// set자료형(번호, 값);
			pstmt.setString(1, dto.getStudent_no());
			pstmt.setString(2, dto.getName());
			pstmt.setInt(3, dto.getKor());
			pstmt.setInt(4, dto.getEng());
			pstmt.setInt(5, dto.getMat());
			// sql 실행, 테이블에 레코드 추가
			result = pstmt.executeUpdate();
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
		// 몇 행이 추가되었는지 전달
		return result;
	}

	// 접근권한 리턴타입 함수명()
	public Vector listScore() {
		Vector items = new Vector();
		Connection conn = null;// DB 접속
		PreparedStatement pstmt = null;// sql 생성 및 실행
		ResultSet rs = null;// 값 가져오기
		try {
			conn = DB.oraConn();
			String sql = "SELECT student_no, name, kor, eng, mat, (kor + eng + mat) tot, ROUND((kor+eng+mat)/3.0,1) avg FROM score";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();// 쿼리 실행
			while (rs.next()) {
				Vector row = new Vector();
				// 참조변수.get자료형(필드명) 으로 값 꺼내오기
				String student_no = rs.getString("student_no");
				String name = rs.getString("name");
				int kor = rs.getInt("kor");
				int eng = rs.getInt("eng");
				int mat = rs.getInt("mat");
				int tot = rs.getInt("tot");
				double avg = rs.getDouble("avg");
				row.add(student_no);
				row.add(name);
				row.add(kor);
				row.add(eng);
				row.add(mat);
				row.add(tot);
				row.add(avg);
				items.add(row);// 전체벡터.추가(행벡터)
			}
		} catch (Exception e) {// 예외처리
			e.printStackTrace();
		} finally {// 항상 실행(정리 작업)
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
		return items;// ScoreMain 으로 넘겨주기
	}
}
