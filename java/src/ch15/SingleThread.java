package ch15;

public class SingleThread {
	void print() {
		//Thread.currentThread().getName() : 스레드.현재실행중인스레드.이름 → main
		System.out.println(Thread.currentThread().getName());
		for (int i = 1; i <= 5; i++) {
			System.out.println(i);
		}
	}

	public static void main(String[] args) {
		SingleThread t = new SingleThread();
		t.print();
		t.print();
	}
}
