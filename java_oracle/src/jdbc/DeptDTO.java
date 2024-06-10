package jdbc;

public class DeptDTO {// DTO : 테이블의 레코드를 저장하는 저장소
	private int deptno;
	private String dname;

	public int getDeptno() {
		return deptno;
	}

	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	@Override
	public String toString() {
		return "DeptDTO [deptno=" + deptno + ", dname=" + dname + "]";
	}

	public DeptDTO() {// 기본 생성자
	}

	public DeptDTO(int deptno, String dname) {
		this.deptno = deptno;
		this.dname = dname;
	}

}
