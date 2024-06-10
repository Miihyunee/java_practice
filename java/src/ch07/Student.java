package ch07;

public class Student {
	private String name;
	private double point;
	private int tuition;
	private int scholarship;

	public void input(String name, double point, int tutuion) {
		this.name = name;
		this.point = point;
		this.tuition = tutuion;
		if (point >= 4.3) {
			scholarship = tutuion;
		} else if (point >= 4.0) {
			scholarship = 2500000;
		} else if (point >= 3.5) {
			scholarship = 1000000;
		}
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String str = "Name:" + name + "\n";
		str += "Point:" + point + "\n";
		str += "Tuition:" + tuition + "\n";
		str += "Scholarship:" + scholarship + "\n";
		return str;
		// return super.toString();
	}
}
