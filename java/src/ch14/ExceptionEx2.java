package ch14;

public class ExceptionEx2 {
	public static void main(String[] args) {
		int a = 10, b = 0, c;
		try {
			c = a / b;
			System.out.println(c);
		} catch (Exception e) {// 예외발생 시 처리하는 구문
			e.printStackTrace();//
		}
		System.out.println("end");
	}
}
