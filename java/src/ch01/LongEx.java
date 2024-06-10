package ch01;

public class LongEx {
	public static void main(String[] args) {
		int a = 214783647;
		System.out.println(a);
		long b = 214783648l;
		System.out.println(b);
		
		System.out.println(Integer.MIN_VALUE); //int의 최소값
		System.out.println(Integer.MAX_VALUE); //int의 최대값
		System.out.println(Integer.SIZE); //비트수
		
		System.out.println(Long.MIN_VALUE); 
		System.out.println(Long.MAX_VALUE);
		System.out.println(Long.SIZE);
	}
}