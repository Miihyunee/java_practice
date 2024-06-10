package ch07;

public class PointUse {
	public static void main(String[] args) {
		Point p1 = new Point();
		p1.setName("Kim");
		p1.setJava(90);
		p1.setDb(80);
		p1.setMath(89);
		p1.cal();
		p1.print();
	}
}
