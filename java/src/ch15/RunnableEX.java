package ch15;

public class RunnableEX implements Runnable {
	@Override
	public void run() {
		for (int i = 1; i <= 100; i++) {
			System.out.println(Thread.currentThread().getName() + "==>" + i);
//			try {
//				Thread.sleep(100);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
		}
	}

	public static void main(String[] args) {
		RunnableEX e1 = new RunnableEX();
				 // new Thread(Runnable 객체, 스레드이름)
		Thread t1 = new Thread(e1, "Thread 1");
		Thread t2 = new Thread(e1, "Thread 2");
		t1.start();
		t2.start();
	}
}
