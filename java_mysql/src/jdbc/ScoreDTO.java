package jdbc;

public class ScoreDTO {
	// 중요한 데이터 보호하기 위해 private 사용
	private String student_no;
	private String name;
	private int kor, eng, mat, tot;
	private double avg;

	// getter : 변수의 값 읽기
	public String getStudent_no() {
		return student_no;
	}

	// setter : 변수에 값 저장하기
	public void setStudent_no(String student_no) {
		// this.변수 → 프로퍼티 변수
		this.student_no = student_no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getMat() {
		return mat;
	}

	public void setMat(int mat) {
		this.mat = mat;
	}

	public int getTot() {
		return tot;
	}

	public void setTot(int tot) {
		this.tot = tot;
	}

	public double getAvg() {
		return avg;
	}

	public void setAvg(double avg) {
		this.avg = avg;
	}

	// @키워드 → 어노테이션
	@Override
	public String toString() {
		return "ScoreDTO [student_no=" + student_no + ", name=" + name + ", kor=" + kor + ", eng=" + eng + ", mat="
				+ mat + ", tot=" + tot + ", avg=" + avg + "]";
	}

	// 생성자 : 리턴타입 없음, 클래스 이름과 동일, 기본 초기작업
	public ScoreDTO() {// 기본 생성자
	}

	// this.변수 : 현재클래스의 멤버, super.변수 : 상위클래스의 멤버
	// this() : 현재클래스의 생성자, super() : 상위클래스의 생성자
	public ScoreDTO(String student_no, String name, int kor, int eng, int mat) {
		this.student_no = student_no;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
		tot = kor + eng + mat;
		avg = tot / 3.0;
	}

}
