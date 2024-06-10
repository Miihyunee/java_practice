package ch01;

import java.util.Scanner;

public class Input {
	public static void main(String[] args) {//Scanner 데이터 입력하는 방법 중 한가지
		Scanner sc = new Scanner(System.in);
		//new(새로 생성명령어) + 자료형(키입력장치)
		
		System.out.print("이름을 입력하세요:");
		String name = sc.next(); //키보드 입력값을 변수에 대입
		//String name = sc.nextLine(); //개행변수 입력 가능
		//데이터 → 변수
		//기능 → method, function
		
		System.out.println("이름: " + name);
		System.out.print("나이를 입력하세요:");
		//print : 츨력, 줄바꿈x
		//println : 출력 + 줄바꿈
		
		int age = sc.nextInt(); //키보드 정수 입력값
		System.out.println("나이:" + age);
	}
}