package ch12;

public class ObjectCast {
	public static void main(String[] args) {
		int a = 10;
		Object obj = 20;
		a = (int) obj;
		System.out.println(a);
		Object[] obj2 = { 100, 100.5, true, "hello", 'A' };
		for (Object o : obj2) {
			System.out.println(o);
		}
//		for (int i = 0; i < obj2.length; i++) {
//			System.out.println(obj2[i]);
//		}
	}
}
