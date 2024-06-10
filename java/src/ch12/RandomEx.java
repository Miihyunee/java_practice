package ch12;

import java.util.Random;

public class RandomEx {
	public static void main(String[] args) {
		Random r = new Random(10);// random seed
		System.out.println(r.nextDouble());
		System.out.println(r.nextInt());// 정수
		System.out.println(r.nextInt(100));// 0~99
		System.out.println(r.nextInt(101) + 100);// 100~200
		System.out.println(Math.random());// 0.0~1.0
		int num = (int) (Math.random() * 100);// 0~99
		System.out.println(num);
	}
}
