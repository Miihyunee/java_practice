package ch15;

public class MyThread extends Thread {
	public MyThread(String name) {
		super(name); //Thread 클래스의 생성자 호출
	}

	@Override
	public void run() {
		for (int i = 1; i <= 5; i++) {
			System.out.println(Thread.currentThread().getName() + "==> " + i);
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
