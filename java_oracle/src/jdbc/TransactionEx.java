package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class TransactionEx {
	public static void main(String[] args) {
		Connection conn = null;// DB 접속
		PreparedStatement pstmt = null;// sql 실행
		boolean sucess = false;// 참, 거짓
		try {// DB 작업은 예외처리 필수
			conn = DB.oraConn();// DB 접속
			conn.setAutoCommit(false);// 자동커밋 false → 수동커밋 상태로 전환

			String sql = "INSERT INTO emp_copy VALUES(?, ?, ?)";
			pstmt = conn.prepareStatement(sql);// 미완성 명령어 실행 객체 생성
			long start = System.currentTimeMillis();// 현재시간을 ms(1000ms = 1초) 로 계산
			for (int i = 1; i <= 99; i++) {
				pstmt.setInt(1, i * 100);
				pstmt.setString(2, "kim" + i);
				pstmt.setInt(3, 4500);
				pstmt.addBatch();// 배치 - 일괄처리 작업으로 모아둠
				// pstmt.executeUpdate();//for문 안에 있으면 반복횟수만큼 처리되어짐(ex. 100개를 100번 처리)
			}
			pstmt.executeBatch();// 배치 실행(ex. 100개를 1번에 처리)
			sucess = true;// 작업 성공이면 true 상태로 변경
			long end = System.currentTimeMillis();
			System.out.println("작업수행시간: " + (end - start));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (sucess) {//sucess = true 일 때
					System.out.println("커밋되었습니다.");
					conn.commit();
				} else {
					System.out.println("롤백되었습니다.");
					// 작업 실패 시 작업 내용 취소시킴
					conn.rollback();
				}
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
