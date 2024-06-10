package ch15;

public class Sync {
	public static void main(String[] args) {
		ATM atm = new ATM();// 인스턴스 생성
		Thread mom = new Thread(atm, "mom");// (스레드객체, 스레드이름)
		Thread son = new Thread(atm, "son");
		mom.start();// run()함수 실행
		son.start();
	}
}
