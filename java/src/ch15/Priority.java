package ch15;

public class Priority extends Thread {//Thread 상속 받음
	public static void main(String[] args) {
		Priority p1 = new Priority();// 인스턴스 생성
		Priority p2 = new Priority();
		p1.setName("Thread1");
		p2.setName("Thread2");
		System.out.println("p1의 우선순위(변경전):" + p1.getPriority());
		System.out.println("p2의 우선순위(변경전):" + p2.getPriority());
		p1.setPriority(Thread.MIN_PRIORITY);
		p2.setPriority(Thread.MAX_PRIORITY);
		System.out.println("p1의 우선순위(변경후):" + p1.getPriority());
		System.out.println("p2의 우선순위(변경후):" + p2.getPriority());
		p1.start();
		p2.start();
	}

	@Override
	public void run() {
		for (int i = 1; i <= 10; i++) {
			System.out.println(Thread.currentThread().getName() + "==> " + i);
		}
	}
}
