package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Vector;

public class StudDAO {
	public Vector listStud(String mname) {// mname 값을 전달받는 클래스
		Vector items = new Vector();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DB.oraConn();
			String sql = "SELECT studno, sname, grade, s.majorno, mname FROM stud s, major m WHERE s.majorno = m.majorno AND mname LIKE ? ORDER BY grade";
			pstmt = conn.prepareStatement(sql);
			if (mname.equals("전체학과")) {
				mname = "%";
			}
			pstmt.setString(1, mname);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Vector row = new Vector();
				row.add(rs.getInt("studno"));
				row.add(rs.getString("sname"));
				row.add(rs.getInt("grade"));
				row.add(rs.getInt("majorno"));
				row.add(rs.getString("mname"));
				items.add(row);
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
			return items;
		}

//		public ArrayList<StudDTO> listStud(int studno){
//			
//		}
	}
}
