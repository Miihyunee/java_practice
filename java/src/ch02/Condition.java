package ch02;

public class Condition {
	public static void main(String[] args) {
		int num = -5;
		System.out.println(num > 0 ? num : -num); // 조건 ? true일 때 : false일 때
		if (num > 0) { //조건 true
			System.out.println(num);
		} else { //조건 flase
			System.out.println(-num);
		}
		System.out.println(Math.abs(num));
		//Math: 수학계산 지원하는 클래스
		//abs: 절대값을 구해주는 함수
	}
}