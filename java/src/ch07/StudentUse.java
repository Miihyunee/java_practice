package ch07;

public class StudentUse {
	public static void main(String[] args) {
		Student s1 = new Student();
		s1.input("Kim", 4.3, 5000000);
		System.out.println(s1);
		// System.out.println(s1.toString());
	}
}
