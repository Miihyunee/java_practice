package ch10;

class T {
	private int num = 10;

	public final void print() { // final method는 오버라이드 금지
		System.out.println(num);
	}
}

public class FinalMethod extends T {
	int num = 100;

//	@Override
//	public void print() {
//		System.out.println(num);
//	}

	public static void main(String[] args) {
		FinalMethod f = new FinalMethod();
		f.print();
	}

}
