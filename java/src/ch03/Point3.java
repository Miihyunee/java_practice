package ch03;

public class Point3 {
	public static void main(String[] args) {
		int java = 55;
		int db = 51;
		int math = 52;
		int tot = java + db + math;
		double avg = tot / 3.0;
		String grade = "";
		switch ((int) (avg / 10)) {
		case 10:
		case 9:
			grade = "A";
			break;
		case 8:
			grade = "B";
			break;
		case 7:
			grade = "C";
			break;
		case 6:
			grade = "D";
			break;
		default:
			grade = "F";
		}
		System.out.println("Java:" + java);
		System.out.println("DB:" + db);
		System.out.println("Math:" + math);
		System.out.println("Tot:" + tot);
		System.out.println("Avg:" + String.format("%5.1f", avg));
		System.out.println("Grade:" + tot);
	}
}