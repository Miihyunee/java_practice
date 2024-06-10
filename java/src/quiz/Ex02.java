package quiz;

import java.util.Scanner;

public class Ex02 {
	public static void main(String[] args) {
		// 변수 선언 : 자료형 변수명;
		// int a = 10; 값이 저장되는 변수
		// String a = "hello"; 'h' 'e' 'l' 'l' 'o' adress가 저장되는 변수

		Scanner sc = new Scanner(System.in);
		// new Scanner → Scanner 클래스의 인스턴스, 오브젝트 생성
		System.out.print("점수를 입력하세요:");
		int point = sc.nextInt(); // 참조변수.함수(), nextInt() 키입력값을 정수로
		// 조건문 활용
		if (point >= 70) {
			System.out.println("합격입니다.");
		} else {
			System.out.println("불합격입니다.");
		}
		// 삼항연산자 활용
		System.out.println(point >= 70 ? "합격" : "불합격");
	}
}