package ch07;

public class Point {
	private String name; // private 외부 클래스에서 사용 불가
	private int java;
	private int db;
	private int math;
	private int tot;
	private double avg;
	private String grade;

	// getter 값을 읽어오는 함수, setter 값을 저장하는 함수
	public String getName() {
		return name; // return 호출한 곳으로 값을 되돌려줌
	}

	// this. → 현재 클래스의 멤버를 가리키는 변수
	public void setName(String name) {
		this.name = name;
	}

	public int getJava() {
		return java;
	}

	public void setJava(int java) {
		this.java = java;
	}

	public int getDb() {
		return db;
	}

	public void setDb(int db) {
		this.db = db;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}

	public int getTot() {
		return tot;
	}

	public void setTot(int tot) {
		this.tot = tot;
	}

	public void cal() {
		tot = java + db + math;
		avg = tot / 3.0;
		if (avg >= 90) {
			grade = "A";
		} else if (avg >= 80) {
			grade = "B";
		} else if (avg >= 70) {
			grade = "C";
		} else if (avg >= 70) {
			grade = "D";
		} else {
			grade = "F";
		}
	}

	public void print() {
		System.out.println("Name:" + name);
		System.out.println("Java:" + java);
		System.out.println("DB:" + db);
		System.out.println("Math:" + math);
		System.out.println("Tot:" + tot);
		System.out.println("Avg:" + String.format("%.2f", avg));
		System.out.println("Grade:" + grade);
	}
}
