package ch15;

public class ATM extends Thread {// Thread 클래스를 상속받음, 멀티스레드 지원
	private int deposit = 100000;

	@Override
	public void run() {// 멀티스레드 실행
		for (int i = 1; i <= 10; i++) {
			withdraw(10000);
		}
	}

	// synchronized : 동기화, 순서대로 처리
	public synchronized void withdraw(int money) {
		String name = Thread.currentThread().getName();// 현재 실행 중인 스레드 이름
		if (deposit > 0) {// 잔고가 있으면
			deposit = deposit - money; // 인출
			System.out.println(name + "-잔액: " + deposit);
		} else {
			System.out.println(name + "-잔액이 없습니다.");
		}
	}
}
