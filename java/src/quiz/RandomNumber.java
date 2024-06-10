package quiz;

import java.util.Random;
import java.util.Scanner;

public class RandomNumber {
	public static void main(String[] args) {
		Random rand = new Random();
		int num = rand.nextInt(100) + 1;
		System.out.println("컴퓨터의 숫자 : " + num);
		Scanner sc = new Scanner(System.in);
		int count = 0;
		while(true) {
			System.out.print("1~100 사이의 값을 입력하세요:");
			int key = sc.nextInt();
			count++;
			if(num > key) {
				System.out.println("더 큰 수를 입력하세요");
			} else if(num < key){
				System.out.println("더 작은 수를 입력하세요.");
			} else {
				System.out.println("맞았습니다.");
				System.out.println(count + "회만에 맞추셨네요.");
				break;
			}
		}
	}
}

/* 강사님 답 */
//public class RandomNumber {
//	   public static void main(String[] args) {
//	      Random r = new Random(); 
//	      int com = r.nextInt(100) + 1; 
//	      System.out.println("컴퓨터의 숫자:"+com);
//	      Scanner sc = new Scanner(System.in);
//	      int user;
//	      int count = 0; //시도횟수
//	      while (true) {//무한반복
//	         System.out.print("숫자를 입력하세요:");
//	         user = sc.nextInt(); //키보드로 입력
//	         count++;
//	         if (com == user) {
//	            System.out.println("맞았습니다.");
//	            System.out.println(count + "회만에 맞히셨네요^^");
//	            break; //반복문 종료
//	         } else if (com > user) {
//	            System.out.println("더 큰 수를 입력하세요.");
//	         } else if (com < user) {
//	            System.out.println("더 작은 수를 입력하세요.");
//	         }
//	      }
//	   }
//	}