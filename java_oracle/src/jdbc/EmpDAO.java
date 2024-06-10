package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Vector;

public class EmpDAO {
	public Vector listEmp(String dname) {
		Vector items = new Vector();// 벡터 선언
		Connection conn = null;// DB 접속
		PreparedStatement pstmt = null;// sql 실행
		ResultSet rs = null;// 결과값 가져오기
		try {
			conn = DB.oraConn();// DB 접속(접속정보 리턴받음:DB.java)
			String sql = "SELECT empno, ename, job, hiredate, sal, dname FROM emp e, dept d WHERE e.deptno = d.deptno AND dname LIKE ?";
			pstmt = conn.prepareStatement(sql);// sql 실행 준비
			if (dname.equals("전체부서")) {// 부서이름='전체부서'일 때
				dname = "%";// 전체 출력
			}
			pstmt.setString(1, dname);// 1번째 물음표에 값 넣기
			rs = pstmt.executeQuery();// 쿼리 실행
			while (rs.next()) {// 다음 내용이 있을 때까지(true) 무한 반복
				Vector row = new Vector();// 1개의 레코드 저장 벡터
				// 필드명 또는 필드번호로 가져올 수 있음
				// row.add(rs.getInt(1));
				row.add(rs.getInt("empno"));
				row.add(rs.getString("ename"));
				row.add(rs.getString("job"));
				row.add(rs.getDate("hiredate"));
				row.add(rs.getInt("sal"));
				row.add(rs.getString("dname"));
				items.add(row);// 전체벡터.추가(행벡터)
			}
		} catch (Exception e) {// 예외처리
			e.printStackTrace();
		} finally {// 항상 실행
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
		return items;// 전체벡터 전달(ListEmp.java)
	}

	public ArrayList<EmpDTO> listEmp(int deptno) {
		ArrayList<EmpDTO> items = new ArrayList<EmpDTO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DB.oraConn();
			String sql = "SELECT empno, ename, job, hiredate, sal, dname FROM emp e, dept d WHERE e.deptno = d.deptno AND e.deptno = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, deptno);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				EmpDTO dto = new EmpDTO();
				dto.setEmpno(rs.getInt("empno"));
				dto.setEname(rs.getString("ename"));
				dto.setJob(rs.getString("job"));
				dto.setHiredate(rs.getDate("hiredate"));
				dto.setSal(rs.getInt("sal"));
				dto.setDname(rs.getString("dname"));
				items.add(dto);
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
		return items;
	}
}
