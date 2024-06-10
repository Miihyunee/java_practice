package ch12;

public class DoubleEX {
	public static void main(String[] args) {
		Double num1 = 11.5;
		double num2 = 3.5;
		double num3 = num1 / num2;
		System.out.println(num3);
		String str = "11.5";
		System.out.println(str + 200);
		System.out.println(Double.parseDouble(str) + 200);
	}
}
