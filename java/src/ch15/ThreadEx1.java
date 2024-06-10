package ch15;

public class ThreadEx1 extends Thread {// 상위 Thread로부터 상속받음
	public ThreadEx1(String name) {
		super(name); // Thread 클래스의 생성자
		// this.멤버 : 현재 클래스의 멤버, this() : 현재 클래스의 생성자
		// super.멤버 : 상위 클래스의 멤버 , super() : 상위 클래스의 생성자
	}

	@Override
	public void run() {
		for (int i = 1; i < 9; i++) {
			System.out.println(Thread.currentThread().getName() + ": " + i);
//			try {
//				Thread.sleep(1000);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
		}
	}

	public static void main(String[] args) {
		ThreadEx1 e1 = new ThreadEx1("Thread 1");
		ThreadEx1 e2 = new ThreadEx1("Thread 2");
		ThreadEx1 e3 = new ThreadEx1("Thread 3");
		e1.start();// run()이 실행됨
		e2.start();
		e3.start();
		//e1.run();
	}
}
