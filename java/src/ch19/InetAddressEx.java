package ch19;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressEx {
	public static void main(String[] args) {
		try {// 시도
			InetAddress address = InetAddress.getByName("naver.com");
			System.out.println(address);
			InetAddress[] addresses = InetAddress.getAllByName("naver.com");
			for (InetAddress i : addresses) {
				System.out.println(i);
			}
		} catch (UnknownHostException e) {// 예외발생 시
			// Stack : 밑에서 위로 쌓이는 메모리 구조
			e.printStackTrace(); // 에러가 발생했을 때 스택 추적정보를 출력
		}
	}
}
