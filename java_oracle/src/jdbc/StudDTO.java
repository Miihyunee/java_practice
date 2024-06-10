package jdbc;

public class StudDTO {// STUD 테이블 데이터 전달 객체 생성
	private int studno;
	private String sname;
	private int grade;
	private int majorno;
	private String mname;

	public int getStudno() {
		return studno;
	}

	public void setStudno(int studno) {
		this.studno = studno;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public int getMajorno() {
		return majorno;
	}

	public void setMajorno(int majorno) {
		this.majorno = majorno;
	}

	public String getMname() {
		return mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	@Override
	public String toString() {
		return "StudDTO [studno=" + studno + ", sname=" + sname + ", grade=" + grade + ", majorno=" + majorno
				+ ", mname=" + mname + "]";
	}

	public StudDTO() {
	}

	public StudDTO(int studno, String sname, int grade, int majorno, String mname) {
		this.studno = studno;
		this.sname = sname;
		this.grade = grade;
		this.majorno = majorno;
		this.mname = mname;
	}

}
