package jdbc;

public class MajorDTO {// 데이터 전달 객체
	// 사용할 데이터의 프로퍼티 변수 선언
	private int majorno;
	private String mname;

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
		return "MajorDTO [majorno=" + majorno + ", mname=" + mname + "]";
	}

	public MajorDTO() {
	}

	public MajorDTO(int majorno, String mname) {
		this.majorno = majorno;
		this.mname = mname;
	}

}
