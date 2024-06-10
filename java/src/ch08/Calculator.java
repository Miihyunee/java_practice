package ch08;

public class Calculator {
	// 외부사용금지
	private int left;
	private int right;

	// 리턴타입 없음, 클래스이름과 같음, new 클래스 이름() → 생성자 호출됨
	public Calculator() {
		System.out.println("생성자 호출....");
	}

	public Calculator(int left, int right) {
		this.left = left;
		this.right = right;
	}

	// 변수 값 읽는 함수
	public int getLeft() {
		return left;
	}

	// 변수 값 저장하는 함수
	public void setLeft(int left) {
		this.left = left;
	}

	public int getRight() {
		return right;
	}

	public void setRight(int right) {
		this.right = right;
	}

	public void sum() {
		System.out.println(left + right);
	}

	public void avg() {
		System.out.println((left + right) / 2);
	}
}
