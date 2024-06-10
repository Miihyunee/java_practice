package ch11;

public abstract class AbstractClass {//추상 클래스
	// abstract → 추상(완성되지 않은)
	abstract void method1(); // 완성되지 않은 함수
	// void method1() → header, {} → body

	void method2() {
		System.out.println("완성된 코드");
	}
}

// abstract class 추상 클래스 : 1개 이상의 abstract method(추상 메서드)가 있는 것