package quiz;

/* 매개변수 없는 버전 */
public class Gugu {
	private int dan;

	public int getDan() {
		return dan;
	}

	public void setDan(int dan) {
		this.dan = dan;
	}

	public void print() {
		for (int i = 1; i <= 9; i++) {
			System.out.println(dan + " x " + i + " = " + dan * i);
		}
	}

	public static void main(String[] args) {
		Gugu gu = new Gugu();
		gu.setDan(5);
		gu.print();
	}
}

/* 매개변수 있는 버전 */
//public class Gugu {
//	private int dan;
//
//	public Gugu(int dan) {
//		this.dan = dan;
//	}
//
//	public void setDan(int dan) {
//		this.dan = dan;
//	}
//
//	public int getDan() {
//		return dan;
//	}
//
//	public void print() {
//		for (int i = 1; i <= 9; i++) {
//			System.out.println(dan + "x" + i + "=" + dan * i);
//		}
//	}
//
//	public static void main(String[] args) {
//		Gugu g = new Gugu(7);
//		g.print();
//	}
//}

/* 두가지 버전 혼합 */
//public class Gugu {
//	private int dan;
//
//	public Gugu() {
//	}
//
//	public Gugu(int dan) {
//		this.dan = dan;
//	}
//
//	public void setDan(int dan) {
//		this.dan = dan;
//	}
//
//	public int getDan() {
//		return dan;
//	}
//
//	public void print() {
//		for (int i = 1; i <= 9; i++) {
//			System.out.println(dan + "x" + i + "=" + dan * i);
//		}
//	}
//
//	public static void main(String[] args) {
//		Gugu g = new Gugu(7);
//		g.print();
//
//		Gugu g2 = new Gugu();
//		g2.setDan(8);
//		g2.print();
//	}
//}
